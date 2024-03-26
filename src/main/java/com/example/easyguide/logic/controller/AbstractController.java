package com.example.easyguide.logic.controller;

import com.example.easyguide.logic.model.domain.Role;
import com.example.easyguide.logic.model.domain.User;
import com.example.easyguide.logic.session.SessionManager;

public abstract class AbstractController {
    protected void storeSessionUser(String username, String name, String surname, String email, Role role) {
        SessionManager sessionManager = SessionManager.getInstance();
        User currentUser = new User(username,
                name,
                surname,
                email,
                role);
        sessionManager.login(currentUser);
    }
    public static Role getCurrentRole() {
        return SessionManager.getInstance().getCurrentUser().getUserType();
    }
}
