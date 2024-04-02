package com.example.easyguide.logic.beans;

import com.example.easyguide.logic.model.domain.Status;

public class RequestsInfoBean {
    private ReservationInfoBean reservationInfoBean;
    private Status status;
    public RequestsInfoBean(ReservationInfoBean reservationInfoBean, Status status){
        this.status = status;
        this.reservationInfoBean = reservationInfoBean;
    }
    public ReservationInfoBean getReservationInfoBean() { return reservationInfoBean; }
    public Status getStatus() { return status; }
}
