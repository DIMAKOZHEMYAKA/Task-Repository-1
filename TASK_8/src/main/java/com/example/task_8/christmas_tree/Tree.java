package com.example.task_8.christmas_tree;

import javafx.scene.layout.Pane;

public interface Tree {
    void draw(Pane pane);
    void remove(Pane pane);
    String decorate();
}