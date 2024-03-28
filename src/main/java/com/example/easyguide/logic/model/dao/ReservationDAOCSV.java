package com.example.easyguide.logic.model.dao;

import com.example.easyguide.logic.beans.ReservationInfoBean;
import com.example.easyguide.logic.model.domain.Reservation;
import com.example.easyguide.logic.model.domain.User;

import java.sql.SQLException;
import java.util.List;

public class ReservationDAOCSV implements ReservationDAO{
    @Override
    public void registerReservation(ReservationInfoBean reservationInfoBean){}

    @Override
    public List<Reservation> findTourToAcceptOrDecline(User user) throws SQLException {
        return null;
    }

    @Override
    public void changeStatus(Reservation reservation) throws SQLException {

    }
}
