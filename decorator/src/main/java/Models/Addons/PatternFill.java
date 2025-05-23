package Models.Addons;

import Models.Shapes.Decorate;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.StrokeLineCap;

public class    PatternFill implements Addon {
    private final Decorate decorate;
    private final double spacing;

    public PatternFill(Decorate decorate, double spacing) {
        this.decorate = decorate;
        this.spacing = spacing;
    }

    @Override
    public void draw(GraphicsContext gr) {
        Paint originalFill = gr.getFill();
        decorate.getShape().draw(gr);

        gr.setStroke(Color.BLACK);
        gr.setLineWidth(1);
        gr.setLineCap(StrokeLineCap.ROUND);

        double[] size = decorate.getShape().getBounds();
        for (double x = 0; x < size[0]; x += spacing) {
            for (double y = 0; y < size[1]; y += spacing) {
                gr.strokeOval(decorate.getShape().getX() + x - 2,
                        decorate.getShape().getY() + y - 2, 4, 4);
            }
        }

        gr.setFill(originalFill);
    }
}