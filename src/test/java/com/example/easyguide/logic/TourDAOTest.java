package com.example.easyguide.logic;

import com.example.easyguide.logic.model.dao.TourDAO;
import com.example.easyguide.logic.model.domain.Tour;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class TourDAOTest {
    TourDAO tourDAO = new TourDAO();
    @Test
    void searchTour(){

        Tour tour = new Tour("Roma");
        try{
            List<Tour> tours = tourDAO.findTourOfTheCity(tour);
            assertEquals("A spasso per Roma", tours.getFirst().getName());
        }catch (Exception e){
            Assertions.fail(e.getMessage());
        }
    }
    @Test
    void searchDetails() {
        Tour tour = new Tour();
        tour.setTourName("A spasso per Roma");

        try {
            List<Tour> tours = tourDAO.findTourDetails(tour);
            assertEquals(12, tours.getFirst().getPrice());
        } catch (Exception e) {
            Assertions.fail(e.getMessage());
        }
    }
}
