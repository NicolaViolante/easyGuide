package com.example.easyguide.logic.controller;

import com.example.easyguide.logic.beans.SignUpBean;
import com.example.easyguide.logic.model.dao.UserDAO;
import com.example.easyguide.logic.model.domain.Role;
import com.example.easyguide.logic.model.domain.User;

import java.sql.SQLException;

public class SignUpController extends AbstractController {
    public int signUp(SignUpBean signUpBean) throws SQLException {
        User user = null;
        int result = -1;

        User newUser = new User(signUpBean.getUsername(),
                signUpBean.getName(),
                signUpBean.getSurname(),
                signUpBean.getEmail(),
                signUpBean.getPassword(),
                Role.valueOf(signUpBean.getRole().toUpperCase()));

        user = new UserDAO().findUsername(newUser);

        if (user == null) {
            result = new UserDAO().registerUser(newUser);
        } else return result;
        Role role = Role.valueOf(signUpBean.getRole().toUpperCase());

        storeSessionUser(signUpBean.getUsername(),
                signUpBean.getName(),
                signUpBean.getSurname(),
                signUpBean.getEmail(),
                role);
        return result;
    }
}
