module com.example {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.base;

    opens com.example to javafx.fxml;
    opens com.example.models to javafx.base;

    exports com.example;
}
