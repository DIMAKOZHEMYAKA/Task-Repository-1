package Shapes;

import javafx.scene.paint.Color;
import javafx.scene.shape.Ellipse;

import java.util.HashMap;

public class ShapeFactory {
    private HashMap<Integer, Shape> shapes;

    public ShapeFactory() {
        shapes = new HashMap<>();
        shapes.put(0, new Circle(Color.BLACK, Color.BLACK, 5, 5, 15));
        shapes.put(1, new Triangle(Color.BLACK, Color.BLACK, 5, 5, 2));
        shapes.put(2, new Square(Color.BLACK, Color.BLACK, 5, 5, 2));
        shapes.put(3, new Pentagon(Color.BLACK, Color.BLACK, 5, 5, 2));
        shapes.put(4, new Hexagon(Color.BLACK, Color.BLACK, 5, 5, 15));

    }

    public Shape createShape(int index) {
        Shape shape = shapes.get(index);
        return shape;
    }
}