package com.example.easyguide.logic.model.domain;

public class User {
    protected String username;
    protected String name;
    protected String surname;
    protected String email;
    protected Role role;
    protected String password;

    public User(String username, String name, String surname, String email, Role role) {
        this.username = username;
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.role = role;
    }
    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public User(String username, String name, String surname, String email, String password, Role role) {
        this.password = password;
        this.username = username;
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.role = role;
    }

    public String getUsername() {
        return username;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }
    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }

    public Role getUserType() {
        return role;
    }
}