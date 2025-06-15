package linker;


import Models.Shapes.Decorate;
import javafx.scene.paint.Color;

public class Component {
    protected Decorate decorate;
    protected Color colorStroke;
    protected double[] xy;

    public Component(Decorate decor) {
        this.decorate = decor;
        colorStroke = decorate.getShape().getColorStroke();
    }

    public Decorate getDecorate() {
        return decorate;
    }
}