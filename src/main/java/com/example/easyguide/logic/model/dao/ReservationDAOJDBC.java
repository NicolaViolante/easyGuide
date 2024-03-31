package com.example.easyguide.logic.model.dao;

import com.example.easyguide.logic.model.domain.Reservation;
import com.example.easyguide.logic.model.domain.User;
import com.example.easyguide.logic.session.ConnectionFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ReservationDAOJDBC implements ReservationDAO{
    protected static final String GUIDEMAIL = "guidemail";
    protected static final String TOURISTMAIL = "touristmail";
    protected static final String PEOPLE = "people";
    protected static final String TIME = "time";
    protected static final String DATE = "date";
    protected static final String PRICE = "price";
    protected static final String TOURNAME = "tourname";
    protected static final String STATE = "state";
    protected static final String AND = " and ";

    @Override
    public int registerReservation(Reservation reservationInfo) throws SQLException {
        PreparedStatement stmt = null;
        Connection conn = null;
        Integer result = -1;

        conn = ConnectionFactory.getConnection();

        String sql = "INSERT INTO reservation (" + GUIDEMAIL + ", " + TOURISTMAIL +", " + PEOPLE +", " + TIME + ", " + DATE
                + ", " + PRICE + ", " + TOURNAME + ", " + STATE  + ")"
                + " VALUES(?, ?, ?, ?, ?, ?, ?, ?)";

        // TYPE_SCROLL_INSENSITIVE: ResultSet can be slided but is sensible to db data variations
        try {
            stmt = conn.prepareStatement(sql, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            stmt.setString(1, reservationInfo.getGuideMail());
            stmt.setString(2, reservationInfo.getTouristMail());
            stmt.setInt(3, reservationInfo.getPeople());
            stmt.setTime(4, reservationInfo.getTime());
            stmt.setDate(5, reservationInfo.getDate());
            stmt.setFloat(6, reservationInfo.getPrice());
            stmt.setString(7, reservationInfo.getTourName());
            stmt.setInt(8, 0);

            result = stmt.executeUpdate();

            if (result > 0) {
                Logger.getAnonymousLogger().log(Level.INFO, "ROW INSERTED");
            } else {
                Logger.getAnonymousLogger().log(Level.INFO, "ROW NOT INSERTED");
            }
        }
        finally {
            assert stmt != null;
            stmt.close();
        }
        return result;
    }
    @Override
    public List<Reservation> findTourToAcceptOrDecline(User user) throws SQLException {
        List<Reservation> reservations = new ArrayList<>();
        PreparedStatement stmt = null;
        Connection conn = null;

        conn = ConnectionFactory.getConnection();

        String sql = "SELECT " + TOURISTMAIL + "," + PEOPLE + "," + TIME + "," + DATE + "," + PRICE + "," +
                TOURNAME  +" FROM reservation WHERE " + GUIDEMAIL + " = ?" + AND + STATE + " = ?";

        try {
            stmt = conn.prepareStatement(sql, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            stmt.setString(1, user.getEmail());
            stmt.setInt(2, 0);

            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Reservation reservation = new Reservation(rs.getString(1), rs.getInt(2), rs.getTime(3),
                        rs.getDate(4), rs.getFloat(5), rs.getString(6));
                reservations.add(reservation);

            }

            rs.close();
        }
        finally {
            assert stmt != null;
            stmt.close();
        }
        return reservations;
    }
    @Override
    public void changeStatus(Reservation reservation) throws SQLException{
        PreparedStatement stmt = null;
        PreparedStatement stmt1 = null;
        Connection conn = null;
        Integer result = -1;

        conn = ConnectionFactory.getConnection();

        String sql = "UPDATE reservation SET " + STATE + " = ?" + " WHERE " + TOURISTMAIL + " = ?" +AND + GUIDEMAIL + " = ?" +AND
                + DATE + " = ?" +AND + TIME + " = ?"  + AND + TOURNAME + " = ?";
        // TYPE_SCROLL_INSENSITIVE: ResultSet can be slided but is sensible to db data variations
        try{
        stmt = conn.prepareStatement(sql, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
        stmt.setInt(1, reservation.getState().getId());
        stmt.setString(2, reservation.getTouristMail());
        stmt.setString(3, reservation.getGuideMail());
        stmt.setDate(4, reservation.getDate());
        stmt.setTime(5, reservation.getTime());
        stmt.setString(6,reservation.getTourName());

        result = stmt.executeUpdate();

        if (result > 0) {
            Logger.getAnonymousLogger().log(Level.INFO, "ROW INSERTED");
        } else {
            Logger.getAnonymousLogger().log(Level.INFO, "ROW NOT INSERTED");
        }}
        finally {
            assert stmt != null;
            stmt.close();
        }
        String sql1 = "SELECT " + PEOPLE + "," +  PRICE + " FROM reservation WHERE " + TOURISTMAIL + " = ?" +AND + GUIDEMAIL + " = ?" +AND
                + DATE + " = ?" +AND + TIME + " = ?"  + AND + TOURNAME + " = ?";
        try {
            stmt1 = conn.prepareStatement(sql1, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            stmt1.setString(1, reservation.getTouristMail());
            stmt1.setString(2, reservation.getGuideMail());
            stmt1.setDate(3, reservation.getDate());
            stmt1.setTime(4, reservation.getTime());
            stmt1.setString(5, reservation.getTourName());

            ResultSet rs = stmt1.executeQuery();
            while (rs.next()) {
                reservation.setPeople(rs.getInt(1));
                reservation.setPrice(rs.getFloat(2));
            }
            rs.close();
        }
        finally {
            assert stmt1 != null;
            stmt1.close();
        }


    }
}
