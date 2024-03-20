package com.example.easyguide.logic.beans;


public class ReservationInfoBean {
    private String guideMail;
    private String toutistMail;
    private  java.sql.Date date;
    private  java.sql.Time time;
    private  int people;
    private String tourName;
    private float price;

    public ReservationInfoBean(String guideMail, String touristMail, String tourName, float price){
        this.guideMail = guideMail;
        this.toutistMail = touristMail;
        this.tourName = tourName;
        this.price = price;
    }

    public ReservationInfoBean(String guideMail, String toutistMail, java.sql.Date date, java.sql.Time time, int people,
    String tourName, float price){
        this.guideMail = guideMail;
        this.toutistMail = toutistMail;
        this.date = date;
        this.time = time;
        this.people = people;
        this.tourName = tourName;
        this.price = price;
    }

    public void setDate(java.sql.Date date) { this.date = date; }
    public void setTime(java.sql.Time time) { this.time = time; }
    public void setPeople(int people) { this.people = people; }

    public String getGuideMail() { return guideMail; }
    public String getTouristMail() { return toutistMail; }
    public java.sql.Date getDate() { return date; }
    public java.sql.Time getTime() { return time; }
    public int getPeople() { return people; }
    public String getTourName() { return tourName; }
    public float getPrice() { return price; }

}


