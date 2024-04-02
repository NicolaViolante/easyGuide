package com.example.easyguide.logic.graphic_controller;

import java.net.URL;
import java.sql.Date;
import java.sql.Time;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;

import com.example.easyguide.logic.beans.RequestsInfoBean;
import com.example.easyguide.logic.beans.ReservationInfoBean;
import com.example.easyguide.logic.controller.JoinTourController;
import com.example.easyguide.logic.model.domain.Status;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

public class MessagesGraphicController extends AbstractGraphicController {

    @FXML
    private TableColumn<RequestsInfoBean, String> guideMail;

    @FXML
    private ImageView homeButton;

    @FXML
    private Button logoutButton;

    @FXML
    private TableColumn<RequestsInfoBean, Status> status;

    @FXML
    private TableColumn<RequestsInfoBean, Date> tourDate;

    @FXML
    private TableColumn<RequestsInfoBean, String> tourName;

    @FXML
    private TableColumn<RequestsInfoBean, Integer> tourPeople;

    @FXML
    private TableColumn<RequestsInfoBean, Float> tourPrice;

    @FXML
    private TableView<RequestsInfoBean> tourTable;

    @FXML
    private TableColumn<RequestsInfoBean, Time> tourTime;
    private final ObservableList<RequestsInfoBean> requestsInfoBeanObservableList = FXCollections.observableArrayList();


    @FXML @Override
    public void initialize() {

        super.initialize();
        joinTourController = new JoinTourController();

        assert guideMail != null : "fx:id=\"guideMail\" was not injected: check your FXML file 'messages.fxml'.";
        assert homeButton != null : "fx:id=\"homeButton\" was not injected: check your FXML file 'messages.fxml'.";
        assert logoutButton != null : "fx:id=\"logoutButton\" was not injected: check your FXML file 'messages.fxml'.";
        assert status != null : "fx:id=\"status\" was not injected: check your FXML file 'messages.fxml'.";
        assert tourDate != null : "fx:id=\"tourDate\" was not injected: check your FXML file 'messages.fxml'.";
        assert tourName != null : "fx:id=\"tourName\" was not injected: check your FXML file 'messages.fxml'.";
        assert tourPeople != null : "fx:id=\"tourPeople\" was not injected: check your FXML file 'messages.fxml'.";
        assert tourPrice != null : "fx:id=\"tourPrice\" was not injected: check your FXML file 'messages.fxml'.";
        assert tourTable != null : "fx:id=\"tourTable\" was not injected: check your FXML file 'messages.fxml'.";
        assert tourTime != null : "fx:id=\"tourTime\" was not injected: check your FXML file 'messages.fxml'.";


        try{
            List<RequestsInfoBean> tourInfo = new JoinTourController().showMessages();

            tourName.setCellValueFactory(new PropertyValueFactory<>("tourName"));
            tourDate.setCellValueFactory(new PropertyValueFactory<>("date"));
            tourPrice.setCellValueFactory(new PropertyValueFactory<>("price"));
            tourTime.setCellValueFactory(new PropertyValueFactory<>("time"));
            tourPeople.setCellValueFactory(new PropertyValueFactory<>("people"));
            guideMail.setCellValueFactory(new PropertyValueFactory<>("guideMail"));
            status.setCellValueFactory(new PropertyValueFactory<>("status"));
            requestsInfoBeanObservableList.addAll(tourInfo);
            tourTable.setItems(requestsInfoBeanObservableList);
        }catch (Exception e){
            logger.log(Level.INFO, e.getMessage());
        }
    }


}

