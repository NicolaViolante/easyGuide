package com.example.easyguide.logic.graphic_controller;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import com.example.easyguide.logic.beans.ReservationInfoBean;
import com.example.easyguide.logic.cli_graphic_controller.CLIMessagesGraphicController;
import com.example.easyguide.logic.cli_graphic_controller.CLIRequestsGraphicController;
import com.example.easyguide.logic.controller.JoinTourController;
import com.example.easyguide.logic.controller.LoginController;
import com.example.easyguide.logic.session.SessionManager;
import com.example.easyguide.logic.utilities.AbsDialogNavigationController;
import com.example.easyguide.logic.utilities.CLIPrinter;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

import static com.example.easyguide.logic.model.domain.Role.TOURIST;

public class HomeGraphicController extends AbsDialogNavigationController{

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

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
    void goMessage(MouseEvent event) {

    }

    @FXML
    void logout(ActionEvent event) {
        new LoginController().logout();
        goToPage("login.fxml");
    }

    @FXML
    void search(ActionEvent event) {

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
