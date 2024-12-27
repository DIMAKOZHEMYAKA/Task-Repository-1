package com.example.task_8;

import com.example.task_8.christmas_tree.Tree;
import com.example.task_8.christmas_tree.TreeImpl;
import com.example.task_8.decorations.Balls;
import com.example.task_8.decorations.Presents;
import com.example.task_8.decorations.Star;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;

import java.net.URL;
import java.util.ResourceBundle;

public class HelloController implements Initializable {
    @FXML
    public Pane paneTree;

    @FXML
    private Button ballsButton;
    @FXML
    private Button presentsButton;
    @FXML
    private Button starButton;
    @FXML
    private Label ballsLabel;
    @FXML
    private Label presentLabel;
    @FXML
    private Label starLabel;

    private Tree tree;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        tree = new TreeImpl();
        tree.draw(paneTree);
        ballsButton.setOnAction(this::addBalls);
        presentsButton.setOnAction(this::addPresents);
        starButton.setOnAction(this::addStar);
        ballsLabel.setText("Шарики - нет");
        presentLabel.setText("Подарки - нет");
        starLabel.setText("Звезда - нет");
    }

    public void addBalls(ActionEvent actionEvent) {
            tree = new Balls(tree);
            tree.draw(paneTree);
            ballsLabel.setText("Шарики - есть");
            ballsButton.setOnAction(this::removeBalls);
    }

    public void addPresents(ActionEvent actionEvent) {
            tree = new Presents(tree);
            tree.draw(paneTree);
            presentLabel.setText("Подарки - есть");
            presentsButton.setOnAction(this::removePresents);
    }

    public void addStar(ActionEvent actionEvent) {
            tree = new Star(tree);
            tree.draw(paneTree);
            starLabel.setText("Звезда - есть");
            starButton.setOnAction(this::removeStar);
    }
    @FXML
    public void addAllDecorations(ActionEvent actionEvent) {
        tree = new Balls(tree);
        tree.draw(paneTree);
        ballsButton.setOnAction(this::removeBalls);
        tree = new Presents(tree);
        tree.draw(paneTree);
        presentsButton.setOnAction(this::removePresents);
        tree = new Star(tree);
        tree.draw(paneTree);
        starButton.setOnAction(this::removeStar);
        ballsLabel.setText("Шарики - есть");
        presentLabel.setText("Подарки - есть");
        starLabel.setText("Звезда - есть");
    }

    public void removeBalls(ActionEvent actionEvent){
        tree = new Balls(tree);
        tree.remove(paneTree);
        ballsLabel.setText("Шарики - нет");
        ballsButton.setOnAction(this::addBalls);
    }

    public void removePresents(ActionEvent actionEvent) {
        tree.remove(paneTree);
        presentLabel.setText("Подарки - нет");
        presentsButton.setOnAction(this::addPresents);
    }

    public void removeStar(ActionEvent actionEvent) {
        tree = new Star(tree);
        tree.remove(paneTree);
        starLabel.setText("Звезда - нет");
        starButton.setOnAction(this::addStar);
    }

    public void removeAllDecorations(ActionEvent actionEvent) {
        paneTree.getChildren().clear();
        tree = new TreeImpl();
        tree.draw(paneTree);
        ballsButton.setOnAction(this::addBalls);
        presentsButton.setOnAction(this::addPresents);
        starButton.setOnAction(this::addStar);
        ballsLabel.setText("Шарики - нет");
        presentLabel.setText("Подарки - нет");
        starLabel.setText("Звезда - нет");
    }


}