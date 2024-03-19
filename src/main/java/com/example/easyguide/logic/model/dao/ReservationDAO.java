package com.example.easyguide.logic.model.dao;

import com.example.easyguide.logic.beans.AcceptationBean;
import com.example.easyguide.logic.beans.RequestSearchBean;
import com.example.easyguide.logic.beans.ReservationInfoBean;
import com.example.easyguide.logic.model.domain.Reservation;
import com.example.easyguide.logic.model.domain.Tour;
import com.example.easyguide.logic.session.ConnectionFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ReservationDAO {
    protected static final String GUIDEMAIL = "guidemail";
    protected static final String TOURISTMAIL = "touristmail";
    protected static final String PEOPLE = "people";
    protected static final String TIME = "time";
    protected static final String DATE = "date";
    protected static final String PRICE = "price";
    protected static final String TOURNAME = "tourname";
    protected static final String STATE = "state";

    public void registerReservation(ReservationInfoBean reservationInfoBean) throws SQLException {
        PreparedStatement stmt = null;
        Connection conn = null;
        Integer result = -1;

        conn = ConnectionFactory.getConnection();

        String sql = "INSERT INTO reservation (" + GUIDEMAIL + ", " + TOURISTMAIL +", " + PEOPLE +", " + TIME + ", " + DATE
                + ", " + PRICE + ", " + TOURNAME + ", " + STATE  + ")"
                + " VALUES(?, ?, ?, ?, ?, ?, ?, ?)";

        // TYPE_SCROLL_INSENSITIVE: ResultSet can be slided but is sensible to db data variations
        stmt = conn.prepareStatement(sql, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
        stmt.setString(1, reservationInfoBean.getGuideMail());
        stmt.setString(2, reservationInfoBean.getTouristMail());
        stmt.setInt(3, reservationInfoBean.getPeople());
        stmt.setTime(4, reservationInfoBean.getTime());
        stmt.setDate(5, reservationInfoBean.getDate());
        stmt.setFloat(6, reservationInfoBean.getPrice());
        stmt.setString(7, reservationInfoBean.getTourName());
        stmt.setInt(8, 0);

        result = stmt.executeUpdate();

        if (result > 0) {
            Logger.getAnonymousLogger().log(Level.INFO, "ROW INSERTED");
        } else {
            Logger.getAnonymousLogger().log(Level.INFO, "ROW NOT INSERTED");
        }

        stmt.close();

    }

    public List<Reservation> findTourDetailsByMail(RequestSearchBean requestSearch) throws SQLException {
        List<Reservation> reservations = new ArrayList<>();
        PreparedStatement stmt = null;
        Connection conn = null;

        conn = ConnectionFactory.getConnection();

        String sql = "SELECT " + TOURISTMAIL + "," + PEOPLE + "," + TIME + "," + DATE + "," + PRICE + "," +
                TOURNAME  +" FROM reservation WHERE " + GUIDEMAIL + " = ?" + " AND " + STATE + " = ?";

        stmt = conn.prepareStatement(sql, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
        stmt.setString(1, requestSearch.getMail());
        stmt.setInt(2, 0);

        ResultSet rs = stmt.executeQuery();

        while (rs.next()){
            Reservation reservation = new Reservation(rs.getString(1), rs.getInt(2), rs.getTime(3),
                    rs.getDate(4), rs.getFloat(5), rs.getString(6));
            reservations.add(reservation);

        }

        rs.close();
        stmt.close();

        return reservations;
    }

    public void changeStatus(AcceptationBean acceptationBean) throws SQLException{
        PreparedStatement stmt = null;
        Connection conn = null;
        Integer result = -1;

        conn = ConnectionFactory.getConnection();

        String sql = "UPDATE reservation SET " + STATE + " = ?" + " WHERE " + TOURISTMAIL + " = ?" +" and " + GUIDEMAIL + " = ?" +" and "
                + DATE + " = ?" +" and " + TIME + " = ?"  + " and " + TOURNAME + " = ?";
        // TYPE_SCROLL_INSENSITIVE: ResultSet can be slided but is sensible to db data variations
        stmt = conn.prepareStatement(sql, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
        stmt.setInt(1, acceptationBean.getState());
        stmt.setString(2, acceptationBean.getTouristMail());
        stmt.setString(3, acceptationBean.getGuideMail());
        stmt.setDate(4, acceptationBean.getDate());
        stmt.setTime(5, acceptationBean.getTime());
        stmt.setString(6,acceptationBean.getTourName());

        result = stmt.executeUpdate();

        if (result > 0) {
            Logger.getAnonymousLogger().log(Level.INFO, "ROW INSERTED");
        } else {
            Logger.getAnonymousLogger().log(Level.INFO, "ROW NOT INSERTED");
        }

        stmt.close();

    }
}
