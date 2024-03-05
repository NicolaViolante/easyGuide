package com.example.easyguide.logic.controller;

import com.example.easyguide.logic.beans.CredentialsBean;
import com.example.easyguide.logic.exceptions.DAOException;
import com.example.easyguide.logic.exceptions.SessionUserException;
import com.example.easyguide.logic.model.dao.UserDAO;
import com.example.easyguide.logic.model.domain.User;

import java.sql.SQLException;

public class LoginController extends AbstractController {

    public void login(CredentialsBean credentialsBean) throws DAOException, SQLException, SessionUserException {
        int a;
        User user = new UserDAO().findUser(
                credentialsBean.getUsername(),
                credentialsBean.getPassword());

        storeSessionUser(user.getUsername(), user.getName(), user.getSurname(), user.getEmail(), user.getUserType());
    }
}
