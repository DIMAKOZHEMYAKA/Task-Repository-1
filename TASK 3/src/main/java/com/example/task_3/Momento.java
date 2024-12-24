package com.example.task_3;

import javafx.scene.paint.Color;
import javafx.scene.shape.Shape;

public class Momento {

    private Shape snape;

    private double width;

    private Color color;

//сделать снимок

    public Momento(Shape state) {

        this.snape = state;

        width = snape.getStrokeWidth();

        color = (Color) snape.getStroke();

    }

//вернуть первоначальные свойства

    public Shape getState() {

        snape.setStrokeWidth(width);

        snape.setStroke(color);

        return snape;

    }

    public Shape initState() {

        snape.setStrokeWidth(2);

        snape.setStroke(Color.RED);

        return snape;
    }
}