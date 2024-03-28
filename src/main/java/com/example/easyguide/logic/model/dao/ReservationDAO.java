package com.example.easyguide.logic.model.dao;

import com.example.easyguide.logic.beans.ReservationInfoBean;
import com.example.easyguide.logic.model.domain.Reservation;
import com.example.easyguide.logic.model.domain.User;

import java.sql.SQLException;
import java.util.List;

public interface ReservationDAO {
    void registerReservation(ReservationInfoBean reservationInfoBean) throws SQLException;

    List<Reservation> findTourToAcceptOrDecline(User user) throws SQLException;

    void changeStatus(Reservation reservation) throws SQLException;
}
