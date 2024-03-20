package com.example.easyguide.logic.beans;

import java.sql.Time;
import java.util.List;

public class SpecifiedTourBean {
    private final String photo;
    private final String tourName;
    private final String description;
    private final String guide;
    private final float price;
    private final float duration;
    private  java.sql.Date date;
    private  List<java.sql.Time> times;
    private final String guideMail;
    private  String city;

    public SpecifiedTourBean(String photo, String tourName, String description, String guide,String guideMail, float price, float duration) {
        this.photo = photo;
        this.tourName = tourName;
        this.description = description;
        this.guide = guide;
        this.price = price;
        this.duration = duration;
        this.guideMail = guideMail;
    }

    public String getPhoto() { return photo; }
    public String getTourName() { return tourName; }
    public String getDescription() { return description; }
    public String getGuide() { return guide; }
    public float getPrice() { return price; }
    public float getDuration() { return duration; }
    public java.sql.Date getDate() { return date; }
    public List<Time> getTimes() { return times; }
    public String getGuideMail() {return guideMail; }
    public String getCity(){ return city; }
    public void setDateTimesCity(java.sql.Date date, List<java.sql.Time> times, String city ) {this.date = date; this.times = times;
    this.city = city;}

}
