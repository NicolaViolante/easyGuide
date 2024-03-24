package com.example.easyguide.logic.graphic_controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;

public class SignUpGraphicController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private RadioButton guideRadioButton;

    @FXML
    private Button signInButton;

    @FXML
    private TextField mailField;

    @FXML
    private TextField nameField;

    @FXML
    private TextField passwordField;

    @FXML
    private Button registerButton;

    @FXML
    private TextField surnameField;

    @FXML
    private RadioButton touristRadioButton;

    @FXML
    private TextField usernameField;

    @FXML
    void signIn(ActionEvent event) {

    }

    @FXML
    void register(ActionEvent event) {

    }

    @FXML
    void setMail(ActionEvent event) {

    }

    @FXML
    void setName(ActionEvent event) {

    }

    @FXML
    void setPsw(ActionEvent event) {

    }

    @FXML
    void setRoleGuide(ActionEvent event) {

    }

    @FXML
    void setRoleTourist(ActionEvent event) {

    }

    @FXML
    void setSurname(ActionEvent event) {

    }

    @FXML
    void setUsnm(ActionEvent event) {

    }

    @FXML
    void initialize() {
        assert guideRadioButton != null : "fx:id=\"guideRadioButton\" was not injected: check your FXML file 'signup.fxml'.";
        assert signInButton != null : "fx:id=\"logoutButton\" was not injected: check your FXML file 'signup.fxml'.";
        assert mailField != null : "fx:id=\"mailField\" was not injected: check your FXML file 'signup.fxml'.";
        assert nameField != null : "fx:id=\"nameField\" was not injected: check your FXML file 'signup.fxml'.";
        assert passwordField != null : "fx:id=\"passwordField\" was not injected: check your FXML file 'signup.fxml'.";
        assert registerButton != null : "fx:id=\"registerButton\" was not injected: check your FXML file 'signup.fxml'.";
        assert surnameField != null : "fx:id=\"surnameField\" was not injected: check your FXML file 'signup.fxml'.";
        assert touristRadioButton != null : "fx:id=\"touristRadioButton\" was not injected: check your FXML file 'signup.fxml'.";
        assert usernameField != null : "fx:id=\"usernameField\" was not injected: check your FXML file 'signup.fxml'.";

    }

}
