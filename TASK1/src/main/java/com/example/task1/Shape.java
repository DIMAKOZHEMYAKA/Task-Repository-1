package com.example.task1;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

abstract class Shape {
    protected Color color;
    protected double x, y;

    public Shape(Color color, double x, double y) {
        this.color = color;
        this.x = x;
        this.y = y;
    }

    abstract double area();
    abstract void draw(GraphicsContext gc);

    public void setColor(Color color) {
        this.color = color;
    }
}

