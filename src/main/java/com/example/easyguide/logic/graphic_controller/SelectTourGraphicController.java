package com.example.easyguide.logic.graphic_controller;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import com.example.easyguide.logic.beans.TourBean;
import com.example.easyguide.logic.controller.JoinTourController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

public class SelectTourGraphicController extends AbstractGraphicController{

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private ImageView backButton;

    @FXML
    private ImageView homeButton;

    @FXML
    private Button logoutButton;

    @FXML
    private ImageView messageButton;

    @FXML
    private TableColumn<?, ?> tourName;

    @FXML
    private TableColumn<?, ?> tourPrice;

    @FXML
    private TableView<?> tourTable;
    private List<TourBean> tours;

    @FXML
    void goBack(MouseEvent event) {

    }

    public void setTours(List<TourBean> tours) {
        this.tours = tours;
    }

    @FXML
    public void initialize() {
        super.initialize();
        joinTourController = new JoinTourController();
        assert backButton != null : "fx:id=\"backButton\" was not injected: check your FXML file 'Untitled'.";
        assert homeButton != null : "fx:id=\"homeButton\" was not injected: check your FXML file 'Untitled'.";
        assert logoutButton != null : "fx:id=\"logoutButton\" was not injected: check your FXML file 'Untitled'.";
        assert messageButton != null : "fx:id=\"messageButton\" was not injected: check your FXML file 'Untitled'.";
        assert tourName != null : "fx:id=\"tourName\" was not injected: check your FXML file 'Untitled'.";
        assert tourPrice != null : "fx:id=\"tourPrice\" was not injected: check your FXML file 'Untitled'.";
        assert tourTable != null : "fx:id=\"tourTable\" was not injected: check your FXML file 'Untitled'.";

    }

}

