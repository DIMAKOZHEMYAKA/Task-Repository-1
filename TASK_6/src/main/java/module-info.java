module com.example.task_6 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.task_6 to javafx.fxml;
    exports com.example.task_6;
}