package com.example.easyguide.logic.session;

import com.example.easyguide.logic.model.domain.User;


public class SessionManager {
    private static SessionManager instance = null;

    protected User currentUser;
    public User getCurrentUser() {return currentUser;}
    private SessionManager() {
        currentUser = null;
    }

    public static synchronized SessionManager getInstance(){
        if(SessionManager.instance == null)
            SessionManager.instance = new SessionManager();
        return instance;
    }

    public synchronized void login(User user) {
        currentUser = user;
    }

    public synchronized void logout(){
        currentUser = null;
    }
}
