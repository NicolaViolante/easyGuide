package com.example.easyguide.logic.graphic_controller;

import com.example.easyguide.logic.controller.JoinTourController;
import com.example.easyguide.logic.session.SessionManager;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;

import java.sql.SQLException;

public class ViewProfileGraphicController extends AbstractGraphicController {

    @FXML
    private ImageView backButton;

    @FXML
    private ImageView homeButton;

    @FXML
    private Button logoutButton;

    @FXML
    private Text mail;

    @FXML
    private ImageView messageButton;

    @FXML
    private Text name;

    @FXML
    private Text role;

    @FXML
    private Text surname;

    @FXML
    private Text username;

    @FXML
    void goBack(MouseEvent event) {
        goHome(event);
    }



    @FXML @Override
    public void initialize()  {
        super.initialize();
        joinTourController = new JoinTourController();

        assert backButton != null : "fx:id=\"backButton\" was not injected: check your FXML file 'profileInfo.fxml'.";
        assert homeButton != null : "fx:id=\"homeButton\" was not injected: check your FXML file 'profileInfo.fxml'.";
        assert logoutButton != null : "fx:id=\"logoutButton\" was not injected: check your FXML file 'profileInfo.fxml'.";
        assert mail != null : "fx:id=\"mail\" was not injected: check your FXML file 'profileInfo.fxml'.";
        assert messageButton != null : "fx:id=\"messageButton\" was not injected: check your FXML file 'profileInfo.fxml'.";
        assert name != null : "fx:id=\"name\" was not injected: check your FXML file 'profileInfo.fxml'.";
        assert role != null : "fx:id=\"role\" was not injected: check your FXML file 'profileInfo.fxml'.";
        assert surname != null : "fx:id=\"surname\" was not injected: check your FXML file 'profileInfo.fxml'.";
        assert username != null : "fx:id=\"username\" was not injected: check your FXML file 'profileInfo.fxml'.";
        this.username.setText(SessionManager.getInstance().getCurrentUser().getUsername());
        this.name.setText(SessionManager.getInstance().getCurrentUser().getName());
        this.surname.setText(SessionManager.getInstance().getCurrentUser().getSurname());
        this.mail.setText(SessionManager.getInstance().getCurrentUser().getEmail());
        this.role.setText(SessionManager.getInstance().getCurrentUser().getUserType().getId());

    }

}
