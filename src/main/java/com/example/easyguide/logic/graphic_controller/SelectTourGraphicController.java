package com.example.easyguide.logic.graphic_controller;


import java.sql.SQLException;
import java.util.List;

import com.example.easyguide.logic.beans.SelectedTourBean;
import com.example.easyguide.logic.beans.SpecifiedTourBean;
import com.example.easyguide.logic.beans.TourBean;
import com.example.easyguide.logic.controller.JoinTourController;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;


public class SelectTourGraphicController extends AbstractGraphicController {

    @FXML
    private ImageView backButton;

    @FXML
    private ImageView homeButton;

    @FXML
    private Button logoutButton;

    @FXML
    private ImageView messageButton;
    @FXML
    private TableView<TourBean> tourTable = new TableView<>();

    @FXML
    private TableColumn<TourBean, String> tourName;

    @FXML
    private TableColumn<TourBean, Float> tourPrice;
    ObservableList<TourBean> tourBeanObservableList = FXCollections.observableArrayList();
    private static List<SpecifiedTourBean> tourDetails;
    private final List<TourBean> listOfTourBeans;
    public SelectTourGraphicController(List<TourBean> listOfTourBeans){
        this.listOfTourBeans = listOfTourBeans;
    }


    @FXML
    void chooseTour(MouseEvent event) throws SQLException {
        int index = tourTable.getSelectionModel().getSelectedIndex();

            SelectedTourBean selectedTourBean = new SelectedTourBean(tourName.getCellData(index));
            tourDetails = new JoinTourController().showTour(selectedTourBean);
            goToWithController("selectedTour.fxml", new SelectedTourGraphicController(tourDetails, listOfTourBeans));
    }


    @FXML
    void goBack(MouseEvent event) {
        goToPage("home.fxml");
    }


    @FXML  @Override
    public void initialize() throws SQLException {
        super.initialize();
        joinTourController = new JoinTourController();


        assert backButton != null : "fx:id=\"backButton\" was not injected: check your FXML file 'selectTour.fxml'.";
        assert homeButton != null : "fx:id=\"homeButton\" was not injected: check your FXML file 'selectTour.fxml'.";
        assert logoutButton != null : "fx:id=\"logoutButton\" was not injected: check your FXML file 'selectTour.fxml'.";
        assert messageButton != null : "fx:id=\"messageButton\" was not injected: check your FXML file 'selectTour.fxml'.";
        assert tourName != null : "fx:id=\"tourName\" was not injected: check your FXML file 'selectTour.fxml'.";
        assert tourPrice != null : "fx:id=\"tourPrice\" was not injected: check your FXML file 'selectTour.fxml'.";
        assert tourTable != null : "fx:id=\"tourTable\" was not injected: check your FXML file 'selectTour.fxml'.";

        tourName.setCellValueFactory(new PropertyValueFactory<>("tourName"));
        tourPrice.setCellValueFactory(new PropertyValueFactory<>("price"));
        tourBeanObservableList.addAll(listOfTourBeans);
        tourTable.setItems(tourBeanObservableList);
    }
    //public List<SpecifiedTourBean> getTourDetails() {return tourDetails;}
}


