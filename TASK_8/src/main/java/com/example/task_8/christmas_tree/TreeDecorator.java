package com.example.task_8.christmas_tree;

import javafx.scene.layout.Pane;

public abstract class TreeDecorator implements Tree {
    private Tree tree;

    public TreeDecorator(Tree tree) {
        this.tree = tree;
    }

    @Override
    public void draw(Pane pane) {
        tree.draw(pane);
    }
    @Override
    public void remove(Pane pane) {
        tree.remove(pane);
    }
    @Override
    public String decorate() {
        return tree.decorate();
    }
}
