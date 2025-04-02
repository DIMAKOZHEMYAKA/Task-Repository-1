module fatherass.decorator {
    requires javafx.controls;
    requires javafx.fxml;


    opens fatherass.decorator to javafx.fxml;
    exports fatherass.decorator;
}