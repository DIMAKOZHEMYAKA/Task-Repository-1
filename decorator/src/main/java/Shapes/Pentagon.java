package Shapes;

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
        gr.fillPolygon(new double[]{x + 2, x + (7 * sideLength), x + (13 * sideLength), x + (10 * sideLength), x + (3 * sideLength)},
                new double[]{y + (8 * sideLength), y + (2 * sideLength), y + (8 * sideLength), y + (14 * sideLength), y + (14 * sideLength)}, 5);
        gr.strokePolygon(new double[]{x + 2, x + (7 * sideLength), x + (13 * sideLength), x + (10 * sideLength), x + (3 * sideLength)},
                new double[]{y + (8 * sideLength), y + (2 * sideLength), y + (8 * sideLength), y + (14 * sideLength), y + (14 * sideLength)}, 5);
    }

    @Override
    public double area() {
        return 0;
    }
}
