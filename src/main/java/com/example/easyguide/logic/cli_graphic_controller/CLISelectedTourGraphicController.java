package com.example.easyguide.logic.cli_graphic_controller;

import com.example.easyguide.logic.beans.ReservationInfoBean;
import com.example.easyguide.logic.beans.SpecifiedTourBean;
import com.example.easyguide.logic.beans.TourBean;
import com.example.easyguide.logic.exceptions.InvalidFormatException;
import com.example.easyguide.logic.session.SessionManager;
import com.example.easyguide.logic.utilities.CLIPrinter;

import java.io.IOException;
import java.util.List;
import java.util.logging.Level;

public class CLISelectedTourGraphicController extends AbstractCLIGraphicController{
    public void start(List<SpecifiedTourBean> specifiedTourBeans){
        ReservationInfoBean reservationInfoBean = new ReservationInfoBean(specifiedTourBeans.getFirst().getGuideMail(),
                SessionManager.getInstance().getCurrentUser().getEmail(), specifiedTourBeans.getFirst().getTourName(),
                specifiedTourBeans.getFirst().getPrice());
        showOptions(specifiedTourBeans, reservationInfoBean);
    }

    private void sendReservation() {
    }

    private void selectDateAndTime(List<SpecifiedTourBean> specifiedTourBeans, ReservationInfoBean reservationInfoBean) {
        int i = 1;
        for (SpecifiedTourBean tour : specifiedTourBeans) {
            CLIPrinter.printListOfAvailableDates(i,tour.getDate());
            i++;
        }
        int choice = getMenuChoice(1,i-1);
        reservationInfoBean.setDate(specifiedTourBeans.get(choice-1).getDate());
    }
    private void selectNumberOfPeople() {
    }

    private void goHome() {
    }

    private void goBack() {
    }

    private void viewMessages() {
    }

    private void logout() {
    }

    public int showMenu() throws IOException {

        CLIPrinter.printMessage("What do you want to do?: \n");
        CLIPrinter.printMessage("1) Select date and time\n");
        CLIPrinter.printMessage("2) Select number of people\n");
        CLIPrinter.printMessage("3) Send reservation\n");
        CLIPrinter.printMessage("-----------\n");
        CLIPrinter.printMessage("4) Go home\n");
        CLIPrinter.printMessage("5) Go back\n");
        CLIPrinter.printMessage("6) ViewMessages\n");
        CLIPrinter.printMessage("7) Logout\n");
        CLIPrinter.printMessage("8) Quit\n");

        return getMenuChoice(1,8);
    }

    public void showOptions(List<SpecifiedTourBean> specifiedTourBeans, ReservationInfoBean reservationInfoBean) {
        while (true) {
            int choice;
            try {
                choice = showMenu();
                switch (choice) {
                    case 1 -> selectDateAndTime(specifiedTourBeans, reservationInfoBean);
                    case 2 -> selectNumberOfPeople();
                    case 3 -> sendReservation();
                    case 4 -> goHome();
                    case 5 -> goBack();
                    case 6 -> viewMessages();
                    case 7 -> logout();
                    case 8 -> System.exit(0);
                    default -> throw new InvalidFormatException("Invalid choice");
                }
            } catch (IOException | InvalidFormatException e) {
                logger.log(Level.INFO, e.getMessage());
            }
        }
    }

}
