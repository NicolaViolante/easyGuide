package com.example.easyguide.logic.beans;

import com.example.easyguide.logic.exceptions.InvalidFormatException;

public class CredentialsBean {
    private final String username;
    private final String password;
    public CredentialsBean(String username, String password) {
        this.username = username;
        this.password = password;
    }
    public String getUsername() { return username; }
    public String getPassword() { return password; }

    private void checkUsername(String username) throws InvalidFormatException{
        if(username.isEmpty() || username.isBlank())
            throw new InvalidFormatException("Invalid username format");
    }
    private void checkPassword(String password) throws InvalidFormatException{
        if(password.isEmpty() || password.isBlank())
            throw new InvalidFormatException("Invalid username format");
    }
}
