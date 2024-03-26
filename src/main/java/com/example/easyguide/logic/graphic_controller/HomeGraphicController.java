package com.example.easyguide.logic.graphic_controller;


import com.example.easyguide.logic.beans.TourBean;
import com.example.easyguide.logic.beans.TourSearchBean;
import com.example.easyguide.logic.cli_graphic_controller.CLISelectTourGraphicController;
import com.example.easyguide.logic.controller.JoinTourController;

import com.example.easyguide.logic.exceptions.InvalidFormatException;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;


public class HomeGraphicController extends AbstractGraphicController{


    @FXML
    private Button logoutButton;

    @FXML
    private ImageView messageButton;

    @FXML
    private Button searchButton;

    @FXML
    private TextField textField;
    private static List<TourBean> listOfTourBeans;


    @FXML
    public void search(ActionEvent event) {
        try {
            TourSearchBean bean = new TourSearchBean(textField.getText());
            List<TourBean> listOfTours = joinTourController.findTourOfCity(bean);
            this.listOfTourBeans = listOfTours;

            goToPage("selectTour.fxml");


        } catch (InvalidFormatException e) {
            logger.log(Level.INFO, e.getMessage());
            showErrorAlert("City error","Invalid format","City is in an invalid format");
        }
        catch (SQLException e){
            logger.log(Level.INFO, e.getMessage());
            showInfoAlert("DB is not working","","");
        }
    }


    @FXML @Override
    public void initialize() throws SQLException {
        super.initialize();
        joinTourController = new JoinTourController();


        assert logoutButton != null : "fx:id=\"logoutButton\" was not injected: check your FXML file 'home.fxml'.";
        assert messageButton != null : "fx:id=\"messageButton\" was not injected: check your FXML file 'home.fxml'.";
        assert searchButton != null : "fx:id=\"searchButton\" was not injected: check your FXML file 'home.fxml'.";
        assert textField != null : "fx:id=\"textField\" was not injected: check your FXML file 'home.fxml'.";

    }
    public List<TourBean> getTourBeans(){ return this.listOfTourBeans;}

}
