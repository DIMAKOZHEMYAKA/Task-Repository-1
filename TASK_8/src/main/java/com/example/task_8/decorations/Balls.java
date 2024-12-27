package com.example.task_8.decorations;

import com.example.task_8.christmas_tree.Tree;
import com.example.task_8.christmas_tree.TreeDecorator;
import javafx.animation.FillTransition;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.util.Duration;

public class Balls extends TreeDecorator {
    FillTransition ft;

    public Balls(Tree tree){
        super(tree);
    }
    Circle ball1;
    Circle ball2;
    Circle ball3;
    Circle ball4;
    @Override
    public void draw(Pane pane) {
        super.draw(pane);
        drawBalls(pane);
    }
    @Override
    public void remove(Pane pane){
        super.remove(pane);
        deleteBalls(pane);
    }
    private void drawBalls(Pane pane) {
        // Создаем массив шариков (украшений)
        Circle ball1 = new Circle(180, 120, 10);
        Circle ball2 = new Circle(220, 160, 10);
        Circle ball3 = new Circle(160, 240, 10);
        Circle ball4 = new Circle(240, 280, 10);

        ball1.setFill(Color.RED);
        ball2.setFill(Color.YELLOW);
        ball3.setFill(Color.BLUE);
        ball4.setFill(Color.PINK);

        pane.getChildren().addAll(ball1, ball2, ball3, ball4);


        createBlinkingEffect(ball1);
        createBlinkingEffect(ball2);
        createBlinkingEffect(ball3);
        createBlinkingEffect(ball4);
    }
    private void createBlinkingEffect(Circle ornament) {
        ft = new FillTransition(Duration.seconds(1), ornament);
        ft.setFromValue((Color) ornament.getFill());
        ft.setToValue(Color.WHITE);
        ft.setCycleCount(FillTransition.INDEFINITE);
        ft.setAutoReverse(true);
        ft.play();
    }
    private void deleteBalls(Pane pane){
        pane.getChildren().removeAll(ball1,ball2,ball3,ball4);
    }
}
