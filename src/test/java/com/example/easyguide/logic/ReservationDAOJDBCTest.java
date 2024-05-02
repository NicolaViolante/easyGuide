package com.example.easyguide.logic;

import com.example.easyguide.logic.model.dao.ReservationDAOJDBC;
import com.example.easyguide.logic.model.domain.Reservation;
import com.example.easyguide.logic.model.domain.Role;
import com.example.easyguide.logic.model.domain.User;
import com.example.easyguide.logic.session.ConnectionFactory;
import com.example.easyguide.logic.session.SessionManager;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.sql.*;
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
            assertEquals(0, reservation.getState().getId());
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
                Time.valueOf("20:00:00"),
                Date.valueOf("2024-03-18"),
                12F,
                "A spasso per Roma"
        );
        try{
            int i = reservationDAOJDBC.registerReservation(reservation);
            assertEquals(1,i);
        }catch (Exception e){
            fail();
        }
    }
    @AfterAll
    public static void cleanUpTable(){
        Connection connection = ConnectionFactory.getConnection();
        try{
            PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM reservation WHERE time = '20:00:00'");
            preparedStatement.execute();
        }catch (SQLException e){
            e.printStackTrace();
            fail();
        }
    }
}
