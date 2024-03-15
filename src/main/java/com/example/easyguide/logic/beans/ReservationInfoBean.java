package com.example.easyguide.logic.beans;

public class ReservationInfoBean {
    private final String guideMail;
    private final String toutistMail;
    private  java.sql.Date date;
    private  java.sql.Time time;
    private  int people;
    private final String tourName;
    private final float price;

    public ReservationInfoBean(String guideMail, String touristMail, String tourName, float price){
        this.guideMail = guideMail;
        this.toutistMail = touristMail;
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


