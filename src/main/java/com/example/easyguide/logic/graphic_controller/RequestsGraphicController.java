package com.example.easyguide.logic.graphic_controller;


import java.sql.Date;
import java.sql.SQLException;
import java.sql.Time;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.example.easyguide.logic.beans.AcceptationBean;
import com.example.easyguide.logic.beans.ReservationInfoBean;
import com.example.easyguide.logic.controller.JoinTourController;
import com.example.easyguide.logic.exceptions.EmailSenderException;
import com.example.easyguide.logic.model.domain.Status;
import com.example.easyguide.logic.session.SessionManager;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

public class RequestsGraphicController extends AbstractGraphicController {


    @FXML
    private ImageView homeButton;

    @FXML
    private Button logoutButton;

    @FXML
    private TableColumn<ReservationInfoBean, Date> tourDate;

    @FXML
    private TableColumn<ReservationInfoBean, String> tourName;

    @FXML
    private TableColumn<ReservationInfoBean, Integer> tourPeople;

    @FXML
    private TableColumn<ReservationInfoBean, Float> tourPrice;

    @FXML
    private TableView<ReservationInfoBean> tourTable;

    @FXML
    private TableColumn<ReservationInfoBean, Time> tourTime;

    @FXML
    private TableColumn<ReservationInfoBean, String> touristMail;
    private final ObservableList<ReservationInfoBean> reservationInfoBeanObservableList = FXCollections.observableArrayList();
    private AcceptationBean acceptationBean;

    @FXML
    void choose(MouseEvent event) throws EmailSenderException, SQLException {
        int index = tourTable.getSelectionModel().getSelectedIndex();
        ButtonType choose = null;
        choose = showConfirmationAlert("Accept or refuse","Do you want to accept or refuse","Do you want to accept this request(OK to accept, cancel to refuse)");
        if(choose == ButtonType.OK){

            acceptationBean = new AcceptationBean(Status.ACCEPTED,
                    SessionManager.getInstance().getCurrentUser().getEmail(),
                    touristMail.getCellData(index),
                    tourDate.getCellData(index),
                    tourTime.getCellData(index),
                    tourName.getCellData(index));

            tourTable.getItems().remove(index);
            tourTable.refresh();
            joinTourController.changeStatus(acceptationBean);
        }
        else if(choose == ButtonType.CANCEL){
            acceptationBean = new AcceptationBean(Status.DECLINED,
                    SessionManager.getInstance().getCurrentUser().getEmail(),
                    touristMail.getCellData(index),
                    tourDate.getCellData(index),
                    tourTime.getCellData(index),
                    tourName.getCellData(index));

            tourTable.getItems().remove(index);
            tourTable.refresh();
            joinTourController.changeStatus(acceptationBean);
        }
    }

    @FXML @Override
    public void initialize()  {
        super.initialize();
        joinTourController = new JoinTourController();
        assert homeButton != null : "fx:id=\"homeButton\" was not injected: check your FXML file 'requests.fxml'.";
        assert logoutButton != null : "fx:id=\"logoutButton\" was not injected: check your FXML file 'requests.fxml'.";
        assert tourDate != null : "fx:id=\"tourDate\" was not injected: check your FXML file 'requests.fxml'.";
        assert tourName != null : "fx:id=\"tourName\" was not injected: check your FXML file 'requests.fxml'.";
        assert tourPeople != null : "fx:id=\"tourPeople\" was not injected: check your FXML file 'requests.fxml'.";
        assert tourPrice != null : "fx:id=\"tourPrice\" was not injected: check your FXML file 'requests.fxml'.";
        assert tourTable != null : "fx:id=\"tourTable\" was not injected: check your FXML file 'requests.fxml'.";
        assert tourTime != null : "fx:id=\"tourTime\" was not injected: check your FXML file 'requests.fxml'.";
        assert touristMail != null : "fx:id=\"touristMail\" was not injected: check your FXML file 'requests.fxml'.";
        try{
            List<ReservationInfoBean> tourInfo = new JoinTourController().showRequests();

        tourDate.setCellValueFactory(new PropertyValueFactory<>("date"));
        tourName.setCellValueFactory(new PropertyValueFactory<>("tourName"));
        tourPeople.setCellValueFactory(new PropertyValueFactory<>("people"));
        tourPrice.setCellValueFactory(new PropertyValueFactory<>("price"));
        tourTime.setCellValueFactory(new PropertyValueFactory<>("time"));
        touristMail.setCellValueFactory(new PropertyValueFactory<>("touristMail"));
        reservationInfoBeanObservableList.addAll(tourInfo);
        tourTable.setItems(reservationInfoBeanObservableList);
        }catch (Exception e){
            logger.log(Level.INFO, e.getMessage());
        }
    }

}
