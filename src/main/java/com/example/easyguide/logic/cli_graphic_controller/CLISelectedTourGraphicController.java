package com.example.easyguide.logic.cli_graphic_controller;

import com.example.easyguide.logic.beans.ReservationInfoBean;
import com.example.easyguide.logic.beans.SpecifiedTourBean;
import com.example.easyguide.logic.beans.TourBean;
import com.example.easyguide.logic.beans.TourSearchBean;
import com.example.easyguide.logic.controller.JoinTourController;
import com.example.easyguide.logic.exceptions.InvalidFormatException;
import com.example.easyguide.logic.exceptions.MissingDatesException;
import com.example.easyguide.logic.session.SessionManager;
import com.example.easyguide.logic.utilities.CLIPrinter;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;

public class CLISelectedTourGraphicController extends AbstractCLIGraphicController{
    public void start(List<SpecifiedTourBean> specifiedTourBeans){
        ReservationInfoBean reservationInfoBean = new ReservationInfoBean(specifiedTourBeans.getFirst().getGuideMail(),
                SessionManager.getInstance().getCurrentUser().getEmail(), specifiedTourBeans.getFirst().getTourName(),
                specifiedTourBeans.getFirst().getPrice());
        showOptions(specifiedTourBeans, reservationInfoBean);
    }

    private void sendReservation(ReservationInfoBean reservationInfoBean) throws MissingDatesException, SQLException {
        if (reservationInfoBean.getDate() == null || reservationInfoBean.getTime() == null || reservationInfoBean.getPeople() < 1){
            throw new MissingDatesException("Dates missing");
        }
        new CLIPaymentGraphicController().pay();
        new JoinTourController().completeReservation(reservationInfoBean);
        new CLIHomeGraphicController().start();

    }

    private void selectDateAndTime(List<SpecifiedTourBean> specifiedTourBeans, ReservationInfoBean reservationInfoBean) throws IOException {
        int i = 1;
        for (SpecifiedTourBean tour : specifiedTourBeans) {
            CLIPrinter.printListOfAvailableDates(i,tour.getDate());
            i++;
        }
        int choice = getMenuChoice(1,i-1);
        reservationInfoBean.setDate(specifiedTourBeans.get(choice-1).getDate());
        int j = 1;
        for (java.sql.Time time : specifiedTourBeans.get(choice-1).getTimes()){
            CLIPrinter.printListOfAvailableTimes(j,time);
            j++;
        }
        int choice2 = getMenuChoice(1,j-1);
        reservationInfoBean.setTime(specifiedTourBeans.get(choice-1).getTimes().get(choice2-1));
    }
    private void selectNumberOfPeople(List<SpecifiedTourBean> specifiedTourBeans, ReservationInfoBean reservationInfoBean) {
        Scanner input = new Scanner(System.in);
        int choice;
        CLIPrinter.printMessage("Select number of people: ");
        choice = input.nextInt();
        if (choice < 1)
        { CLIPrinter.printMessage("Invalid option\n");
            selectNumberOfPeople(specifiedTourBeans, reservationInfoBean);
        }
        reservationInfoBean.setPeople(choice);
        showOptions(specifiedTourBeans, reservationInfoBean);

    }



    private void goBack(List<SpecifiedTourBean> specifiedTourBeans) throws InvalidFormatException, SQLException {
        TourSearchBean bean = new TourSearchBean(specifiedTourBeans.getFirst().getCity());
        List<TourBean> listOfTours = new JoinTourController().findTourOfCity(bean);
        new CLISelectTourGraphicController().start(listOfTours);
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
                    case 2 -> selectNumberOfPeople(specifiedTourBeans, reservationInfoBean);
                    case 3 -> sendReservation(reservationInfoBean);
                    case 4 -> goHome();
                    case 5 -> goBack(specifiedTourBeans);
                    case 6 -> viewMessages();
                    case 7 -> logout();
                    case 8 -> System.exit(0);
                    default -> throw new InvalidFormatException("Invalid choice");
                }
            } catch (IOException | InvalidFormatException | MissingDatesException e) {
                logger.log(Level.INFO, e.getMessage());
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }

}
