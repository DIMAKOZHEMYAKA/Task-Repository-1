package Models.Shapes;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

class Triangle extends Shape {
    private double sideLength;
    private Color ColorStroke;

    public Triangle(Color color, Color ColorStroke,double x, double y, double sideLength) {
        super(color, x, y);
        this.ColorStroke = ColorStroke;
        this.sideLength = sideLength;
    }

    @Override
    double area() {
        return (Math.sqrt(3) / 4) * sideLength * sideLength;
    }

    @Override
    public void draw(GraphicsContext gc) {
        gc.setStroke(ColorStroke);
        gc.setFill(color);
        double height = (Math.sqrt(3) / 2) * sideLength;
        double[] xPoints = {x, x - sideLength / 2, x + sideLength / 2};
        double[] yPoints = {y, y + height, y + height};
        gc.fillPolygon(xPoints, yPoints, 3);
        gc.strokePolygon(xPoints, yPoints, 3);
    }

    @Override
    public void setSize(double size) {
        this.sideLength = size;
    }

    @Override
    public double[] getBounds() {
        double height = sideLength * Math.sqrt(3) / 2;
        return new double[]{sideLength, height};
    }
    public String toString(){
        return "Треугольник";
    }

}