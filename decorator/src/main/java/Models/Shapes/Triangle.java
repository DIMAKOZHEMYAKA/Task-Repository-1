package Models.Shapes;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

class Triangle extends Shape {
    private double sideLength;

    public Triangle(Color color, Color ColorStroke,double x, double y, double sideLength) {
        super(color, x, y);
        this.colorStroke = colorStroke;
        this.sideLength = sideLength;
    }

    public double[] getPointsX() {
        return new double[]{
                x, // верхняя вершина
                x - sideLength / 2, // левая нижняя вершина
                x + sideLength / 2  // правая нижняя вершина
        };
    }

    public double[] getPointsY() {
        return new double[]{
                y - sideLength * Math.sqrt(3) / 4, // верхняя вершина (высота треугольника)
                y + sideLength * Math.sqrt(3) / 4, // левая нижняя вершина
                y + sideLength * Math.sqrt(3) / 4  // правая нижняя вершина
        };
    }

    @Override
    double area() {
        return (Math.sqrt(3) / 4) * sideLength * sideLength;
    }
    private double area(double x1, double y1, double x2, double y2, double x3, double y3) {
        return Math.abs((x1 * (y2 - y3) + x2 * (y3 - y1) + x3 * (y1 - y2)) / 2.0);
    }


    @Override
    public void draw(GraphicsContext gc) {
        gc.setStroke(colorStroke);
        gc.setFill(color);
        double[] xPoints = getPointsX();
        double[] yPoints = getPointsY();
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

    public boolean contains(double clickX, double clickY) {
        double height = (Math.sqrt(3) / 2) * sideLength;
        double[] xPoints = {x, x - sideLength / 2, x + sideLength / 2};
        double[] yPoints = {y, y + height, y + height};

        // Получаем координаты вершин треугольника
        double x1 = xPoints[0], y1 = yPoints[0];
        double x2 = xPoints[1], y2 = yPoints[1];
        double x3 = xPoints[2], y3 = yPoints[2];

        // Вычисляем площади треугольников, образованных точкой и вершинами
        double A = area(x1, y1, x2, y2, x3, y3); // Площадь основного треугольника
        double A1 = area(clickX, clickY, x2, y2, x3, y3); // Площадь треугольника 1
        double A2 = area(x1, y1, clickX, clickY, x3, y3); // Площадь треугольника 2
        double A3 = area(x1, y1, x2, y2, clickX, clickY); // Площадь треугольника 3

        // Если сумма площадей A1, A2, A3 равна площади A, точка внутри треугольника
        return Math.abs(A - (A1 + A2 + A3)) < 0.0001;
    }

}