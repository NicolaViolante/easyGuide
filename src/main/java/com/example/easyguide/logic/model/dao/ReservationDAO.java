package com.example.easyguide.logic.model.dao;

import com.example.easyguide.logic.beans.ReservationInfoBean;
import com.example.easyguide.logic.session.ConnectionFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ReservationDAO {
    protected static final String GUIDMAIL = "guidemail";
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

        String sql = "INSERT INTO reservation (" + GUIDMAIL + ", " + TOURISTMAIL +", " + PEOPLE +", " + TIME + ", " + DATE
                + ", " + PRICE + ", " +TOURNAME + ", " + STATE  + ")"
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
        stmt.setInt(8, 1);

        result = stmt.executeUpdate();

        if (result > 0) {
            Logger.getAnonymousLogger().log(Level.INFO, "ROW INSERTED");
        } else {
            Logger.getAnonymousLogger().log(Level.INFO, "ROW NOT INSERTED");
        }

        stmt.close();

    }
}
