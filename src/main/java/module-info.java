module com.example.easyguide {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.easyguide to javafx.fxml;
    exports com.example.easyguide;
}