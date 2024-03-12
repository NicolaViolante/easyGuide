package com.example.easyguide.logic.beans;

import com.example.easyguide.logic.exceptions.InvalidFormatException;

public class SignUpBean {
    private final String username;
    private final String name;
    private final String surname;
    private final String email;
    private final String password;
    private final String role;

    public SignUpBean(String username, String name, String surname, String email, String password, String role) throws InvalidFormatException{
        checkAttributes(username, name, surname, email, password, role);
        this.username = username;
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.password = password;
        this.role = role;
    }
    public String getUsername() { return username; }
    public String getName() { return name; }
    public String getSurname() { return surname; }
    public String getEmail() { return email; }
    public String getPassword() { return password; }
    public String getRole() { return role; }

    private void checkAttributes(String username, String name, String surname, String email, String password, String role) throws InvalidFormatException{
        if(username.isEmpty() || name.isEmpty() || surname.isEmpty() || email.isEmpty() || password.isEmpty() || role.isEmpty())
            throw new InvalidFormatException("there is one or more empty fields\n");
    }
}
