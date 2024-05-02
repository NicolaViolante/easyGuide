package com.example.easyguide.logic.session;

import com.example.easyguide.logic.model.domain.User;


public class SessionManager {
    private static SessionManager instance;

    protected User currentUser;
    public User getCurrentUser() {return currentUser;}
    private SessionManager() {
        currentUser = null;
    }

    public static SessionManager getInstance(){
        if(SessionManager.instance == null)
            SessionManager.instance = new SessionManager();
        return instance;
    }

    public void login(User user) {
        currentUser = user;
    }

    public void logout(){
        currentUser = null;
    }
}
