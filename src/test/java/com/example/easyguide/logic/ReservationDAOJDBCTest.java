package com.example.easyguide.logic;

import com.example.easyguide.logic.model.dao.ReservationDAOJDBC;
import com.example.easyguide.logic.model.domain.Reservation;
import com.example.easyguide.logic.model.domain.Role;
import com.example.easyguide.logic.model.domain.User;
import com.example.easyguide.logic.session.SessionManager;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

class ReservationDAOJDBCTest {
    @Test
    void findToursToAccept() {
        ReservationDAOJDBC reservationDAOJDBC = new ReservationDAOJDBC();
        User user = new User("NicoViolans","Nicola","Violante","nico.violans@gmail.com", Role.GUIDE);
        try{
            List<Reservation> reservations = reservationDAOJDBC.findTourToAcceptOrDecline(user);
            for(Reservation reservation : reservations){
            assertEquals(0, reservation.getState());
            }
        } catch (SQLException e){
            Assertions.fail(e.getMessage());
        }
    }
}
