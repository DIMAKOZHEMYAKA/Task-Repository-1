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
        Decorate decoratedShape = new Decorate(shape, fillColor, effectShape.getEffect(effectType));
        List<Addon> addons = new ArrayList<>();
        if (pulseCheckBox.isSelected()) {
            AnimatedPulse pulse = new AnimatedPulse(decoratedShape);
            pulse.startAnimation();
            addons.add(pulse);
        }
        if (patternCheckBox.isSelected()) {
            addons.add(new PatternFill(decoratedShape, 10));
        }
        if (splitCheckBox.isSelected()) {
            addons.add(new Split(decoratedShape));
        }
        canvas.toFront();
        momento.push(decoratedShape);
    }


    @FXML
    private void clearCanvas() {
        canvas.getGraphicsContext2D().clearRect(0, 0, canvas.getWidth(), canvas.getHeight());
    }

    @FXML
    private void undoLast() {
        if (momento.getSize() > 1) {
            GraphicsContext gc = canvas.getGraphicsContext2D();
            gc.setEffect(null);
            gc.clearRect(0, 0, canvas.getWidth(), canvas.getHeight());
            momento.poll();
            for (Object item : momento.getListShapes()) {  ((Decorate) item).draw(gc);    }
        } else {
            clearCanvas();
        }
        canvas.toFront();
    }

}