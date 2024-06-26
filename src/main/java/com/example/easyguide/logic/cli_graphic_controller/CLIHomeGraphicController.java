package com.example.easyguide.logic.cli_graphic_controller;


import com.example.easyguide.logic.beans.TourBean;
import com.example.easyguide.logic.beans.TourSearchBean;
import com.example.easyguide.logic.controller.JoinTourController;
import com.example.easyguide.logic.exceptions.InvalidFormatException;
import com.example.easyguide.logic.utilities.CLIPrinter;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;
import java.util.logging.Level;

public class CLIHomeGraphicController extends AbstractCLIGraphicController {
    JoinTourController joinTourController;
    public CLIHomeGraphicController(){
        joinTourController = new JoinTourController();
    }


    public void start() {
        boolean choose = true;
        while (choose) {
            int choice;
            try{
                choice = showMenu();
                switch (choice){
                    case 1 -> {choose = false;
                                specifyCity();}
                    case 2 -> {choose = false;
                                viewMessages();}
                    case 3 -> {choose = false;
                                logout();}
                    case 4 -> {choose = false;
                                viewProfile();}
                    case 5 -> {choose = false;
                                System.exit(0);}
                    default -> throw new InvalidFormatException("Invalid choice\n");
                }
            }
            catch (InvalidFormatException e){
                logger.log(Level.INFO, e.getMessage());

            }
        }
    }

    private int showMenu() {

        CLIPrinter.printMessage("What do you want to do?\n");
        CLIPrinter.printMessage("1) Chose a city\n");
        CLIPrinter.printMessage("2) View messages\n");
        CLIPrinter.printMessage("3) Logout\n");
        CLIPrinter.printMessage("4) View profile\n");
        CLIPrinter.printMessage("5) Quit\n");

        return getMenuChoice(1,5);
    }
    private void specifyCity() {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try {
            CLIPrinter.printMessage("Which city do you want to visit(Italian name)? ");
            String city = reader.readLine();
            TourSearchBean bean = new TourSearchBean(city);
            List<TourBean> listOfTours = joinTourController.findTourOfCity(bean);
            if(listOfTours.isEmpty()){
                CLIPrinter.printMessage("No tour found, choose another city");
                CLIPrinter.newLine();
                start();
            }
            new CLISelectTourGraphicController().start(listOfTours);
        }
        catch(Exception e){
            logger.log(Level.INFO, e.getMessage());
            start();
        }
    }

    private void viewProfile(){
        new CLIViewProfile().start();
    }


}
