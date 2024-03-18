package com.example.easyguide.logic.controller;

import com.example.easyguide.logic.beans.*;
import com.example.easyguide.logic.model.dao.ReservationDAO;
import com.example.easyguide.logic.model.dao.TourDAO;
import com.example.easyguide.logic.model.domain.Tour;
import com.example.easyguide.logic.utilities.PaymentBoundary;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class JoinTourController {
    public List<TourBean> findTourOfCity(TourSearchBean tourSearchBean) throws SQLException {

        List<Tour> tourList = new TourDAO().findTourOfTheCity(tourSearchBean);
        List<TourBean> tourBeansList = new ArrayList<>();

            for (Tour tour : tourList){
                TourBean tourBean = new TourBean(tour.getName(), tour.getPrice());
                tourBeansList.add(tourBean);
            }

        return tourBeansList;
    }

    public List<SpecifiedTourBean> showTour(SelectedTourBean selectedTourBean) throws SQLException{
        List<Tour> tourList = new TourDAO().findTourDetails(selectedTourBean);
        List<SpecifiedTourBean> specifiedTourBeanList = new ArrayList<>();

        for (Tour tour : tourList){
            SpecifiedTourBean specifiedTourBean = new SpecifiedTourBean(tour.getPhoto(), tour.getName(), tour.getDescription(),
                    tour.getGuide(), tour.getGuideMail(), tour.getPrice(), tour.getDuration(), tour.getDate(), tour.getTimes(),
                    tour.getCity());
            specifiedTourBeanList.add(specifiedTourBean);
        }

        return specifiedTourBeanList;
    }

    public void completeReservation(ReservationInfoBean reservationInfoBean) throws SQLException {
        new ReservationDAO().registerReservation(reservationInfoBean);
    }

    public void pay(){
        new PaymentBoundary().pay();
    }

    public void showMessages(RequestSearchBean requestSearchBean){

    }

    public void showRequests(RequestSearchBean requestSearchBean){

    }
}
