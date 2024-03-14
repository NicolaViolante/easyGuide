package com.example.easyguide.logic.controller;

import com.example.easyguide.logic.beans.SelectedTourBean;
import com.example.easyguide.logic.beans.SpecifiedTourBean;
import com.example.easyguide.logic.beans.TourBean;
import com.example.easyguide.logic.beans.TourSearchBean;
import com.example.easyguide.logic.model.dao.TourDAO;
import com.example.easyguide.logic.model.domain.Tour;

import java.io.File;
import java.sql.SQLException;
import java.sql.Time;
import java.util.ArrayList;
import java.util.Date;
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

    public List<SpecifiedTourBean> showTour(SelectedTourBean selectedTourBean) throws SQLException{
        List<Tour> tourList = new TourDAO().findTourDetails(selectedTourBean);
        List<SpecifiedTourBean> specifiedTourBeanList = new ArrayList<>();
        System.out.printf("rwsadFAEF\n");
        System.out.printf("rwsadFAEF\n");
        System.out.printf("rwsadFAEF\n");
        System.out.printf("rwsadFAEF\n");
        System.out.printf("rwsadFAEF\n");


        System.out.printf("%s\n" ,tourList.get(0).getTimes().get(0));
        System.out.printf("%s\n" ,tourList.get(0).getTimes().get(1));

        System.out.printf("rwsadFAEF");
        System.out.printf("rwsadFAEF");
        System.out.printf("rwsadFAEF");
        System.out.printf("rwsadFAEF");


        for (Tour tour : tourList){
            SpecifiedTourBean specifiedTourBean = new SpecifiedTourBean(tour.getPhoto(), tour.getName(), tour.getDescription(),
                    tour.getGuide(), tour.getPrice(), tour.getDuration(), tour.getDate(), tour.getTimes());
            specifiedTourBeanList.add(specifiedTourBean);
        }

        return specifiedTourBeanList;
    }
}
