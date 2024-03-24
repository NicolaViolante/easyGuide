package com.example.easyguide.logic.model.domain;


public enum Role {
    TOURIST("tourist"),
    GUIDE("guide");

    private final String id;
    private Role(String id) { this.id = id; }

    public String getId() {return id; }
}


