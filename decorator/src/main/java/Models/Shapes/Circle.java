package Models.Shapes;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

class Circle extends Shape {
    private double radius;
    private Color ColorStroke;

    public Circle(Color color,Color ColorStroke, double x, double y, double radius) {
        super(color, x, y);
        this.ColorStroke = ColorStroke;
        this.radius = radius;
    }

    @Override
    double area() {
        return Math.PI * radius * radius;
    }

    @Override
    public void draw(GraphicsContext gc) {
        gc.setStroke(ColorStroke);
        gc.setFill(color);
        gc.fillOval(x - radius, y - radius, radius * 2, radius * 2);
        gc.strokeOval(x - radius, y - radius, radius * 2, radius * 2);
    }

    @Override
    public double[] getBounds() {
        return new double[]{2 * radius, 2 * radius};
    }

}