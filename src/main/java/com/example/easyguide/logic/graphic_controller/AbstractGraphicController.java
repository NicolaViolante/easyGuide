package com.example.easyguide.logic.graphic_controller;


import com.example.easyguide.logic.controller.JoinTourController;
import com.example.easyguide.logic.controller.LoginController;
import com.example.easyguide.logic.session.SessionManager;
import com.example.easyguide.logic.utilities.AbsDialogNavigationController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;

import java.sql.SQLException;
import static com.example.easyguide.logic.model.domain.Role.GUIDE;
import static com.example.easyguide.logic.model.domain.Role.TOURIST;

public class AbstractGraphicController extends AbsDialogNavigationController {
    @FXML
    private Button selectionMessagesButton;

    @FXML
    private Button selectionRequestButton;
   JoinTourController joinTourController;

    @FXML
    protected void goMessage(MouseEvent event) {
        if (SessionManager.getInstance().getCurrentUser().getUserType() == TOURIST) {
            new JoinTourController().showMessages();
            showInfoAlert("Not implemented","Not implemented","Not implemented");
        } else if(SessionManager.getInstance().getCurrentUser().getUserType() == GUIDE){
            goToPage("selectionMessageOrRequests.fxml");
        }
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
        new JoinTourController().showMessages();
        showInfoAlert("Not implemented","Not implemented","Not implemented");
    }

    @FXML
    protected void selectedViewRequests(ActionEvent event) throws SQLException {
        goToPage("requests.fxml");
    }
    @FXML @Override
    public void initialize() throws SQLException {
        super.initialize();
        joinTourController = new JoinTourController();

        assert selectionMessagesButton != null : "fx:id=\"SelectionMessagesButton\" was not injected: check your FXML file 'selectionMessageOrRequests.fxml'.";
        assert selectionRequestButton != null : "fx:id=\"SelectionRequestButton\" was not injected: check your FXML file 'selectionMessageOrRequests.fxml'.";
    }
}
