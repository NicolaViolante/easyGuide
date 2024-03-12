package com.example.easyguide.logic.beans;

import com.example.easyguide.logic.exceptions.InvalidFormatException;

public class TourSearchBean {
    private final String city;
    public TourSearchBean(String city) throws InvalidFormatException {
        checkCity(city);
        this.city = city;
    }
    public String getCity() { return city; }

    private void checkCity(String city) throws InvalidFormatException{
        if(city.isEmpty() || city.isBlank())
            throw new InvalidFormatException("Invalid city format");
    }
}