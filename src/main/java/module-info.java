module com.example.easyguide {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.logging;
    requires java.sql;


    opens com.example.easyguide to javafx.fxml;
    exports com.example.easyguide;
}