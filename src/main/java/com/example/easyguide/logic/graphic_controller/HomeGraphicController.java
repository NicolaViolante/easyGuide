package com.example.easyguide.logic.graphic_controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class HomeGraphicController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button logoutButton;

    @FXML
    private Button searchButton;

    @FXML
    private TextField textField;

    @FXML
    void logout(ActionEvent event) {

    }

    @FXML
    void search(ActionEvent event) {

    }

    @FXML
    void setText(ActionEvent event) {

    }

    @FXML
    void initialize() {
        assert logoutButton != null : "fx:id=\"logoutButton\" was not injected: check your FXML file 'home.fxml'.";
        assert searchButton != null : "fx:id=\"searchButton\" was not injected: check your FXML file 'home.fxml'.";
        assert textField != null : "fx:id=\"textField\" was not injected: check your FXML file 'home.fxml'.";

    }

}
