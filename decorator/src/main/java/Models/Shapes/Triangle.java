package Models.Shapes;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

class Triangle extends Shape {
    private double sideLength;
    private Color ColorStroke;

//    public Triangle(Color color, Color ColorStroke,double x, double y, double sideLength) {
//        super(color, x, y);
//        this.ColorStroke = ColorStroke;
//        this.sideLength = sideLength;
//    }
//
//    @Override
//    double area() {
//        return (Math.sqrt(3) / 4) * sideLength * sideLength;
//    }
//
//    @Override
//    public void draw(GraphicsContext gc) {
//        gc.setStroke(ColorStroke);
//        gc.setFill(color);
//        double height = (Math.sqrt(3) / 2) * sideLength;
//        double[] xPoints = {x, x - sideLength / 2, x + sideLength / 2};
//        double[] yPoints = {y, y + height, y + height};
//        gc.fillPolygon(xPoints, yPoints, 3);
//        gc.strokePolygon(xPoints, yPoints, 3);
//    }
//
//    @Override
//    public double[] getBounds() {
//        double height = sideLength * Math.sqrt(3) / 2;
//        return new double[]{sideLength, height};
//    }

    public Triangle(Color color, Color colorStroke, double x, double y, double size) {
        super(color, colorStroke, x, y);
        this.colorStroke = colorStroke;
        this.size = size;
    }

    public double[] getPointsX() {
        return  new double[]{
                x, // верхняя вершина
                x - sideLength / 2, // левая нижняя вершина
                x + sideLength / 2  // правая нижняя вершина
        };
    }

    public double[] getPointsY() {
        return  new double[]{
                y - sideLength * Math.sqrt(3) / 4, // верхняя вершина (высота треугольника)
                y + sideLength * Math.sqrt(3) / 4, // левая нижняя вершина
                y + sideLength * Math.sqrt(3) / 4  // правая нижняя вершина
        };
    }

    @Override
    public void draw(GraphicsContext gr) {
        gr.setStroke(colorStroke);
        gr.setLineWidth(2);

        gr.fillPolygon(getPointsX(), getPointsY(), 3);
        gr.strokePolygon(getPointsX(), getPointsY(), 3);
    }
    public double area() {
        int n = 3;
        double[] xCoords = {x + 10, x + (18 * sideLength), x + (30 * sideLength)};
        double[] yCoords = {y + (20 * sideLength), y + (10 * sideLength), y + (20 * sideLength)};
        double area = 0.0;
        for (int i = 0; i < n - 2; i++) {
            int v1 = 0;
            int v2 = i + 1;
            int v3 = i + 2;
            double triangleArea = Math.abs(
                    0.5
                            * (xCoords[v1] * (yCoords[v2] - yCoords[v3])
                            + xCoords[v2]
                            * (yCoords[v3] - yCoords[v1])
                            + xCoords[v3]
                            * (yCoords[v1] - yCoords[v2])));
            area += triangleArea;
        }
        System.out.println("Площадь треугольника: " + area);
        return area;
    }
    @Override
    public double[] getBounds() {
        return new double[]{sideLength * Math.sqrt(3) / 4, sideLength * Math.sqrt(3) / 2};
    }

}