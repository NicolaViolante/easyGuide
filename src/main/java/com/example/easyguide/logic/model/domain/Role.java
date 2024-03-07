package com.example.easyguide.logic.model.domain;


public enum Role {
    TOURIST("tourist"),
    GUIDE("guide");

    private final String id;
    private Role(String id) { this.id = id; }

    public static Role fromString(String id){
        for(Role type : values()){
            if(type.getId().equals(id)){
                return type;
            }
        }
        return null;
    }
    public String getId() {return id; }
}


