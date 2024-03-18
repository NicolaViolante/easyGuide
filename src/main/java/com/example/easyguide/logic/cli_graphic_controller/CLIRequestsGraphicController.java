package com.example.easyguide.logic.cli_graphic_controller;

import com.example.easyguide.logic.beans.AcceptationBean;
import com.example.easyguide.logic.beans.ReservationInfoBean;
import com.example.easyguide.logic.controller.JoinTourController;
import com.example.easyguide.logic.exceptions.InvalidFormatException;
import com.example.easyguide.logic.utilities.CLIPrinter;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;

public class CLIRequestsGraphicController extends AbstractCLIGraphicController{
    public void start(List<ReservationInfoBean> reservationInfoBeanList){
        while(true){
            int choice;
            int i = reservationInfoBeanList.size();
            int reservation = -1;
            try{
                choice = showMenu(reservationInfoBeanList);
                if (choice <= i){
                    reservation = choice-1;
                    choice = 1;}
                else{
                    choice -= i-1;
                }
                switch (choice)
                {
                    case 1 -> acceptOrDecline(reservationInfoBeanList.get(reservation), reservation,  reservationInfoBeanList);
                    case 2 -> goHome();
                    case 3 -> logout();
                    case 4 -> System.exit(0);
                    default -> throw new InvalidFormatException("Invalid choice");
                }
            } catch (IOException | InvalidFormatException e) {
                logger.log(Level.INFO, e.getMessage());
            }
        }
    }

    public int showMenu(List<ReservationInfoBean> reservationInfoBeanList) throws IOException {

        int i = 1;
        CLIPrinter.printMessage("Select a tour: \n");
        for (ReservationInfoBean reservation : reservationInfoBeanList){
            CLIPrinter.printReservation(i , reservation.getTourName(), reservation.getPrice(), reservation.getDate(),
                    reservation.getTime(), reservation.getPeople(), reservation.getTouristMail());
            i++;
        }
        CLIPrinter.printMessage("-----------\n");
        CLIPrinter.printNumbers(i); CLIPrinter.printMessage("Go home\n");
        CLIPrinter.printNumbers(i+1); CLIPrinter.printMessage("Logout\n");
        CLIPrinter.printNumbers(i+2); CLIPrinter.printMessage("Quit\n");

        return getMenuChoice(1,i+2);
    }

    private void acceptOrDecline(ReservationInfoBean reservationInfoBean, int i, List<ReservationInfoBean> reservationInfoBeanList){
        CLIPrinter.printMessage("1 to accept, 2 to decline\n");
        AcceptationBean acceptationBean = null;
        int choice = getMenuChoice(1,2);
        if (choice == 1)  acceptationBean = new AcceptationBean(1, reservationInfoBean.getGuideMail(),
                reservationInfoBean.getTouristMail(), reservationInfoBean.getDate(), reservationInfoBean.getTime());
        else if (choice == 2)  acceptationBean = new AcceptationBean(2, reservationInfoBean.getGuideMail(),
                reservationInfoBean.getTouristMail(), reservationInfoBean.getDate(), reservationInfoBean.getTime());
        new JoinTourController().changeStatus(acceptationBean);
        reservationInfoBeanList.remove(i);
        start(reservationInfoBeanList);
    }
}
