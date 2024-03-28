module com.example.easyguide {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.logging;
    requires java.sql;
    requires com.opencsv;


    opens com.example.easyguide to javafx.fxml;
    exports com.example.easyguide;
    exports com.example.easyguide.logic.graphic_controller;
    opens com.example.easyguide.logic.graphic_controller to javafx.fxml;
    exports com.example.easyguide.logic.beans;
    opens com.example.easyguide.logic.beans to javafx.fxml;
    exports com.example.easyguide.logic.pattern;
    opens com.example.easyguide.logic.pattern;
}