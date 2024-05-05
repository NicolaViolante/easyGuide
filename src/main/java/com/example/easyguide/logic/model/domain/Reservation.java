package com.example.easyguide.logic.model.domain;

import com.example.easyguide.logic.exceptions.EmailSenderException;
import com.example.easyguide.logic.pattern.Subject;
import com.example.easyguide.logic.utilities.EmailSenderBoundary;

public class Reservation extends Subject {
    private String guideMail;
    private String touristMail;
    private int people;
    private final java.sql.Time time;
    private final java.sql.Date date;
    private Float price;
    private final String tourName;
    private Status state = Status.OPEN;

    public Reservation( String touristMail, int people, java.sql.Time time, java.sql.Date date,
                       Float price, String tourName)  {
        this.date = date;
        this.price = price;
        this.people = people;
        this.touristMail = touristMail;
        this.tourName = tourName;
        this.time = time;

    }
    public Reservation( String guideMail, int people, java.sql.Time time, java.sql.Date date,
                        Float price, String tourName, Status state)  {
        this.date = date;
        this.price = price;
        this.people = people;
        this.guideMail = guideMail;
        this.tourName = tourName;
        this.time = time;
        this.state = state;

    }
    public Reservation( String guideMail, String touristMail, int people, java.sql.Time time, java.sql.Date date,
                        Float price, String tourName)  {
        this.date = date;
        this.price = price;
        this.people = people;
        this.touristMail = touristMail;
        this.tourName = tourName;
        this.time = time;
        this.guideMail = guideMail;

    }
    public Reservation(Status state, String guideMail, String touristMail, java.sql.Date date, java.sql.Time time, String tourName) throws EmailSenderException{
        this.state = state;
        this.guideMail = guideMail;
        this.date = date;
        this.touristMail = touristMail;
        this.time = time;
        this.tourName = tourName;

        EmailSenderBoundary emailSender = new EmailSenderBoundary(this);

        this.attach(emailSender);
    }

    public String getGuideMail() { return guideMail;}
    public String getTouristMail(){ return touristMail; }
    public int getPeople(){ return people; }
    public void setPeople(int people) { this.people = people; }
    public java.sql.Time getTime(){ return time; }
    public java.sql.Date getDate(){ return date; }
    public Float getPrice(){ return price; }
    public void setPrice(float price){ this.price = price; }
    public String getTourName(){ return tourName; }
    public Status getState(){ return state; }
    public void notifyReservation(){
        super.notifyObservers();
    }
}
