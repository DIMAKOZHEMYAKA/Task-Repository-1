package com.example.task1;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

class Hexagon extends Shape {
    private double sideLength;
    private Color ColorStroke;

    public Hexagon(Color color, Color ColorStroke,double x, double y, double sideLength) {
        super(color, x, y);
        this.ColorStroke = ColorStroke;
        this.sideLength = sideLength;
    }

    @Override
    double area() {
        return ((3 * Math.sqrt(3)) / 2) * sideLength * sideLength;
    }

    @Override
    void draw(GraphicsContext gc) {
        gc.setStroke(ColorStroke);
        gc.setFill(color);
        double angle = Math.PI / 3;
        double[] xPoints = new double[6];
        double[] yPoints = new double[6];

        for (int i = 0; i < 6; i++) {
            xPoints[i] = x + sideLength * Math.cos(i * angle);
            yPoints[i] = y + sideLength * Math.sin(i * angle);
        }
        gc.fillPolygon(xPoints, yPoints, 6);
        gc.strokePolygon(xPoints, yPoints, 6);
    }


}