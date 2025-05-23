package Models.Shapes;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class Pentagon extends Shape {
    private Color colorStroke;
    private double sideLength;

    public Pentagon(Color color, Color colorStroke, double x, double y, double size) {
        super(color, x, y);
        this.colorStroke = colorStroke;
        this.sideLength = size;
    }

    @Override
    public void draw(GraphicsContext gr) {
        gr.setStroke(colorStroke);
        gr.setFill(color);
        gr.setLineWidth(2);
        double radius = sideLength / (2 * Math.sin(Math.PI / 5));
        int sides = 5;
        double[] xPoints = new double[sides];
        double[] yPoints = new double[sides];

        for (int i = 0; i < sides; i++) {
            double angle = 2 * Math.PI * i / sides - Math.PI / 2;
            xPoints[i] = x + radius * Math.cos(angle);
            yPoints[i] = y + radius * Math.sin(angle);
        }
        gr.fillPolygon(xPoints, yPoints, sides);
        gr.strokePolygon(xPoints, yPoints, sides);
    }

    @Override
    public void setSize(double size) {
        this.sideLength = size;
    }

    @Override
    public double[] getBounds() {
        double radius = sideLength / (2 * Math.sin(Math.PI/5));
        double width = 2 * radius;
        double height = 2 * radius * Math.cos(Math.PI/10);
        return new double[]{width, height};
    }

    @Override
    double area() {
        return (5 * sideLength * sideLength) / (4 * Math.tan(Math.PI / 5));
    }
    public String toString(){
        return "Пятиугольник";
    }
}
