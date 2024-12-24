package com.example.task_6;

import com.example.task_6.Shapes.*;
import javafx.scene.paint.Color;


import java.util.HashMap;

public class ShapeMap {
    private HashMap<Integer, Shape> shapes;

    public ShapeMap() {
        shapes = new HashMap<>();
        shapes.put(0, new Circle(Color.BLACK, Color.BLACK, 0, 0, 0));
        shapes.put(1, new Hexagon(Color.BLACK, Color.BLACK,0,0,0));
        shapes.put(2, new Triangle(Color.BLACK, Color.BLACK, 0, 0, 0));
        shapes.put(3, new Rectangle(Color.BLACK, Color.BLACK, 0, 0, 0));
        shapes.put(4, new Pentagon(Color.BLACK, Color.BLACK, 0, 0, 0));

    }

    public Shape createShape(int index, Color color, Color colorStroke, double x, double y, double size) {
        Shape shape = shapes.get(index);
        shape.setColor(color);
        shape.setColorStroke(colorStroke);
        shape.setXY(x, y);
        shape.setSize(size);
        return shape;
    }
}

