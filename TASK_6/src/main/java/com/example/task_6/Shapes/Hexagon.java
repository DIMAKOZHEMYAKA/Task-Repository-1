package com.example.task_6.Shapes;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class Hexagon extends Shape {
    private double radius;
    private Color ColorStroke;

    public Hexagon(Color color, Color ColorStroke,double x, double y, double radius) {
        super(color,ColorStroke, x, y);

        this.radius = radius;
    }

    @Override
    public double area() {
        return ((3 * Math.sqrt(3)) / 2) * radius * radius;

    }

    @Override
    public void draw(GraphicsContext gr) {
        double[] xPoints = new double[6];
        double[] yPoints = new double[6];

        for (int i = 0; i < 6; i++) {
            double angle = Math.toRadians(60 * i - 30); // Угол для каждой вершины
            xPoints[i] = x + radius * Math.cos(angle);
            yPoints[i] = y + radius * Math.sin(angle);
        }

        gr.setFill(color);
        gr.setStroke(colorStroke);
        gr.fillPolygon(xPoints, yPoints, 6);
        gr.strokePolygon(xPoints, yPoints, 6);
    }

    @Override
    public void drawAtCursor(GraphicsContext gr, double cursorX, double cursorY) {
        this.x = cursorX;
        this.y = cursorY;
        draw(gr);
    }

    @Override
    public double[] getSize() {
        // Возвращаем координаты центра шестиугольника
        return new double[] { x, y };
    }

    @Override
    public double setSize(double size) {
        return 0;
    }


}