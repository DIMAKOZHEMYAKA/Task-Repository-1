package com.example.task_8.decorations;

import com.example.task_8.christmas_tree.Tree;
import com.example.task_8.christmas_tree.TreeDecorator;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Presents extends TreeDecorator {
    public Presents(Tree tree) {
        super(tree);
    }
    Rectangle gift1;
    Rectangle gift2;
    Rectangle gift3;
    @Override
    public void draw(Pane pane) {
        super.draw(pane);
        drawPresents(pane);
    }
    @Override
    public void remove(Pane pane){
        super.remove(pane);
        deletePresents(pane);
    }
    private void drawPresents(Pane pane) {

        gift1 = new Rectangle(100, 450, 50, 50);
        gift1.setFill(Color.RED);
        gift1.setStroke(Color.BLACK);

        gift2 = new Rectangle(170, 460, 60, 40);
        gift2.setFill(Color.BLUE);
        gift2.setStroke(Color.BLACK);

        gift3 = new Rectangle(250, 450, 70, 50);
        gift3.setFill(Color.GOLD);
        gift3.setStroke(Color.BLACK);

        pane.getChildren().addAll(gift1, gift2, gift3);
    }

    private void deletePresents(Pane pane) {
        pane.getChildren().removeAll(gift1, gift2, gift3);
        gift1 = null;
        gift2 = null;
        gift3 = null;
    }
}
