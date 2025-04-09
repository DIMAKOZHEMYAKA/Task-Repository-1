package Shapes;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

class Square extends Shape {
    private double side;
    private Color ColorStroke;

    public Square(Color color, Color ColorStroke, double x, double y, double side) {
        super(color, x, y);
        this.ColorStroke = ColorStroke;
        this.side = side;
    }

    @Override
    double area() {
        return side * side;
    }

    @Override
    void draw(GraphicsContext gc) {
        gc.setStroke(ColorStroke);
        gc.setFill(color);
        gc.fillRect(x, y, side,side);
        gc.strokeRect(x, y, side,side);
    }
}