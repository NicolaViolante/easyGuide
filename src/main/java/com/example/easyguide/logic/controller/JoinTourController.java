package com.example.easyguide.logic.controller;

import com.example.easyguide.logic.beans.TourBean;
import com.example.easyguide.logic.beans.TourSearchBean;
import com.example.easyguide.logic.model.dao.TourDAO;
import com.example.easyguide.logic.model.domain.Tour;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class JoinTourController {
    public List<TourBean> findTourOfCity(TourSearchBean tourSearchBean) throws SQLException {

        List<Tour> tourList = new TourDAO().findTourOfTheCity(tourSearchBean);
        List<TourBean> tourBeansList = new ArrayList<>();

            for (Tour tour : tourList){
                TourBean tourBean = new TourBean(tour.getName(), tour.getPrice());
                tourBeansList.add(tourBean);
            }

        return tourBeansList;
    }
}
