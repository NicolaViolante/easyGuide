package com.example.easyguide.logic.session;

import com.example.easyguide.logic.exceptions.SessionUserException;
import com.example.easyguide.logic.model.domain.User;

import java.util.ArrayList;
import java.util.List;

public class SessionManager {
    private static SessionManager instance = null;
    protected User currentUser;
    public User getCurrentUser() {return currentUser;}
    protected SessionManager() {
        currentUser = null;
    }

    public static synchronized SessionManager getInstance(){
        if(SessionManager.instance == null)
            SessionManager.instance = new SessionManager();
        return instance;
    }

    public synchronized void login(User user) throws SessionUserException{
        currentUser = user;
    }

    public synchronized void logout(){
        currentUser = null;
    }
}
