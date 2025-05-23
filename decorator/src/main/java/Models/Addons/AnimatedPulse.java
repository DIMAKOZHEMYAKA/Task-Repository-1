package Models.Addons;

import Models.Shapes.Decorate;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.canvas.GraphicsContext;
import javafx.util.Duration;

public class AnimatedPulse implements Addon {
    private final Decorate decorate;
    private double currentScale = 1.0;
    private final Timeline animation;

    public AnimatedPulse(Decorate decorate) {
        this.decorate = decorate;

        this.animation = new Timeline(
                new KeyFrame(Duration.ZERO, e -> currentScale = 1.0),
                new KeyFrame(Duration.seconds(0.5), e -> currentScale = 1.1),
                new KeyFrame(Duration.seconds(1), e -> currentScale = 1.0)
        );
        animation.setCycleCount(Animation.INDEFINITE);
    }

    public void startAnimation() {
        animation.play();
    }

    public void stopAnimation() {
        animation.stop();
    }

    @Override
    public void draw(GraphicsContext gr) {
        gr.save();
        gr.translate(decorate.getShape().getX(), decorate.getShape().getY());
        gr.scale(currentScale, currentScale);
        gr.translate(-decorate.getShape().getX(), -decorate.getShape().getY());

        decorate.getShape().draw(gr);
        gr.restore();
    }
}