package com.example.easyguide.logic.graphic_controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

public class RequestsGraphicController extends AbstractGraphicController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private ImageView homeButton;

    @FXML
    private Button logoutButton;

    @FXML
    private TableColumn<?, ?> tourDate;

    @FXML
    private TableColumn<?, ?> tourName;

    @FXML
    private TableColumn<?, ?> tourPeople;

    @FXML
    private TableColumn<?, ?> tourPrice;

    @FXML
    private TableView<?> tourTable;

    @FXML
    private TableColumn<?, ?> tourTime;

    @FXML
    private TableColumn<?, ?> touristMail;

    @FXML
    public void initialize() {
        super.initialize();
        assert homeButton != null : "fx:id=\"homeButton\" was not injected: check your FXML file 'requests.fxml'.";
        assert logoutButton != null : "fx:id=\"logoutButton\" was not injected: check your FXML file 'requests.fxml'.";
        assert tourDate != null : "fx:id=\"tourDate\" was not injected: check your FXML file 'requests.fxml'.";
        assert tourName != null : "fx:id=\"tourName\" was not injected: check your FXML file 'requests.fxml'.";
        assert tourPeople != null : "fx:id=\"tourPeople\" was not injected: check your FXML file 'requests.fxml'.";
        assert tourPrice != null : "fx:id=\"tourPrice\" was not injected: check your FXML file 'requests.fxml'.";
        assert tourTable != null : "fx:id=\"tourTable\" was not injected: check your FXML file 'requests.fxml'.";
        assert tourTime != null : "fx:id=\"tourTime\" was not injected: check your FXML file 'requests.fxml'.";
        assert touristMail != null : "fx:id=\"touristMail\" was not injected: check your FXML file 'requests.fxml'.";

    }

}
