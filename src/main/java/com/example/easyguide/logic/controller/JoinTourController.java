package com.example.easyguide.logic.controller;

import com.example.easyguide.logic.beans.*;
import com.example.easyguide.logic.exceptions.EmailSenderException;
import com.example.easyguide.logic.model.dao.ReservationDAO;
import com.example.easyguide.logic.model.dao.TourDAO;
import com.example.easyguide.logic.model.domain.Reservation;
import com.example.easyguide.logic.model.domain.Tour;
import com.example.easyguide.logic.model.domain.User;
import com.example.easyguide.logic.pattern.ReservationDAOFactory;
import com.example.easyguide.logic.session.SessionManager;
import com.example.easyguide.logic.utilities.CLIPrinter;
import com.example.easyguide.logic.utilities.PaymentBoundary;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

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
            SpecifiedTourBean specifiedTourBean = new SpecifiedTourBean(tour.getPhoto(),
                    tour.getName(),
                    tour.getDescription(),
                    tour.getGuide(),
                    tour.getGuideMail(),
                    tour.getPrice(),
                    tour.getDuration());

            specifiedTourBean.setDateTimesCity(tour.getDate(),
                    tour.getTimes(),
                    tour.getCity());
            specifiedTourBeanList.add(specifiedTourBean);
        }

        return specifiedTourBeanList;
    }

    public int completeReservation(ReservationInfoBean reservationInfoBean) {
        int result = -1;
        Reservation reservation = new Reservation(reservationInfoBean.getGuideMail(),
                reservationInfoBean.getTouristMail(),
                reservationInfoBean.getPeople(),
                reservationInfoBean.getTime(),
                reservationInfoBean.getDate(),
                reservationInfoBean.getPrice(),
                reservationInfoBean.getTourName());


        ReservationDAOFactory reservationDAOFactory = new ReservationDAOFactory();
        try{
            ReservationDAO reservationDAO = reservationDAOFactory.createReservationDAO();
            result = reservationDAO.registerReservation(reservation);
            return result;
        }
        catch(Exception e){
            Logger.getAnonymousLogger().log(Level.INFO, e.getMessage());
        }
        return result;
    }

    public void pay(){
        new PaymentBoundary().pay();
    }

    public void showMessages(){
        CLIPrinter.printMessage("NOT IMPLEMENTED\n");
    }

    public List<ReservationInfoBean> showRequests() throws SQLException{
        User user = SessionManager.getInstance().getCurrentUser();
        List<ReservationInfoBean> reservationInfoBeansList = new ArrayList<>();
        ReservationDAOFactory reservationDAOFactory = new ReservationDAOFactory();


        try {
            ReservationDAO reservationDAO = reservationDAOFactory.createReservationDAO();
            List<Reservation> reservationList = reservationDAO.findTourToAcceptOrDecline(user);

            for (Reservation reservation : reservationList) {
                ReservationInfoBean reservationInfoBean = new ReservationInfoBean(SessionManager.getInstance().getCurrentUser().getEmail(),
                        reservation.getTouristMail(),
                        reservation.getDate(),
                        reservation.getTime(),
                        reservation.getPeople(),
                        reservation.getTourName(),
                        reservation.getPrice());
                reservationInfoBeansList.add(reservationInfoBean);
            }


        }catch(Exception e){
            Logger.getAnonymousLogger().log(Level.INFO, e.getMessage());
        }

        return reservationInfoBeansList;
    }
    public void changeStatus(AcceptationBean acceptationBean) throws SQLException, EmailSenderException {
        Reservation reservation = new Reservation(acceptationBean.getState(),
                acceptationBean.getGuideMail(),
                acceptationBean.getTouristMail(),
                acceptationBean.getDate(),
                acceptationBean.getTime(),
                acceptationBean.getTourName());

        ReservationDAOFactory reservationDAOFactory = new ReservationDAOFactory();
        try {
            ReservationDAO reservationDAO = reservationDAOFactory.createReservationDAO();
            reservationDAO.changeStatus(reservation);
            reservation.notifyPublication();
        } catch (Exception e){
            Logger.getAnonymousLogger().log(Level.INFO, e.getMessage());
        }



    }
}
