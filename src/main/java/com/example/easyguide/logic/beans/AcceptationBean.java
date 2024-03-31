package com.example.easyguide.logic.beans;

import com.example.easyguide.logic.model.domain.Status;

public class AcceptationBean {
    private final Status state;
    private final String guideMail;
    private final String touristMail;
    private final java.sql.Date date;
    private final java.sql.Time time;
    private final String tourName;

    public AcceptationBean(Status state, String guideMail, String touristMail, java.sql.Date date, java.sql.Time time, String tourName){
        this.state = state;
        this.guideMail = guideMail;
        this.date = date;
        this.touristMail = touristMail;
        this.time = time;
        this.tourName = tourName;
    }

    public Status getState() { return state; }
    public String getGuideMail() { return guideMail; }
    public String getTouristMail() { return touristMail; }
    public java.sql.Date getDate() { return date; }
    public java.sql.Time getTime() { return time; }
    public  String  getTourName() { return tourName; }
}
