package com.example.task_8.christmas_tree;

import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Polygon;

public class TreeImpl implements Tree {
    @Override
    public void draw(Pane pane) {

        Polygon tree = new Polygon();
        tree.getPoints().addAll(
                200.0, 50.0,
                100.0, 200.0,
                140.0, 200.0,
                80.0, 300.0,
                120.0, 300.0,
                60.0, 400.0,
                340.0, 400.0,
                280.0, 300.0,
                320.0, 300.0,
                260.0, 200.0,
                300.0, 200.0
        );

        tree.setFill(Color.GREEN);
        tree.setStroke(Color.DARKGREEN);

        pane.getChildren().add(tree);

        Polygon trunk = new Polygon();
        trunk.getPoints().addAll(
                160.0, 400.0,
                240.0, 400.0,
                240.0, 500.0,
                160.0, 500.0
        );
        trunk.setFill(Color.BROWN);
        trunk.setStroke(Color.SADDLEBROWN);

        pane.getChildren().add(trunk);
    }

    @Override
    public void remove(Pane pane) {

    }

    @Override
    public String decorate() {
        return "Елка";
    }

}
