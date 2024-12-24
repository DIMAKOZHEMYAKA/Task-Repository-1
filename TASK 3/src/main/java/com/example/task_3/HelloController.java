package com.example.task_3;


import javafx.fxml.FXML;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class HelloController {
    @FXML
    Pane memoPane = new Pane();
    private ArrayList<Shape> shapes;
    private MemoSelect memoSelect;
    Random random = new Random();

public void initialize() {
    initMemoPane();


    memoPane.sceneProperty().addListener((_, _, newScene) -> {
        if (newScene != null) {
            memoPane.layoutBoundsProperty().addListener((_, _, newBounds) -> {
                if (newBounds.getWidth() > 0 && newBounds.getHeight() > 0) {
                    addShapes();
                }
            });
        }
    });

}

    private void addShapes() {
        Random random = new Random();

        // Генерация прямоугольников
        Rectangle rectangle1 = new Rectangle(random.nextInt(30) + 10, random.nextInt(60) + 20, Color.LIGHTGRAY);
        rectangle1.setX(random.nextDouble(memoPane.getWidth()));
        rectangle1.setY(random.nextDouble(memoPane.getHeight()));

        Rectangle rectangle2 = new Rectangle(random.nextInt(60) + 10, random.nextInt(100) + 20, Color.GOLD);
        rectangle2.setX(random.nextDouble(memoPane.getWidth()));
        rectangle2.setY(random.nextDouble(memoPane.getHeight()));

        // Генерация кругов
        Circle circle1 = new Circle(50.0);
        circle1.setCenterX(random.nextDouble(memoPane.getWidth()));
        circle1.setCenterY(random.nextDouble(memoPane.getHeight()));
        circle1.setFill(Color.ALICEBLUE);
        circle1.setStroke(Color.BLACK);

        Circle circle2 = new Circle(100.0);
        circle2.setCenterX(random.nextDouble(memoPane.getWidth()));
        circle2.setCenterY(random.nextDouble(memoPane.getHeight()));
        circle2.setFill(Color.GREEN);
        circle2.setStroke(Color.BLACK);


        Polygon pentagon1 = createPentagon(random.nextDouble(memoPane.getWidth()), random.nextDouble(memoPane.getHeight()), random.nextInt(30) + 20, Color.SKYBLUE);
        Polygon pentagon2 = createPentagon(random.nextDouble(memoPane.getWidth()), random.nextDouble(memoPane.getHeight()), random.nextInt(40) + 30, Color.ORANGERED);


        Ellipse ellipse1 = new Ellipse(random.nextInt(40) + 30, random.nextInt(20) + 10);
        ellipse1.setCenterX(random.nextDouble(memoPane.getWidth()));
        ellipse1.setCenterY(random.nextDouble(memoPane.getHeight()));
        ellipse1.setFill(Color.VIOLET);

        Ellipse ellipse2 = new Ellipse(random.nextInt(50) + 20, random.nextInt(30) + 15);
        ellipse2.setCenterX(random.nextDouble(memoPane.getWidth()));
        ellipse2.setCenterY(random.nextDouble(memoPane.getHeight()));
        ellipse2.setFill(Color.CORAL);


        this.shapes = new ArrayList<>();
        this.shapes.addAll(Arrays.asList(rectangle1, rectangle2, circle1, circle2, pentagon1, pentagon2, ellipse1, ellipse2));
        this.memoSelect = new MemoSelect();
        for (Shape a : this.shapes) {
            a.addEventHandler(MouseEvent.MOUSE_PRESSED, (_) -> {
                Momento m = new Momento(a);
                this.memoSelect.push(m);
                m.initState().toFront();
            });
            this.memoPane.getChildren().add(a);
        }
    }
    public void onClick(MouseEvent mouseEvent) {
        if (mouseEvent.getTarget().equals(this.memoPane)) {
            this.memoSelect.poll().getState().relocate(mouseEvent.getX(), mouseEvent.getY());
        }
    }
    public void initMemoPane(){
        memoPane.setPrefSize(960,400);
    }
    private Polygon createPentagon(double centerX, double centerY, double radius, Color color) {
        Polygon pentagon = new Polygon();
        for (int i = 0; i < 5; i++) {
            double angle = Math.toRadians(72 * i - 90); // Углы пятиугольника
            double x = centerX + radius * Math.cos(angle);
            double y = centerY + radius * Math.sin(angle);
            pentagon.getPoints().addAll(x, y);
        }
        pentagon.setFill(color);
        return pentagon;
    }
}



