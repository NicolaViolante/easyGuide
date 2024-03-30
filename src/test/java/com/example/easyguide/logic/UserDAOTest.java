package com.example.easyguide.logic;

import com.example.easyguide.logic.model.dao.UserDAO;
import com.example.easyguide.logic.model.domain.User;
import com.example.easyguide.logic.session.ConnectionFactory;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import static org.junit.jupiter.api.Assertions.*;


class UserDAOTest {
    @Test
    void signUp(){
        UserDAO userDAO = new UserDAO();

        try{
            int i = userDAO.registerUser("NicoViolans77",
                    "Nicola",
                    "Violante",
                    "nico.violans77@gmail.com",
                    "NicoViolans",
                    "guide");
            assertEquals(1,i);
        }
        catch (SQLException ignored){
        }
    }
    @Test
    void findUser(){
        UserDAO userDAO = new UserDAO();
        User user;
        try {
            user = userDAO.findUser("NicoViolans",
                    "NicoViolans");
            assertEquals("Nicola",user.getName());
            assertEquals("Violante",user.getSurname());
            assertEquals("GUIDE",user.getUserType().toString());
            assertEquals("nico.violans@gmail.com",user.getEmail());
        }catch (Exception e){
            Assertions.fail(e.getMessage());
        }

    }
    @AfterAll
    public static void cleanUpTable(){
        Connection connection = ConnectionFactory.getConnection();
        try{
            PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM user WHERE Email = 'nico.violans77@gmail.com'");
            preparedStatement.execute();
        }catch (SQLException ignore){
        }
    }

}
