package com.example.task_6.Shapes;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class Circle extends Shape {
    private double diameter;
    double radius;

    public Circle(Color color, Color colorStroke, double x, double y, double diameter) {
        super(color, colorStroke, x, y);
        this.diameter = diameter;
        radius = this.diameter / 2;
    }

    @Override
    public double area() {
        return Math.PI * radius * radius;
    }

    @Override
    public void draw(GraphicsContext gr) {
        gr.setFill(color);
        gr.setStroke(colorStroke);
        gr.fillOval(x - radius, y - radius, 2 * radius, 2 * radius);
        gr.strokeOval(x - radius, y - radius, 2 * radius, 2 * radius);
    }

    @Override
    public void drawAtCursor(GraphicsContext gr, double cursorX, double cursorY) {
        this.x = cursorX;
        this.y = cursorY;
        draw(gr);
    }

    @Override
    public String toString() {
        return "Цвет круга: " + super.color + "; цвет границы: " + colorStroke + "; площадь: " + area();
    }

    @Override
    public double[] getSize() {
        return new double[]{radius, radius};
    }

    @Override
    public double setSize(double size) {
        return diameter = size;
    }
}
