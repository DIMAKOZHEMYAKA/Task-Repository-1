package Models.Shapes;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

class Hexagon extends Shape {
    private double sideLength;

    public Hexagon(Color color, Color colorStroke,double x, double y, double sideLength) {
        super(color, x, y);
        this.colorStroke = colorStroke;
        this.sideLength = sideLength;
    }

    @Override
    double area() {
        return ((3 * Math.sqrt(3)) / 2) * sideLength * sideLength;
    }

    @Override
    public void draw(GraphicsContext gc) {
        gc.setStroke(colorStroke);
        gc.setFill(color);
        double angle = Math.PI / 3;
        double[] xPoints = new double[6];
        double[] yPoints = new double[6];

        for (int i = 0; i < 6; i++) {
            xPoints[i] = x + sideLength * Math.cos(i * angle);
            yPoints[i] = y + sideLength * Math.sin(i * angle);
        }
        gc.fillPolygon(xPoints, yPoints, 6);
        gc.strokePolygon(xPoints, yPoints, 6);
    }

    @Override
    public void setSize(double size) {
        this.sideLength = size;
    }

    @Override
    public double[] getBounds() {
        double width = 2 * sideLength;
        double height = sideLength * Math.sqrt(3);
        return new double[]{width, height};
    }

    public String toString(){
        return "Шестиугольник";
    }

    @Override
    public boolean contains(double clickX, double clickY) {
        // Вычисляем координаты вершин шестиугольника
        double angle = Math.PI / 3;
        double[] xPoints = new double[6];
        double[] yPoints = new double[6];

        for (int i = 0; i < 6; i++) {
            xPoints[i] = x + sideLength * Math.cos(i * angle);
            yPoints[i] = y + sideLength * Math.sin(i * angle);
        }

        // Алгоритм ray-casting для проверки нахождения точки внутри многоугольника
        boolean inside = false;
        for (int i = 0, j = 5; i < 6; j = i++) {
            double xi = xPoints[i], yi = yPoints[i];
            double xj = xPoints[j], yj = yPoints[j];

            // Проверяем пересечение луча с ребром многоугольника
            boolean intersect = ((yi > clickY) != (yj > clickY))
                    && (clickX < (xj - xi) * (clickY - yi) / (yj - yi) + xi);
            if (intersect) {
                inside = !inside;
            }
        }
        return inside;
    }
}