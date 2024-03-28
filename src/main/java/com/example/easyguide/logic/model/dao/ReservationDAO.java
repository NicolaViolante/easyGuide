package com.example.easyguide.logic.model.dao;

import com.example.easyguide.logic.beans.ReservationInfoBean;
import com.example.easyguide.logic.model.domain.Reservation;
import com.example.easyguide.logic.model.domain.User;
import com.opencsv.exceptions.CsvValidationException;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public interface ReservationDAO {
    void registerReservation(Reservation reservation) throws SQLException, IOException, CsvValidationException;

    List<Reservation> findTourToAcceptOrDecline(User user) throws SQLException, IOException, CsvValidationException;

    void changeStatus(Reservation reservation) throws SQLException, IOException, CsvValidationException;
}
