package com.example.easyguide.logic.graphic_controller;

import com.example.easyguide.logic.controller.JoinTourController;
import com.example.easyguide.logic.controller.LoginController;
import com.example.easyguide.logic.utilities.AbsDialogNavigationController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;

public class AbstractGraphicController extends AbsDialogNavigationController {
    @FXML
    private Button SelectionMessagesButton;

    @FXML
    private Button SelectionRequestButton;
   JoinTourController joinTourController;

    @FXML
    protected void goMessage(MouseEvent event) {
        goToPage("selectionMessageOrRequests.fxml");
    }
    @FXML
    protected void logout(ActionEvent event) {
        new LoginController().logout();
        goToPage("login.fxml");
    }
    @FXML
    protected void goHome(MouseEvent event) {
        goToPage("home.fxml");
    }
    @FXML
    protected void selectedViewMessages(ActionEvent event) {

    }

    @FXML
    protected void selectedViewRequests(ActionEvent event) {

    }
    @FXML @Override
    public void initialize() {
        super.initialize();
        joinTourController = new JoinTourController();

        assert SelectionMessagesButton != null : "fx:id=\"SelectionMessagesButton\" was not injected: check your FXML file 'selectionMessageOrRequests.fxml'.";
        assert SelectionRequestButton != null : "fx:id=\"SelectionRequestButton\" was not injected: check your FXML file 'selectionMessageOrRequests.fxml'.";
    }
}
