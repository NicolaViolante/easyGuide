package com.example.easyguide.logic.beans;

import java.io.File;
import java.sql.Time;
import java.util.Date;
import java.util.List;

public class SpecifiedTourBean {
    private final String photo;
    private final String tourName;
    private final String description;
    private final String guide;
    private final float price;
    private final float duration;
    private final Date date;
    private final List<Time> times;

    public SpecifiedTourBean(String photo, String tourName, String description, String guide, float price, float duration,
                             Date date, List<Time> times) {
        this.photo = photo;
        this.tourName = tourName;
        this.description = description;
        this.guide = guide;
        this.price = price;
        this.duration = duration;
        this.date = date;
        this.times = times;
    }

    public String getPhoto() { return photo; }
    public String getTourName() { return tourName; }
    public String getDescription() { return description; }
    public String getGuide() { return guide; }
    public float getPrice() { return price; }
    public float getDuration() { return duration; }
    public Date getDate() { return date; }
    public List<Time> getTimes() { return times; }

}
