package fatherass.decorator;

import Shapes.Shape;
import Shapes.ShapeFactory;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.TextField;

public class ShapeController {
    @FXML
    private Canvas canvas;
    @FXML
    private TextField FieldX;
    @FXML
    private TextField FieldY;
    @FXML
    private TextField FieldQuantity;
    @FXML
    private TextField FieldSide;
    @FXML
    private TextField FieldSideNumber;
    @FXML
    private ColorPicker FillColor;
    @FXML
    private ColorPicker BorderColor;
    @FXML
    private final ObservableList<String> nums = FXCollections.observableArrayList();
    @FXML
    private ChoiceBox<String> SideQuantity = new ChoiceBox<>(nums);
    @FXML
    void initialize(){
        loadData();
    }

    @FXML

    @FXML
    private void Clear() {
        GraphicsContext gc = canvas.getGraphicsContext2D();
        gc.clearRect(0, 0, canvas.getWidth(), canvas.getHeight());
        System.out.println("Очищено\n");
    }
    @FXML
    private void loadData(){
        nums.removeAll(nums);
        nums.addAll("0","3","4","5","6");
        SideQuantity.getItems().addAll(nums);
    }
}
