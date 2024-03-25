package com.example.easyguide.logic.graphic_controller;


import com.example.easyguide.logic.controller.JoinTourController;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;



public class HomeGraphicController extends AbstractGraphicController{


    @FXML
    private Button logoutButton;

    @FXML
    private ImageView messageButton;

    @FXML
    private Button searchButton;

    @FXML
    private TextField textField;
    private JoinTourController joinTourController;


    @FXML
    public void search(ActionEvent event) {

    }



    @FXML @Override
    public void initialize() {
        super.initialize();
        joinTourController = new JoinTourController();


        assert logoutButton != null : "fx:id=\"logoutButton\" was not injected: check your FXML file 'home.fxml'.";
        assert messageButton != null : "fx:id=\"messageButton\" was not injected: check your FXML file 'home.fxml'.";
        assert searchButton != null : "fx:id=\"searchButton\" was not injected: check your FXML file 'home.fxml'.";
        assert textField != null : "fx:id=\"textField\" was not injected: check your FXML file 'home.fxml'.";

    }

}
