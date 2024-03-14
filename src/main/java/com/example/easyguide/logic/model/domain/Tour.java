package com.example.easyguide.logic.model.domain;

import java.sql.Time;
import java.util.ArrayList;
import java.util.List;

public class Tour {
    private String photo;
    private final String name;
    private String description;
    private String guide;
    private String guideMail;
    private final Float price;
    private Float duration;
    private java.sql.Date date;
    private List<java.sql.Time> times = new ArrayList<>();
    private String city;



    public Tour(String photo, String name, String description, String guide, String guideMail, Float price, Float duration
    ,java.sql.Date date, List<Time> times, String city) {
        this.photo = photo;
        this.name = name;
        this.description = description;
        this.guide = guide;
        this.guideMail = guideMail;
        this.price = price;
        this.duration = duration;
        this.date = date;
        this.times = times;
        this.city = city;
    }

    public Tour(String photo, String name, String description, String guide, String guideMail, Float price, Float duration
            ,java.sql.Date date) {
        this.photo = photo;
        this.name = name;
        this.description = description;
        this.guide = guide;
        this.guideMail = guideMail;
        this.price = price;
        this.duration = duration;
        this.date = date;
    }
    public Tour(String name,Float price) {
        this.name = name;
        this.price = price;
    }

    public String getPhoto() {
        return photo;
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
    public void addTimes(java.sql.Time time){
        this.times.add(time);
    }
}