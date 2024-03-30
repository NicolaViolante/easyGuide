package com.example.easyguide.logic.graphic_controller;


import com.example.easyguide.logic.beans.SignUpBean;
import com.example.easyguide.logic.exceptions.InvalidRoleException;
import com.example.easyguide.logic.model.domain.Role;
import com.example.easyguide.logic.controller.SignUpController;
import com.example.easyguide.logic.exceptions.InvalidFormatException;
import com.example.easyguide.logic.utilities.AbsDialogNavigationController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;

import java.sql.SQLException;
import java.util.logging.Level;

public class SignUpGraphicController extends AbsDialogNavigationController {

    @FXML
    private RadioButton guideRadioButton;

    @FXML
    private Button signInButton;

    @FXML
    private TextField mailField;

    @FXML
    private TextField nameField;

    @FXML
    private TextField passwordField;

    @FXML
    private Button registerButton;

    @FXML
    private TextField surnameField;

    @FXML
    private RadioButton touristRadioButton;

    @FXML
    private TextField usernameField;
    private SignUpController signUpController;
    private Role role = null;

    @FXML
    void signIn(ActionEvent event) {
        goToPage("signup.fxml");
    }

    @FXML
    void register(ActionEvent event) {
            try {
                if (role == null) {
                    throw new InvalidRoleException("Role MUST be specified");
                }
                SignUpBean signUpBean = new SignUpBean(
                        usernameField.getText(),
                        nameField.getText(),
                        surnameField.getText(),
                        mailField.getText(),
                        passwordField.getText(),
                        role.getId()
                );
                int result = signUpController.signUp(signUpBean);
                switch (result){
                    case 1 -> goToPage("home.fxml");
                    case -1 -> showInfoAlert("Username already in use","This username isn't selectable","Choose an other username");
                    default -> showErrorAlert("Unknown error","","");
                }
            }
            catch (InvalidRoleException e){
                logger.log(Level.INFO, e.getMessage());
                showInfoAlert("Role", "No role is specified", "Specify role");
            }
            catch (InvalidFormatException e){
                logger.log(Level.INFO, e.getMessage());
                showErrorAlert("Credential error","Invalid format","Some fields are in invalid format");
            }
            catch (SQLException e){
                logger.log(Level.INFO, e.getMessage());
                showInfoAlert("DB is not working","","");
            }
    }


    @FXML
    void setRoleGuide(ActionEvent event) {
        role = Role.GUIDE;
        touristRadioButton.setDisable(true);
    }

    @FXML
    void setRoleTourist(ActionEvent event) {
        role = Role.TOURIST;
        guideRadioButton.setDisable(true);
    }


    @FXML @Override
    public void initialize() {
        super.initialize();
        signUpController = new SignUpController();
        assert guideRadioButton != null : "fx:id=\"guideRadioButton\" was not injected: check your FXML file 'signup.fxml'.";
        assert signInButton != null : "fx:id=\"logoutButton\" was not injected: check your FXML file 'signup.fxml'.";
        assert mailField != null : "fx:id=\"mailField\" was not injected: check your FXML file 'signup.fxml'.";
        assert nameField != null : "fx:id=\"nameField\" was not injected: check your FXML file 'signup.fxml'.";
        assert passwordField != null : "fx:id=\"passwordField\" was not injected: check your FXML file 'signup.fxml'.";
        assert registerButton != null : "fx:id=\"registerButton\" was not injected: check your FXML file 'signup.fxml'.";
        assert surnameField != null : "fx:id=\"surnameField\" was not injected: check your FXML file 'signup.fxml'.";
        assert touristRadioButton != null : "fx:id=\"touristRadioButton\" was not injected: check your FXML file 'signup.fxml'.";
        assert usernameField != null : "fx:id=\"usernameField\" was not injected: check your FXML file 'signup.fxml'.";

    }

}
