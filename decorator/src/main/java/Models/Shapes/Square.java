package Models.Shapes;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

class Square extends Shape {
    private double sideLength;

    public Square(Color color, Color ColorStroke, double x, double y, double sideLength) {
        super(color, x, y);
        this.colorStroke = ColorStroke;
        this.sideLength = sideLength;
    }

    @Override
    double area() {
        return sideLength * sideLength;
    }

    @Override
    public void draw(GraphicsContext gc) {
        gc.setStroke(colorStroke);
        gc.setFill(color);
        gc.fillRect(x, y, sideLength, sideLength);
        gc.strokeRect(x, y, sideLength, sideLength);
    }

    @Override
    public void setSize(double size) {
        this.sideLength = size;
    }

    @Override
    public double[] getBounds() {
        return new double[]{sideLength, sideLength};
    }
    public String toString(){
        return "Квадрат";
    }

    public boolean contains(double clickX, double clickY) {
        double halfSize = sideLength / 2;
        return clickX >= x - halfSize && clickX <= x + halfSize &&
                clickY >= y - halfSize && clickY <= y + halfSize;
    }
}