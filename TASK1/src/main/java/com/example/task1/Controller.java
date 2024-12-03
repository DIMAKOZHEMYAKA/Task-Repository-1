package com.example.task1;
import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.TextField;

public class Controller {
    @FXML
    private Canvas canvas;
    @FXML
    private TextField FieldX;
    @FXML
    private TextField FieldY;
    @FXML
    private TextField FieldQuantity;
    @FXML
    private TextField FieldSide;
    @FXML
    private ColorPicker FillColor;
    @FXML
    private ColorPicker BorderColor;

    @FXML
    private void drawRectangle() {
        double x = Double.parseDouble(FieldX.getText());
        double side = Double.parseDouble(FieldSide.getText());
        GraphicsContext gc = canvas.getGraphicsContext2D();
        for(int i = 0; i < Integer.parseInt(FieldQuantity.getText()); i++){
            Square square = new Square(FillColor.getValue(),BorderColor.getValue(),(x + (side * i) + (i * 10)), Double.parseDouble(FieldY.getText()),Double.parseDouble(FieldSide.getText()));
            square.draw(gc);
            System.out.println(square.toString() + "\n");
        }

    }
    @FXML
    private void drawCircle() {
        double x = Double.parseDouble(FieldX.getText());
        double side = Double.parseDouble(FieldSide.getText());
        GraphicsContext gc = canvas.getGraphicsContext2D();
        for(int i = 0; i < Integer.parseInt(FieldQuantity.getText()); i++){
            Circle circle = new Circle(FillColor.getValue(),BorderColor.getValue(),(x + (side * i) + (i * 10)), Double.parseDouble(FieldY.getText()), Double.parseDouble(FieldSide.getText()));
            circle.draw(gc);
            System.out.println(circle.toString() + "\n");
        }
        Circle circle = new Circle(FillColor.getValue(),BorderColor.getValue(),Double.parseDouble(FieldX.getText()), Double.parseDouble(FieldY.getText()), Double.parseDouble(FieldSide.getText()));
        circle.draw(gc);
        System.out.println(circle.toString());
    }

    @FXML
    private void drawTriangle() {
        double x = Double.parseDouble(FieldX.getText());
        double side = Double.parseDouble(FieldSide.getText());
        GraphicsContext gc = canvas.getGraphicsContext2D();
        for(int i = 0; i < Integer.parseInt(FieldQuantity.getText()); i++){
            Triangle triangle = new Triangle(FillColor.getValue(),BorderColor.getValue(),(x + (side * i) + (i * 10)), Double.parseDouble(FieldY.getText()), Double.parseDouble(FieldSide.getText()));
            triangle.draw(gc);
            System.out.println(triangle.toString());
        }
    }

    @FXML
    private void drawHexagon() {
        double x = Double.parseDouble(FieldX.getText());
        double side = Double.parseDouble(FieldSide.getText());
        GraphicsContext gc = canvas.getGraphicsContext2D();
        for(int i = 0; i < Integer.parseInt(FieldQuantity.getText()); i++){
            Hexagon hexagon = new Hexagon(FillColor.getValue(),BorderColor.getValue(),(x + (side * i) + (i * 10)), Double.parseDouble(FieldY.getText()), Double.parseDouble(FieldSide.getText()));
            hexagon.draw(gc);
            System.out.println(hexagon.toString());
        }
    }
    @FXML
    private void Clear() {
        GraphicsContext gc = canvas.getGraphicsContext2D();
        gc.clearRect(0, 0, canvas.getWidth(), canvas.getHeight());
        System.out.println("Очищено\n");
    }
}