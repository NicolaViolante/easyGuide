package com.example.easyguide.logic.cli_graphic_controller;

import com.example.easyguide.logic.beans.RequestsInfoBean;
import com.example.easyguide.logic.exceptions.InvalidFormatException;
import com.example.easyguide.logic.utilities.CLIPrinter;

import java.util.List;
import java.util.logging.Level;

public class CLIMessagesGraphicController extends AbstractCLIGraphicController {
    public void start(List<RequestsInfoBean> requestsInfoBeanList){
        boolean set = true;
        while(set){
            int choice;

            try{
                choice = showMenu(requestsInfoBeanList);

                switch (choice)
                {

                    case 1 -> {
                        set = false;
                        goHome();
                    }
                    case 2 -> {
                        set = false;
                        logout();
                    }
                    case 3 -> {
                        set = false;
                        System.exit(0);
                    }
                    default -> throw new InvalidFormatException("Invalid choice");
                }
            } catch (InvalidFormatException e) {
                logger.log(Level.INFO, e.getMessage());
            }
        }
    }

    public int showMenu(List<RequestsInfoBean> requestsInfoBeanList) {

        for (RequestsInfoBean reservation : requestsInfoBeanList){
            CLIPrinter.printRequest(reservation.getTourName(),
                    reservation.getPrice(),
                    reservation.getDate(),
                    reservation.getTime(),
                    reservation.getPeople(),
                    reservation.getGuideMail(),
                    reservation.getStatus());
        }
        CLIPrinter.printMessage("------------\n");
        CLIPrinter.printNumbers(1);
        CLIPrinter.printMessage("Go home\n");
        CLIPrinter.printNumbers(2);
        CLIPrinter.printMessage("Logout\n");
        CLIPrinter.printNumbers(3);
        CLIPrinter.printMessage("Quit\n");

        return getMenuChoice(1,3);
    }
}
