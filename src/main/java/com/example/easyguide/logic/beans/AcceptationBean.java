package com.example.easyguide.logic.beans;

public class AcceptationBean {
    private final int state;
    private final String guideMail;
    private final String touristMail;
    private final java.sql.Date date;
    private final java.sql.Time time;

    public AcceptationBean(int state, String guideMail, String touristMail, java.sql.Date date, java.sql.Time time){
        this.state = state;
        this.guideMail = guideMail;
        this.date = date;
        this.touristMail = touristMail;
        this.time = time;
    }

    public int getState() { return state; }
    public String getGuideMail() { return guideMail; }
    public String getTouristMail() { return touristMail; }
    public java.sql.Date getDate() { return date; }
    public java.sql.Time getTime() { return time; }
}
