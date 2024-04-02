package com.example.easyguide.logic.beans;

import com.example.easyguide.logic.model.domain.Status;

import java.sql.Date;
import java.sql.Time;

public class RequestsInfoBean {
    private ReservationInfoBean reservationInfoBean;
    private Status status;
    private String guideMail;
    private  java.sql.Date date;
    private  java.sql.Time time;
    private  int people;
    private String tourName;
    private float price;
    public RequestsInfoBean(ReservationInfoBean reservationInfoBean, Status status){
        this.status = status;
        this.date = reservationInfoBean.getDate();
        this.time = reservationInfoBean.getTime();
        this.people = reservationInfoBean.getPeople();
        this.guideMail = reservationInfoBean.getGuideMail();
        this.tourName = reservationInfoBean.getTourName();
        this.price = reservationInfoBean.getPrice();
    }

    public Status getStatus() { return status; }
    public int getPeople(){return people;}
    public String getGuideMail(){return guideMail;}
    public Date getDate(){return date;}
    public Time getTime(){return time;}
    public String getTourName(){return tourName;}
    public float getPrice(){return price;}
}
