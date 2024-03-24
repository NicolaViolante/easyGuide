package com.example.easyguide.logic.model.dao;

import com.example.easyguide.logic.exceptions.DAOException;
import com.example.easyguide.logic.model.domain.Role;
import com.example.easyguide.logic.model.domain.User;
import com.example.easyguide.logic.session.ConnectionFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class UserDAO {

    protected static final String USERNAME = "Username";
    protected static final String NAME = "Name";
    protected static final String SURNAME = "Surname";
    protected static final String EMAIL = "Email";
    protected static final String PSW = "Password";
    protected static final String ROLE = "Role";

    protected User getUser(ResultSet rs) throws SQLException {
        User user;
        Role role;

        if(rs.getString(ROLE).equals("tourist"))
            role = Role.TOURIST;
        else
            role = Role.GUIDE;

        user = new User(
                rs.getString(USERNAME),
                rs.getString(NAME),
                rs.getString(SURNAME),
                rs.getString(EMAIL),
                role);

        return user;
    }

    //DB calls

    public User findUsername(String username ) throws SQLException {
        PreparedStatement stmt = null;
        Connection conn = null;
        User user = null;

        conn = ConnectionFactory.getConnection();

        String sql = "SELECT * FROM user WHERE " + USERNAME + " = ?";
        // TYPE_SCROLL_INSENSITIVE: ResultSet can be slided but is sensible to db data variations
        try {
            stmt = conn.prepareStatement(sql, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            stmt.setString(1, username);

            ResultSet rs = stmt.executeQuery();

            // Verify if ResultSet is empty
            if (!rs.first()) {
                return null;
            }

            // Repositioning of the cursor
            rs.first();

            user = getUser(rs);

            // Closing ResultSet and freeing resources
            rs.close();
        }
        finally {
            assert stmt != null;
            stmt.close();
        }
        return user;
    }

    public User findUser(String username, String password) throws DAOException, SQLException {
        PreparedStatement stmt = null;
        Connection conn = null;
        User user = null;

        conn = ConnectionFactory.getConnection();

        String sql = "SELECT * FROM user WHERE " + USERNAME + " = ? AND " + PSW + " = ?;";
        // TYPE_SCROLL_INSENSITIVE: ResultSet can be slided but is sensible to db data variations
        try {
            stmt = conn.prepareStatement(sql, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            stmt.setString(1, username);
            stmt.setString(2, password);

            ResultSet rs = stmt.executeQuery();

            // Verify if ResultSet is empty
            if (!rs.first()) {
                throw new DAOException("Utente non trovato(username o password errati)");
            }

            // Repositioning of the cursor
            rs.first();

            user = getUser(rs);

            // Closing ResultSet and freeing resources
            rs.close();
        }
        finally{
            assert stmt != null;
            stmt.close();
        }

        return user;
    }

    public Integer registerUser(String username, String name, String surname, String email, String psw, String role) throws SQLException {
        PreparedStatement stmt = null;
        Connection conn = null;
        Integer result = -1;

        conn = ConnectionFactory.getConnection();

        String sql = "INSERT INTO user (" + USERNAME + ", " + NAME +", " + SURNAME +", " + EMAIL + ", " + PSW + ", " + ROLE + ")"
                + " VALUES(?, ?, ?, ?, ?, ?)";
        // TYPE_SCROLL_INSENSITIVE: ResultSet can be slided but is sensible to db data variations
        try {
            stmt = conn.prepareStatement(sql, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            stmt.setString(1, username);
            stmt.setString(2, name);
            stmt.setString(3, surname);
            stmt.setString(4, email);
            stmt.setString(5, psw);
            stmt.setString(6, role);

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
}
