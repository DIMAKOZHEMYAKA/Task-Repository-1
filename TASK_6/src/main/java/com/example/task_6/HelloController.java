package com.example.task_6;

import com.example.task_6.Shapes.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.util.Callback;
import java.net.URL;
import java.util.HashMap;
import java.util.ResourceBundle;

public class HelloController implements Initializable {
    @FXML
    Canvas canvas;
    @FXML
    ColorPicker colorPicker, colorPickerStroke;
    @FXML
    TextField fieldSize;
    @FXML
    Label textLast;
    @FXML
    ListView listView;
    private ObservableList<Shape> items;
    private HashMap<Class, String> shapeName = new HashMap<>();
    private Momento momento = new Momento();

    public void initialize(URL location, ResourceBundle resources) {
        Rectangle rectangle = new Rectangle(Color.BLACK, Color.BLACK, 20, 20, 30);
        Circle circle = new Circle(Color.BLACK, Color.BLACK, 20, 20, 30);
        Triangle triangle = new Triangle(Color.BLACK, Color.BLACK, 20, 20, 20);
        Pentagon pentagon = new Pentagon(Color.BLACK, Color.BLACK, 20, 20, 20);
        Hexagon hexagon = new Hexagon(Color.BLACK, Color.BLACK, 20, 20, 20);
        items = FXCollections.observableArrayList(circle,hexagon, triangle, rectangle, pentagon);
        shapeName.put(Circle.class, "Круг");
        shapeName.put(Hexagon.class, "Шестиугольник");
        shapeName.put(Triangle.class, "Треугольник");
        shapeName.put(Rectangle.class, "Прямоугольник");
        shapeName.put(Pentagon.class, "Пятиугольник");
        listView.setCellFactory((Callback<ListView<Shape>, ListCell<Shape>>) _ -> new CellList());
        listView.setItems(items);
        listView.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
    }

    @FXML
    protected void buttonCLear() {
        momento = new Momento();
        GraphicsContext graphicsContext = canvas.getGraphicsContext2D();
        graphicsContext.clearRect(0, 0, canvas.getWidth(), canvas.getHeight());
        textLast.setText("Пусто");
        System.out.println("Очищено\n");
    }

    public void drawShape(MouseEvent mouseEvent) {
        GraphicsContext gc = canvas.getGraphicsContext2D();
        int index = listView.getSelectionModel().getSelectedIndex(); //получение индекса выбора из списка
        Shape shape = (Shape) items.get(index).clone(); // создание копии фигуры
        shape.setColor(colorPicker.getValue()); // установка цвета заполнения фигуры по значению элемента управления colorPicker
        shape.setColorStroke(colorPickerStroke.getValue());
        shape.setXY(mouseEvent.getX(), mouseEvent.getY());
        if (!fieldSize.getText().isEmpty()) {
            try {
                double size = Double.parseDouble(fieldSize.getText());
                shape.setSize(size);
            } catch (NumberFormatException e) {
                System.out.println("Неверный формат");
            }
        }
        momento.push(shape);
        for (Shape item : momento.getListShapes()) {
            item.draw(gc);
        }
        textLast.setText(shapeName.get(shape.getClass()));
    }

    public void buttonUndo() {
        GraphicsContext gc = canvas.getGraphicsContext2D();
        gc.clearRect(0, 0, canvas.getWidth(), canvas.getHeight());
        momento.poll();
        for (Shape item : momento.getListShapes()) {
            item.draw(gc);
        }
        if (momento.getSize() == 0)
            textLast.setText("Ничего не нарисовано");
    }
}
