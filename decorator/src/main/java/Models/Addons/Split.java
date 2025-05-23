package Models.Addons;

import Models.Shapes.Decorate;
import javafx.scene.canvas.GraphicsContext;

public class Split implements Addon {
    protected Decorate decorate;

    public Split(Decorate decorate) {
        this.decorate = decorate;
    }

    public void draw(GraphicsContext gr) {
        for (int i = 0; i < 4; i++) {
            double angle = Math.toRadians(90 * i);
            double endX = decorate.getShape().getX() + decorate.getShape().getBounds()[0]/2 * Math.cos(angle);
            double endY = decorate.getShape().getY() + decorate.getShape().getBounds()[1]/2 * Math.sin(angle);
            gr.strokeLine(decorate.getShape().getX(), decorate.getShape().getY(), endX, endY);
        }
    }
}