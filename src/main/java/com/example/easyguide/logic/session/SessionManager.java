package com.example.easyguide.logic.session;

import com.example.easyguide.logic.exceptions.SessionUserException;
import com.example.easyguide.logic.model.domain.User;

import java.util.ArrayList;
import java.util.List;

public class SessionManager {
    private static SessionManager instance = null;
    protected User currentUser;
   // protected List<User> loggedUsers;
    public User getCurrentUser() {return currentUser;}
 //   public List<User> getLoggedUsers() {return loggedUsers;}

    protected SessionManager() {
     //   loggedUsers = new ArrayList<>();
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
