package Models.Shapes;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public abstract class Shape implements Cloneable {
    protected Color color;
    protected Color colorStroke;
    protected double x, y;

    public Shape(Color color, double x, double y) {
        this.color = color;
        this.x = x;
        this.y = y;
    }

    abstract double area();
    public abstract void draw(GraphicsContext gc);

    public void setColor(Color color) {
        this.color = color;
    }

    public Color getColorStroke() {
        return colorStroke;
    }

    public void setColorStroke(Color colorStroke) {
        this.colorStroke = colorStroke;
    }

    public void setXY(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public abstract void setSize(double size);

    public Object clone() {
        Object clone = null;
        try {
            clone = super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return clone;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }
    public abstract double[] getBounds();

    public abstract boolean contains(double clickX, double clickY);
}

