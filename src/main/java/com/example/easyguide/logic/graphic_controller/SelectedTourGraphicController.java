package com.example.easyguide.logic.graphic_controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.MenuButton;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;

public class SelectedTourGraphicController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private MenuButton TimePicker;

    @FXML
    private ImageView backButton;

    @FXML
    private MenuButton datePicker;

    @FXML
    private Text duration;

    @FXML
    private Text guideName;

    @FXML
    private ImageView homeButton;

    @FXML
    private Text info;

    @FXML
    private Button logoutButton;

    @FXML
    private ImageView messageButton;

    @FXML
    private TextField peopleField;

    @FXML
    private Text price;

    @FXML
    private Button subscribeButton;

    @FXML
    private Text tourName;

    @FXML
    void goBack(MouseEvent event) {

    }

    @FXML
    void goHome(MouseEvent event) {

    }

    @FXML
    void goMessage(MouseEvent event) {

    }

    @FXML
    void logout(ActionEvent event) {

    }

    @FXML
    void sendSubscription(ActionEvent event) {

    }

    @FXML
    void setPeople(ActionEvent event) {

    }

    @FXML
    void showDates(ActionEvent event) {

    }

    @FXML
    void showTimes(ActionEvent event) {

    }

    @FXML
    void initialize() {
        assert TimePicker != null : "fx:id=\"TimePicker\" was not injected: check your FXML file 'selectedTour.fxml'.";
        assert backButton != null : "fx:id=\"backButton\" was not injected: check your FXML file 'selectedTour.fxml'.";
        assert datePicker != null : "fx:id=\"datePicker\" was not injected: check your FXML file 'selectedTour.fxml'.";
        assert duration != null : "fx:id=\"duration\" was not injected: check your FXML file 'selectedTour.fxml'.";
        assert guideName != null : "fx:id=\"guideName\" was not injected: check your FXML file 'selectedTour.fxml'.";
        assert homeButton != null : "fx:id=\"homeButton\" was not injected: check your FXML file 'selectedTour.fxml'.";
        assert info != null : "fx:id=\"info\" was not injected: check your FXML file 'selectedTour.fxml'.";
        assert logoutButton != null : "fx:id=\"logoutButton\" was not injected: check your FXML file 'selectedTour.fxml'.";
        assert messageButton != null : "fx:id=\"messageButton\" was not injected: check your FXML file 'selectedTour.fxml'.";
        assert peopleField != null : "fx:id=\"peopleField\" was not injected: check your FXML file 'selectedTour.fxml'.";
        assert price != null : "fx:id=\"price\" was not injected: check your FXML file 'selectedTour.fxml'.";
        assert subscribeButton != null : "fx:id=\"subscribeButton\" was not injected: check your FXML file 'selectedTour.fxml'.";
        assert tourName != null : "fx:id=\"tourName\" was not injected: check your FXML file 'selectedTour.fxml'.";

    }

}
