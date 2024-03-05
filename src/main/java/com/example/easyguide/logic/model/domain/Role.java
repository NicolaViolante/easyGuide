package com.example.easyguide.logic.model.domain;

public enum Role {
    TOURIST(1),
    GUIDE(2);

    private final int id;
    private Role(int id) { this.id = id; }

    public static Role fromInt(int id){
        for (Role type : values()){
            if (type.getId() == id){
                return type;
            }
        }
        return null;
    }
    public int getId() {return id; }
}


