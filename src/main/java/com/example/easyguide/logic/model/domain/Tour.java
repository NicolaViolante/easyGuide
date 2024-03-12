package com.example.easyguide.logic.model.domain;

import java.io.File;
import java.sql.Time;
import java.util.Date;
import java.util.List;

public class Tour {
    private File photo;
    private final String name;
    private String description;
    private String guide;
    private String guideMail;
    private final Float price;
    private Float duration;
    private Date date;
    private List<Time> times;
    private String city;



    public Tour(File photo, String name, String description, String guide, String guideMail, Float price, Float duration
    ,Date date, List<Time> times, String city) {
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
    public Tour(String name,Float price) {
        this.name = name;
        this.price = price;
    }

    public File getPhoto() {
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
    public float duration() {
        return duration;
    }
    public Date getDate() {
        return date;
    }
    public  List<Time> getTimes() {
        return times;
    }
    public String getCity() { return city; }
}