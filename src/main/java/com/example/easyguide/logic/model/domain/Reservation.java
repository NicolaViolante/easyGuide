package com.example.easyguide.logic.model.domain;

public class Reservation {
    private String guideMail;
    private final String touristMail;
    private final int people;
    private final java.sql.Time time;
    private final java.sql.Date date;
    private final Float price;
    private final String tourName;
    private int state = 0;

    public Reservation(String guideMail, String touristMail, int people, java.sql.Time time, java.sql.Date date,
                       Float price, String tourName){
        this.guideMail = guideMail;
        this.date = date;
        this.price = price;
        this.people = people;
        this.touristMail = touristMail;
        this.tourName = tourName;
        this.time = time;
    }

    public Reservation( String touristMail, int people, java.sql.Time time, java.sql.Date date,
                       Float price, String tourName){
        this.date = date;
        this.price = price;
        this.people = people;
        this.touristMail = touristMail;
        this.tourName = tourName;
        this.time = time;
    }

    public String getGuideMail(){ return guideMail; }
    public String getTouristMail(){ return touristMail; }
    public int getPeople(){ return people; }
    public java.sql.Time getTime(){ return time; }
    public java.sql.Date getDate(){ return date; }
    public Float getPrice(){ return price; }
    public String getTourName(){ return tourName; }
    public int getState(){ return state; }
}
