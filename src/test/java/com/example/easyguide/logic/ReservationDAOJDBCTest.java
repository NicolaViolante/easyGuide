package com.example.easyguide.logic;

import com.example.easyguide.logic.model.dao.ReservationDAOJDBC;
import com.example.easyguide.logic.model.domain.Reservation;
import com.example.easyguide.logic.model.domain.Role;
import com.example.easyguide.logic.model.domain.User;
import com.example.easyguide.logic.session.SessionManager;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.sql.Date;
import java.sql.SQLException;
import java.sql.Time;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

class ReservationDAOJDBCTest {
    ReservationDAOJDBC reservationDAOJDBC = new ReservationDAOJDBC();
    @Test
    void findToursToAccept() {

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
    @Test
    void registerReservation(){
        Reservation reservation = new Reservation("nico.violans@gmail.com",
                "ggvv70@gmail.com",
                3,
                Time.valueOf("18:00:00"),
                Date.valueOf("2024-03-18"),
                12F,
                "A spasso per Roma"
        );
        try{
            reservationDAOJDBC.registerReservation(reservation);
            Assertions.fail();
        }catch (Exception ignored){
        }
    }
}
