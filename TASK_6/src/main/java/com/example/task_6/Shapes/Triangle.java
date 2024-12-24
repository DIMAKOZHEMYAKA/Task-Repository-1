package com.example.task_6.Shapes;


import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class Triangle extends Shape {
    private double sideLength;

    public Triangle(Color color, Color colorStroke, double x, double y, double sideLength) {
        super(color, colorStroke, x, y);
        this.sideLength = sideLength;
    }

    @Override
    public double area() {
        return (Math.sqrt(3) / 4) * sideLength * sideLength;
    }

    @Override
    public void draw(GraphicsContext gr) {
        double height = Math.sqrt(3) / 2 * sideLength;
        double[] xPoints = { x, x - sideLength / 2, x + sideLength / 2 };
        double[] yPoints = { y - height / 2, y + height / 2, y + height / 2 };

        gr.setFill(color);
        gr.setStroke(colorStroke);
        gr.fillPolygon(xPoints, yPoints, 3);
        gr.strokePolygon(xPoints, yPoints, 3);
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
