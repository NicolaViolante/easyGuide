package com.example.easyguide.logic.graphic_controller;

import java.sql.SQLException;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import com.example.easyguide.logic.beans.ReservationInfoBean;
import com.example.easyguide.logic.beans.SpecifiedTourBean;
import com.example.easyguide.logic.cli_graphic_controller.CLIHomeGraphicController;
import com.example.easyguide.logic.cli_graphic_controller.CLIPaymentGraphicController;
import com.example.easyguide.logic.controller.JoinTourController;
import com.example.easyguide.logic.exceptions.MissingDatesException;
import com.example.easyguide.logic.session.SessionManager;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;

public class SelectedTourGraphicController extends AbstractGraphicController {

    @FXML
    private MenuButton timePicker;

    @FXML
    private ImageView backButton;

    @FXML
    private MenuButton datePicker;

    @FXML
    private Text duration;

    @FXML
    private Text guideName;

    @FXML
    private ImageView homeButton;

    @FXML
    private Text info;

    @FXML
    private Button logoutButton;

    @FXML
    private ImageView messageButton;

    @FXML
    private TextField peopleField;

    @FXML
    private Text price;

    @FXML
    private Button subscribeButton;

    @FXML
    private Text tourName;
    private  List<SpecifiedTourBean> tourDetails;
    private ReservationInfoBean reservationInfoBean;
    private MenuItem item;
    private int times = 0;

    @FXML
    void goBack(MouseEvent event) {

    }


    @FXML
    void sendSubscription(ActionEvent event) throws MissingDatesException, SQLException {
        reservationInfoBean.setPeople(Integer.parseInt(peopleField.getText()));
        if (reservationInfoBean.getDate() == null || reservationInfoBean.getTime() == null || reservationInfoBean.getPeople() < 1){
            showErrorAlert("Dates missing","Dates missing","Dates missing");
            throw new MissingDatesException("Dates missing");
        }
        new JoinTourController().pay();
        new JoinTourController().completeReservation(reservationInfoBean);
        goToPage("home.fxml");
    }

    @FXML
    void showDates(ActionEvent event) {

    }

    @FXML
    void showTimes(ActionEvent event) {

    }

    @FXML
    public void initialize() {
        super.initialize();
        joinTourController = new JoinTourController();

        assert timePicker != null : "fx:id=\"TimePicker\" was not injected: check your FXML file 'selectedTour.fxml'.";
        assert backButton != null : "fx:id=\"backButton\" was not injected: check your FXML file 'selectedTour.fxml'.";
        assert datePicker != null : "fx:id=\"datePicker\" was not injected: check your FXML file 'selectedTour.fxml'.";
        assert duration != null : "fx:id=\"duration\" was not injected: check your FXML file 'selectedTour.fxml'.";
        assert guideName != null : "fx:id=\"guideName\" was not injected: check your FXML file 'selectedTour.fxml'.";
        assert homeButton != null : "fx:id=\"homeButton\" was not injected: check your FXML file 'selectedTour.fxml'.";
        assert info != null : "fx:id=\"info\" was not injected: check your FXML file 'selectedTour.fxml'.";
        assert logoutButton != null : "fx:id=\"logoutButton\" was not injected: check your FXML file 'selectedTour.fxml'.";
        assert messageButton != null : "fx:id=\"messageButton\" was not injected: check your FXML file 'selectedTour.fxml'.";
        assert peopleField != null : "fx:id=\"peopleField\" was not injected: check your FXML file 'selectedTour.fxml'.";
        assert price != null : "fx:id=\"price\" was not injected: check your FXML file 'selectedTour.fxml'.";
        assert subscribeButton != null : "fx:id=\"subscribeButton\" was not injected: check your FXML file 'selectedTour.fxml'.";
        assert tourName != null : "fx:id=\"tourName\" was not injected: check your FXML file 'selectedTour.fxml'.";

        this.tourDetails = new SelectTourGraphicController().getTourDetails();
        SpecifiedTourBean specifiedTourBean = tourDetails.getFirst();
        tourName.setText(specifiedTourBean.getTourName());
        price.setText(String.valueOf(specifiedTourBean.getPrice()));
        duration.setText(String.valueOf(specifiedTourBean.getDuration()));
        info.setText(specifiedTourBean.getDescription());
        guideName.setText(specifiedTourBean.getGuide());


        datePicker.getItems().removeFirst();
        for(SpecifiedTourBean date : tourDetails){
            String dateString = date.getDate().toString();
            datePicker.getItems().add(item = new MenuItem(dateString));
            item.setOnAction(actionEvent -> {
                for(int i = 0; i < times; i++){
                    timePicker.getItems().removeFirst();
                }
                this.reservationInfoBean.setDate(date.getDate());
                setTimePicker(date.getDate());
                timePicker.setDisable(false);
            });
        }
        datePicker.getItems().removeFirst();
        timePicker.setDisable(true);
        timePicker.getItems().removeFirst();
        timePicker.getItems().removeFirst();
        this.reservationInfoBean =  new ReservationInfoBean(specifiedTourBean.getGuideMail(),
                SessionManager.getInstance().getCurrentUser().getEmail(), specifiedTourBean.getTourName(),
                specifiedTourBean.getPrice());
    }
        private void setTimePicker(Date specifiedDate){
        for(SpecifiedTourBean date : tourDetails){
            if (date.getDate() == specifiedDate){

                this.times = date.getTimes().size();
                for(Time time : date.getTimes()) {
                    String timeString = String.valueOf(time);
                    timePicker.getItems().add(item = new MenuItem(timeString));
                    item.setOnAction(actionEvent -> {
                        this.reservationInfoBean.setTime(time);
                    });
                }


            }
        }

    }
}
