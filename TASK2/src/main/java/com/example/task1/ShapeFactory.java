package com.example.task1;

import javafx.scene.paint.Color;

public class ShapeFactory {
    public Shape createShape(int numberOfSides, Color color, Color colorStroke, double x, double y, double size) {
        switch (numberOfSides) {
            case 6:
                return new Hexagon(color, colorStroke, x, y, size);
            case 5:
                return new Pentagon(color, colorStroke, x, y, size);
            case 4:
                return new Square(color, colorStroke, x, y, size);
            case 3:
                return new Triangle(color, colorStroke, x, y, size);
            case 0:
                return new Circle(color, colorStroke, x, y, size);
            default:
                return null;
        }
    }
}