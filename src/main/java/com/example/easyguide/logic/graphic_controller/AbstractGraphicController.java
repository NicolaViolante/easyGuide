package com.example.easyguide.logic.graphic_controller;

import com.example.easyguide.logic.controller.JoinTourController;
import com.example.easyguide.logic.controller.LoginController;
import com.example.easyguide.logic.utilities.AbsDialogNavigationController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.input.MouseEvent;

public class AbstractGraphicController extends AbsDialogNavigationController {
   JoinTourController joinTourController;

    @FXML
    void goMessage(MouseEvent event) {

    }
    @FXML
    void logout(ActionEvent event) {
        new LoginController().logout();
        goToPage("login.fxml");
    }
    @FXML
    void goHome(MouseEvent event) {
        goToPage("home.fxml");
    }
    @FXML @Override
    public void initialize() {
        super.initialize();
        joinTourController = new JoinTourController();

    }
}
