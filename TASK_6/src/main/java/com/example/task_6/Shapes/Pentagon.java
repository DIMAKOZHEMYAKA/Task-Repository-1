package com.example.task_6.Shapes;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class Pentagon extends Shape {
    private double radius;

    public Pentagon(Color color, Color colorStroke, double x, double y, double radius) {
        super(color, colorStroke, x, y);
        this.radius = radius;
    }

    @Override
    public double area() {
        return (5 / 4.0) * Math.tan(Math.toRadians(54)) * radius * radius;
    }

    @Override
    public void draw(GraphicsContext gr) {
        double[] xPoints = new double[5];
        double[] yPoints = new double[5];

        for (int i = 0; i < 5; i++) {
            double angle = Math.toRadians(72 * i - 54);
            xPoints[i] = x + radius * Math.cos(angle);
            yPoints[i] = y + radius * Math.sin(angle);
        }

        gr.setFill(color);
        gr.setStroke(colorStroke);
        gr.fillPolygon(xPoints, yPoints, 5);
        gr.strokePolygon(xPoints, yPoints, 5);
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
        this.radius = size;
        return this.radius;
    }
}