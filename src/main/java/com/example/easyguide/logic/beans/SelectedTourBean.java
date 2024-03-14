package com.example.easyguide.logic.beans;

import com.example.easyguide.logic.exceptions.InvalidFormatException;

public class SelectedTourBean {
    private final String tour;
    public SelectedTourBean(String tour) throws InvalidFormatException {
        this.tour = tour;
    }
    public String getTour() { return tour; }

}
