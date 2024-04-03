package com.example.easyguide.logic.model.dao;


import com.example.easyguide.logic.model.domain.Tour;
import com.example.easyguide.logic.session.ConnectionFactory;

import java.util.ArrayList;
import java.util.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class TourDAO {
    protected static final  String PHOTO = "photo";
    protected static final  String NAME = "name";
    protected static final  String DESCRIPTION = "description";
    protected static final  String GUIDE = "guide";
    protected static final  String GUIDEMAIL = "guidemail";
    protected static final  String PRICE = "price";
    protected static final  String DURATION = "duration";
    protected static final   String DATE = "date";
    protected static final  String TIMES = "times";
    protected static final  String CITY = "city";
    protected static final String FTW = " FROM tour WHERE ";
    protected static final String SD = " SELECT DISTINCT ";

    public List<Tour> findTourOfTheCity(Tour selectedCity) throws SQLException{
        List<Tour> tours = new ArrayList<>();

        PreparedStatement stmt = null;
        Connection conn = null;

        conn = ConnectionFactory.getConnection();

        String sql = SD + NAME + "," + PRICE + FTW + CITY + " = ?";

        try {
            stmt = conn.prepareStatement(sql, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            stmt.setString(1, selectedCity.getCity());

            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Tour tour = new Tour(rs.getString(1), rs.getFloat(2));
                tours.add(tour);
            }
            rs.close();
        }
        finally{
            assert stmt != null;
            stmt.close();
        }

        return tours;
    }

    public List<Tour> findTourDetails(Tour selectedTour) throws SQLException {
        List<Tour> tours = new ArrayList<>();
        PreparedStatement stmt = null;
        Connection conn = null;
        PreparedStatement stmt2 = null;

        conn = ConnectionFactory.getConnection();

        String sql = SD + PHOTO + "," + NAME + "," + DESCRIPTION + "," + GUIDE + "," + GUIDEMAIL + "," +
                PRICE + "," + DURATION + "," + DATE + "," + CITY +FTW + NAME + " = ?";

        try{
        stmt = conn.prepareStatement(sql, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
        stmt.setString(1, selectedTour.getName());

        ResultSet rs = stmt.executeQuery();

        while (rs.next()){
            Tour tour = new Tour( rs.getString(2), rs.getString(3),
                     rs.getFloat(6),rs.getFloat(7),
            rs.getDate(8),rs.getString(9));
            tour.setGuideGuideMail(rs.getString(4),rs.getString(5));
            tours.add(tour);
            String sql1 = SD + TIMES + FTW + NAME + " = ?" + " and " + DATE + " = ?";

            try {


            stmt2 = conn.prepareStatement(sql1, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            stmt2.setString(1, tour.getName());
            stmt2.setDate(2, tour.getDate());

            ResultSet rs2 = stmt2.executeQuery();
            while(rs2.next()){
                tour.addTimes(rs2.getTime(1));
            }
            rs2.close();}
            finally {
                assert stmt2 != null;
                stmt2.close();
            }

        }

        rs.close();}
        finally {
            assert stmt != null;
            stmt.close();
        }


        return tours;
    }


}
