package com.example.easyguide.logic.model.domain;

import java.sql.Time;
import java.util.ArrayList;
import java.util.List;

public class Tour {
    private String name;
    private String description;
    private String guide;
    private String guideMail;
    private Float price;
    private Float duration;
    private java.sql.Date date;
    private List<java.sql.Time> times = new ArrayList<>();
    private String city;



    public Tour( String city) {
        this.city = city;
    }
    public Tour() {

    }

    public Tour(String name, String description, Float price, Float duration
            ,java.sql.Date date, String city) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.duration = duration;
        this.date = date;
        this.city = city;
    }
    public Tour(String name,Float price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }
    public String getDescription() {
        return description;
    }
    public String getGuide() {
        return guide;
    }
    public String getGuideMail() {
        return guideMail;
    }
    public void setGuideGuideMail(String guide, String guideMail) {
        this.guide = guide;
        this.guideMail = guideMail;
    }
    public float getPrice() {
        return price;
    }
    public float getDuration() {
        return duration;
    }
    public java.sql.Date getDate() {
        return date;
    }
    public  List<Time> getTimes() {
        return times;
    }
    public String getCity() { return city; }
    public void setTourName(String tourName) { this.name = tourName; }
    public void addTimes(java.sql.Time time){
        this.times.add(time);
    }
}