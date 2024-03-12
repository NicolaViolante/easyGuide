package com.example.easyguide.logic.beans;

public class TourBean {
    private final String tourName;
    private final float price;
    public TourBean(String tourName, float price) {
        this.tourName = tourName;
        this.price = price;
    }

    public String getTourName() { return tourName; }
    public float getPrice() { return price; }
}
