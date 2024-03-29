package com.example.easyguide.logic;

import com.example.easyguide.logic.model.dao.UserDAO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;


class UserDAOTest {
    @Test
    void signUp(){
        UserDAO userDAO = new UserDAO();

        try{
            userDAO.registerUser("NicoViolans",
                    "Nicola",
                    "Violante",
                    "nico.violans@gmail.com",
                    "NicoViolans",
                    "guide");
            Assertions.fail();
        }
        catch (SQLException ignored){
        }
    }
    @Test
    void findUser(){
        UserDAO userDAO = new UserDAO();

        try {
            userDAO.findUser("NicoViolans",
                    "NicoViolans");
        }catch (Exception e){
            Assertions.fail(e.getMessage());
        }

    }
}
