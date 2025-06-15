package Models.Shapes;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

class Circle extends Shape {
    private double radius;

    public Circle(Color color,Color colorStroke, double x, double y, double radius) {
        super(color, x, y);
        this.colorStroke = colorStroke;
        this.radius = radius;
    }

    @Override
    double area() {
        return Math.PI * radius * radius;
    }

    @Override
    public void draw(GraphicsContext gc) {
        gc.setStroke(colorStroke);
        gc.setFill(color);
        gc.fillOval(x - radius, y - radius, radius * 2, radius * 2);
        gc.strokeOval(x - radius, y - radius, radius * 2, radius * 2);
    }

    @Override
    public void setSize(double size) {
        this.radius = size;
    }

    @Override
    public double[] getBounds() {
        return new double[]{2 * radius, 2 * radius};
    }
    @Override
    public String toString(){
        return "Круг";
    }

    @Override
    public boolean contains(double clickX, double clickY) {
        // Вычисляем расстояние от центра круга до точки
        double distanceSquared = Math.pow(clickX - x, 2) + Math.pow(clickY - y, 2);

        // Сравниваем с квадратом радиуса (оптимизация - избегаем вычисления квадратного корня)
        return distanceSquared <= radius * radius;
    }
}