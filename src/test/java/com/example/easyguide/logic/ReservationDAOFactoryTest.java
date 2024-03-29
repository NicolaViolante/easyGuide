package com.example.easyguide.logic;

import com.example.easyguide.logic.model.dao.ReservationDAO;
import com.example.easyguide.logic.pattern.ReservationDAOFactory;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;

class ReservationDAOFactoryTest {

    @Test
    void createCategoryDAO() {
        try{
            ReservationDAOFactory reservationDAOFactory = new ReservationDAOFactory();
            ReservationDAO reservationDAO = reservationDAOFactory.createReservationDAO();

        } catch (IOException e) {
            Assertions.fail();
        }
    }
}
