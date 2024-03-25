package com.example.easyguide.logic.graphic_controller;

import java.sql.SQLException;
import java.util.logging.Level;

import com.example.easyguide.logic.beans.CredentialsBean;
import com.example.easyguide.logic.controller.LoginController;
import com.example.easyguide.logic.exceptions.DAOException;
import com.example.easyguide.logic.exceptions.InvalidFormatException;
import com.example.easyguide.logic.utilities.AbsDialogNavigationController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class LoginGraphicController extends AbsDialogNavigationController {


    @FXML
    private Button loginButton;

    @FXML
    private PasswordField passwordField;

    @FXML
    private Button signBtn;

    @FXML
    private TextField usernameField;

    private LoginController loginController;

    @FXML
    public void login(ActionEvent event) {
        try{
            CredentialsBean credentialsBean = new CredentialsBean(
                    usernameField.getText(),
                    passwordField.getText()
            );
            loginController.login(credentialsBean);
            goToPage("home.fxml");
        }
        catch (InvalidFormatException e) {
            logger.log(Level.INFO, e.getMessage());
            showErrorAlert("Credential error","Invalid format","Username or password are in an invalid format");
        }
        catch (DAOException e) {
            logger.log(Level.INFO, e.getMessage());
            showErrorAlert("Credential error","User not found","Username or password are wrong");
        }
        catch (SQLException e) {
            logger.log(Level.INFO, e.getMessage());
            showInfoAlert("DB is not working","","");
        }

    }


    @FXML
    void signIn(ActionEvent event) {
        goToPage("signup.fxml");
    }

    @FXML @Override
    public void initialize() {
        super.initialize();
        loginController = new LoginController();

        assert loginButton != null : "fx:id=\"loginButton\" was not injected: check your FXML file 'login.fxml'.";
        assert passwordField != null : "fx:id=\"passwordField\" was not injected: check your FXML file 'login.fxml'.";
        assert signBtn != null : "fx:id=\"signBtn\" was not injected: check your FXML file 'login.fxml'.";
        assert usernameField != null : "fx:id=\"usernameField\" was not injected: check your FXML file 'login.fxml'.";

    }

}
