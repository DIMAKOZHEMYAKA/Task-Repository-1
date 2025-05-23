module decorator {
    requires javafx.controls;
    requires javafx.fxml;


    opens decoratorRep to javafx.fxml;
    exports decoratorRep;

}