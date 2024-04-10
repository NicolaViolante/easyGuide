package com.example.easyguide.logic.controller;

import com.example.easyguide.logic.beans.CredentialsBean;
import com.example.easyguide.logic.exceptions.DAOException;
import com.example.easyguide.logic.model.dao.UserDAO;
import com.example.easyguide.logic.model.domain.User;
import com.example.easyguide.logic.session.SessionManager;

import java.sql.SQLException;

public class LoginController extends AbstractController {

    public void login(CredentialsBean credentialsBean) throws DAOException, SQLException {
        User userCred = new User(
                credentialsBean.getUsername(),
                credentialsBean.getPassword()
        );
        User user = new UserDAO().findUser(userCred);

        storeSessionUser(user.getUsername(),
                user.getName(),
                user.getSurname(),
                user.getEmail(),
                user.getUserType());
    }
    public void logout(){
        SessionManager sessionManager = SessionManager.getInstance();
            sessionManager.logout();
    }
}

