package Models.Shapes;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public abstract class Shape implements Cloneable {
    protected Color color;
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

    public void setColorStroke(Color colorStroke) {
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
}

