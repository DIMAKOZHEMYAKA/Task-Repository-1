module com.example.task_8 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.task_8 to javafx.fxml;
    exports com.example.task_8;
}