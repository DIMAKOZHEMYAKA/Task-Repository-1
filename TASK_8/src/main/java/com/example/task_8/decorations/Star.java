package com.example.task_8.decorations;

import com.example.task_8.christmas_tree.Tree;
import com.example.task_8.christmas_tree.TreeDecorator;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.*;

public class Star extends TreeDecorator {
    Polygon star;
    public Star(Tree tree){
        super(tree);
    }

    @Override
    public void draw(Pane pane) {
        super.draw(pane);
        drawStar(pane);
    }
    @Override
    public void remove(Pane pane){
        super.remove(pane);
        deleteStar(pane);
    }
    private void drawStar(Pane pane) {
        // Создаем звезду на вершине елки
        star = new Polygon();
        star.getPoints().addAll(
                200.0, 30.0,  // Верхняя точка звезды
                190.0, 50.0,
                170.0, 50.0,
                185.0, 65.0,
                180.0, 85.0,
                200.0, 75.0,
                220.0, 85.0,
                215.0, 65.0,
                230.0, 50.0,
                210.0, 50.0
        );
        star.setFill(Color.YELLOW);
        star.setStroke(Color.GOLD);

        // Добавляем звезду на панель
        pane.getChildren().add(star);
    }

    private void deleteStar(Pane pane){
        pane.getChildren().removeAll(star);
    }
}


