module com.example.task1 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.task1 to javafx.fxml;
    exports com.example.task1;
}