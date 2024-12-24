package com.example.task_6.Shapes;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class Rectangle extends Shape {
    private double sideLength;

    public Rectangle(Color color, Color colorStroke, double x, double y, double sideLength) {
        super(color, colorStroke, x, y);
        this.sideLength = sideLength;
    }

    @Override
    public double area() {
        return sideLength * sideLength;

    }

    @Override
    public void draw(GraphicsContext gr) {
        double[] xPoints = { x - sideLength / 2, x + sideLength / 2, x + sideLength / 2, x - sideLength / 2 };
        double[] yPoints = { y - sideLength / 2, y - sideLength / 2, y + sideLength / 2, y + sideLength / 2 };

        gr.setFill(color);
        gr.setStroke(colorStroke);
        gr.fillPolygon(xPoints, yPoints, 4);
        gr.strokePolygon(xPoints, yPoints, 4);
    }

    @Override
    public void drawAtCursor(GraphicsContext gr, double cursorX, double cursorY) {
        this.x = cursorX;
        this.y = cursorY;
        draw(gr);
    }

    @Override
    public double[] getSize() {
        return new double[] { x, y };
    }

    @Override
    public double setSize(double size) {
        this.sideLength = size;
        return this.sideLength;
    }
}
