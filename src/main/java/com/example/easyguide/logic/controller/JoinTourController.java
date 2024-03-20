package com.example.easyguide.logic.controller;

import com.example.easyguide.logic.beans.*;
import com.example.easyguide.logic.exceptions.EmailSenderException;
import com.example.easyguide.logic.model.dao.ReservationDAO;
import com.example.easyguide.logic.model.dao.TourDAO;
import com.example.easyguide.logic.model.domain.Reservation;
import com.example.easyguide.logic.model.domain.Tour;
import com.example.easyguide.logic.model.domain.User;
import com.example.easyguide.logic.session.SessionManager;
import com.example.easyguide.logic.utilities.CLIPrinter;
import com.example.easyguide.logic.utilities.PaymentBoundary;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class JoinTourController {
    public List<TourBean> findTourOfCity(TourSearchBean tourSearchBean) throws SQLException {

        Tour tourSearch = new Tour(tourSearchBean.getCity());
        List<Tour> tourList = new TourDAO().findTourOfTheCity(tourSearch);
        List<TourBean> tourBeansList = new ArrayList<>();

            for (Tour tour : tourList){
                TourBean tourBean = new TourBean(tour.getName(), tour.getPrice());
                tourBeansList.add(tourBean);
            }

        return tourBeansList;
    }

    public List<SpecifiedTourBean> showTour(SelectedTourBean selectedTourBean) throws SQLException{
        Tour selectedTour = new Tour();
        selectedTour.setTourName(selectedTourBean.getTour());
        List<Tour> tourList = new TourDAO().findTourDetails(selectedTour);
        List<SpecifiedTourBean> specifiedTourBeanList = new ArrayList<>();

        for (Tour tour : tourList){
            SpecifiedTourBean specifiedTourBean = new SpecifiedTourBean(tour.getPhoto(), tour.getName(), tour.getDescription(),
                    tour.getGuide(), tour.getGuideMail(), tour.getPrice(), tour.getDuration());
            specifiedTourBean.setDateTimesCity(tour.getDate(), tour.getTimes(), tour.getCity());
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
        CLIPrinter.printMessage("NOT IMPLEMENTED\n");
    }

    public List<ReservationInfoBean> showRequests(RequestSearchBean requestSearchBean) throws SQLException{
        User user = SessionManager.getInstance().getCurrentUser();
        List<Reservation> reservationList = new ReservationDAO().findTourDetailsByMail(user);
        List<ReservationInfoBean> reservationInfoBeansList = new ArrayList<>();
        for (Reservation reservation : reservationList){
            ReservationInfoBean reservationInfoBean = new ReservationInfoBean(SessionManager.getInstance().getCurrentUser().getEmail(),
                    reservation.getTouristMail(), reservation.getDate(), reservation.getTime(), reservation.getPeople(),
                    reservation.getTourName(), reservation.getPrice());
            reservationInfoBeansList.add(reservationInfoBean);
        }

        return reservationInfoBeansList;
    }
    public void changeStatus(AcceptationBean acceptationBean) throws SQLException, EmailSenderException {
        Reservation reservation = new Reservation(acceptationBean.getState(), acceptationBean.getGuideMail(), acceptationBean.getTouristMail(),
                acceptationBean.getDate(), acceptationBean.getTime(),acceptationBean.getTourName());
        new ReservationDAO().changeStatus(reservation);
        reservation.notifyPublication();


    }
}
