package com.example.easyguide.logic.utilities;

import javafx.scene.control.Alert;
import javafx.fxml.FXML;
import javafx.scene.control.ButtonType;

import java.io.IOException;
import java.sql.SQLException;
import java.util.InputMismatchException;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;

public class AbsDialogNavigationController {
    protected Alert errorAlert;
    protected Alert infoAlert;
    protected Alert confirmationAlert;
    protected Logger logger = Logger.getAnonymousLogger();

    @FXML
    public void initialize() throws SQLException {
        errorAlert = new Alert(Alert.AlertType.ERROR);
        infoAlert = new Alert(Alert.AlertType.INFORMATION);
        confirmationAlert = new Alert(Alert.AlertType.CONFIRMATION);
    }

    protected void showInfoAlert(String title, String header, String content){
        infoAlert.setTitle(title);
        infoAlert.setHeaderText(header);
        infoAlert.setContentText(content);
        infoAlert.show();
    }
    protected void showErrorAlert(String title, String header, String content){
        errorAlert.setTitle(title);
        errorAlert.setHeaderText(header);
        errorAlert.setContentText(content);
        errorAlert.show();
    }
    protected ButtonType showConfirmationAlert(String title, String header, String content){
        confirmationAlert.setTitle(title);
        confirmationAlert.setHeaderText(header);
        confirmationAlert.setContentText(content);
        Optional<ButtonType> result = confirmationAlert.showAndWait();
        if (result.isEmpty()) {
            throw new InputMismatchException();
        }
        return result.get();
    }

    protected void goToPage(String page){
        try{
            NavigatorSingleton.getInstance().goToPage(page);
        }
        catch (IOException e){
            Logger.getAnonymousLogger().log(Level.INFO, e.getMessage());
        }
    }
}
