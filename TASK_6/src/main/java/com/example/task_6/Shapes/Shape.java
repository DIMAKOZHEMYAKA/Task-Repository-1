package com.example.task_6.Shapes;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public abstract class Shape implements Cloneable {
    //параметры фигуры - приватные поля
    protected Color color, colorStroke;
    protected double x, y;

    // объявление абстрактных методов
    public abstract double area();

    public abstract void draw(GraphicsContext gr);

    // конструктор
    public Shape(Color color, Color colorStroke, double x, double y) {
        //System.out.println("Shape constructor called");
        this.color = color;
        this.colorStroke = colorStroke;
        this.x = x;
        this.y = y;
    }

    // реализация методов
    public void setColor(Color color) {
        this.color = color;
    }

    public void setColorStroke(Color colorStroke) {
        this.colorStroke = colorStroke;
    }

    public void setXY(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public Object clone() {
        Object clone = null;
        try {
            clone = super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return clone;
    }

    public abstract void drawAtCursor(GraphicsContext gr, double cursorX, double cursorY);

    public abstract double[] getSize();

    public abstract double setSize(double size);
}