package com.example.easyguide.logic.cli_graphic_controller;

import com.example.easyguide.logic.beans.SelectedTourBean;
import com.example.easyguide.logic.beans.SpecifiedTourBean;
import com.example.easyguide.logic.beans.TourBean;
import com.example.easyguide.logic.controller.JoinTourController;
import com.example.easyguide.logic.exceptions.InvalidFormatException;
import com.example.easyguide.logic.utilities.CLIPrinter;

import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;

public class CLISelectTourGraphicController extends AbstractCLIGraphicController{


    public void start(List<TourBean> tourBean){
        boolean loop = true;
        while(loop){
            int choice;
            int i = tourBean.size();
            int tour = -1;
            try{
                choice = showMenu(tourBean);
                if (choice <= i){
                    tour = choice-1;
                    choice = 1;}
                else{
                    choice -= i-1;
                }
                switch (choice)
                {
                    case 1 -> {
                        loop = false;
                        specifyTour(tourBean.get(tour).getTourName());
                    }
                    case 2 -> {
                        loop = false;
                        goHome();
                    }
                    case 3 -> {
                        loop = false;
                        goBack();
                    }
                    case 4 -> {
                        loop = false;
                        viewMessages();
                    }
                    case 5 -> {
                        loop = false;
                        logout();
                    }
                    case 6 -> {
                        loop = false;
                        System.exit(0);
                    }
                    default -> throw new InvalidFormatException("Invalid choice");
                }
            } catch (InvalidFormatException | SQLException e) {
                logger.log(Level.INFO, e.getMessage());
            }
        }
    }
    private int showMenu(List<TourBean> tours)  {

        int i = 1;
        CLIPrinter.printMessage("Select a tour: \n");
        for (TourBean tour : tours){
            CLIPrinter.printListOfAvailableTours(i , tour.getTourName(), tour.getPrice());
            i++;
        }
        CLIPrinter.printMessage("-----------\n");
        CLIPrinter.printNumbers(i); CLIPrinter.printMessage("Go home\n");
        CLIPrinter.printNumbers(i+1);
        CLIPrinter.printMessage("Go back\n");
        CLIPrinter.printNumbers(i+2);
        CLIPrinter.printMessage("ViewMessages\n");
        CLIPrinter.printNumbers(i+3);
        CLIPrinter.printMessage("Logout\n");
        CLIPrinter.printNumbers(i+4);
        CLIPrinter.printMessage("Quit\n");

        return getMenuChoice(1,i+4);
    }
    private void specifyTour(String tour) throws SQLException {
        SelectedTourBean selectedTourBean = new SelectedTourBean(tour);
        List<SpecifiedTourBean> details = new JoinTourController().showTour(selectedTourBean);
        new CLISelectedTourGraphicController().start(details);
    }
    private void goBack(){
        new CLIHomeGraphicController().start();
    }


}
