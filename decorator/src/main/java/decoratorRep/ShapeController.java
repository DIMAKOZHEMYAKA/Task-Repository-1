package decoratorRep;


import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.ColorPicker;

import Models.Shapes.*;
import Models.Effects.*;
import Models.Addons.*;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import linker.Composite;

import java.util.ArrayList;
import java.util.List;

public class ShapeController {
    @FXML private Canvas canvas;
    @FXML private ObservableList<Shape> shapeTypeObserve;
    @FXML private ColorPicker fillColorPicker;
    @FXML private ColorPicker strokeColorPicker;
    @FXML private ComboBox<EffectEnum> effectCombo;
    @FXML private CheckBox pulseCheckBox;
    @FXML private CheckBox patternCheckBox;
    @FXML private CheckBox splitCheckBox;
    @FXML private TextField sizeField;
    private final ShapeFactory shapeFactory = new ShapeFactory();
    private final EffectShape effectShape = new EffectShape();
    @FXML private Momento momento = new Momento();
    @FXML private ListView<Shape> listView;
    private ObservableList<String> listWorkMode;
    @FXML
    private ChoiceBox choiceWorkMode;
    private Composite composite = new Composite();
    private double startX, startY;
    @FXML
    public void initialize() {
        // Заполняю listView типами фигур
        ShapeFactory shapeFactory = new ShapeFactory();
        shapeTypeObserve = FXCollections.observableArrayList(shapeFactory.createShape(0), shapeFactory.createShape(1), shapeFactory.createShape(2),
                shapeFactory.createShape(3), shapeFactory.createShape(4));
        listView.setItems(shapeTypeObserve);

        // Заполняю ComboBox эффектами
        effectCombo.getItems().addAll(EffectEnum.values());
        effectCombo.getSelectionModel().selectFirst();
        listWorkMode = FXCollections.observableArrayList("Рисование", "Выделение", "Перемещение");
        choiceWorkMode.setItems(listWorkMode);
        choiceWorkMode.setValue(listWorkMode.getFirst());
        choiceWorkMode.getSelectionModel().selectedIndexProperty().addListener((_, _, t1) -> setWorkMode(t1.intValue()));
        canvas.setOnMousePressed(this::drawShape);
    }

    @FXML
    private void drawShape(MouseEvent mouseEvent) {
        GraphicsContext gc = canvas.getGraphicsContext2D();
        int index = listView.getSelectionModel().getSelectedIndex(); //получение индекса выбора из списка
        Color fillColor = fillColorPicker.getValue();
        Color strokeColor = strokeColorPicker.getValue();
        EffectEnum effectType = effectCombo.getValue();
        Shape shape = (Shape) shapeTypeObserve.get(index).clone(); // создание копии фигуры
        shape.setColor(fillColor); // установка цвета заполнения фигуры по значению элемента управления colorPicker
        shape.setColorStroke(strokeColor);
        shape.setXY(mouseEvent.getX(), mouseEvent.getY());
        try {
            double size = Double.parseDouble(sizeField.getText());
            shape.setSize(size);
        } catch (NumberFormatException e) {
            System.out.println("Неверный формат данных");
        }

        List<Addon> addons = new ArrayList<>();
        Decorate decoratedShape = new Decorate(shape, fillColor, effectShape.getEffect(effectType));
        if (patternCheckBox.isSelected()) {
            addons.add(new PatternFill(decoratedShape, 10));
            decoratedShape.setAddons(addons);
        }
        if (splitCheckBox.isSelected()) {
            addons.add(new Split(decoratedShape));
            decoratedShape.setAddons(addons);
        }

        canvas.toFront();
        momento.push(decoratedShape);
        decoratedShape.draw(gc);
    }


    @FXML
    private void clearCanvas() {
        canvas.getGraphicsContext2D().clearRect(0, 0, canvas.getWidth(), canvas.getHeight());
    }

    @FXML
    private void undoLast() {
        if (momento.getSize() >= 1) {
            GraphicsContext gc = canvas.getGraphicsContext2D();
            gc.setEffect(null);
            gc.clearRect(0, 0, canvas.getWidth(), canvas.getHeight());
            momento.poll();
            momentoDraw(gc);
        } else {
            clearCanvas();
        }
        canvas.toFront();
    }

    public void setWorkMode(int num) {
        GraphicsContext gc = canvas.getGraphicsContext2D();
        String choice = listWorkMode.get(num);
        if (choice.equals("Рисование")) {
            composite.remove();
            clearBox();
            momentoDraw(gc);
            canvas.setOnMouseDragged(null);
            canvas.setOnMousePressed(this::drawShape);
        } else if (choice.equals("Выделение")) {
            canvas.setOnMouseDragged(null);
            canvas.setOnMousePressed(this::selectShape);
        } else {
            canvas.setOnMouseDragged(this::dragMoveSelectedShape);
            canvas.setOnMousePressed(this::startMoveSelectedShape);
        }
    }

    private void clearBox() {
        GraphicsContext graphicsContext = canvas.getGraphicsContext2D();
        graphicsContext.setFill(null);
        graphicsContext.setEffect(null);
        graphicsContext.clearRect(0, 0, canvas.getWidth(), canvas.getHeight());
    }
    public void selectShape(MouseEvent mouseEvent) {
        Decorate decorate = null;
        for (Decorate item : momento.getMomentoList()) {
            if (item.getShape().contains(mouseEvent.getX(), mouseEvent.getY())) {
                decorate = item;
            }
        }
        if (decorate != null) {
            composite.select(decorate, canvas.getGraphicsContext2D());
            momentoDraw(canvas.getGraphicsContext2D());
        }
    }
    public void startMoveSelectedShape(MouseEvent mouseEvent) {
        startX = mouseEvent.getX();
        startY = mouseEvent.getY();
        composite.saveCoord();
    }
    public void dragMoveSelectedShape(MouseEvent mouseEvent) {
        clearBox();
        composite.changeXY(mouseEvent.getX() - startX, mouseEvent.getY() - startY);
        momentoDraw(canvas.getGraphicsContext2D());
    }
    public void momentoDraw(GraphicsContext gc){
        for (Decorate item : momento.getMomentoList()) {   item.draw(gc);    }
    }

    @FXML
    protected void deleteSelectedShape() {
        ArrayList<Decorate> arrayList = composite.getArray();
        for (Decorate decorate : arrayList) {
            momento.remove(decorate);
        }
        clearBox();
        momentoDraw(canvas.getGraphicsContext2D());
    }
}