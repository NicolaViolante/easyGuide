package com.example.easyguide.logic.cli_graphic_controller;

import com.example.easyguide.logic.beans.RequestSearchBean;
import com.example.easyguide.logic.beans.TourBean;
import com.example.easyguide.logic.beans.TourSearchBean;
import com.example.easyguide.logic.controller.JoinTourController;
import com.example.easyguide.logic.controller.LoginController;
import com.example.easyguide.logic.exceptions.InvalidFormatException;
import com.example.easyguide.logic.model.domain.Role;
import com.example.easyguide.logic.session.SessionManager;
import com.example.easyguide.logic.utilities.CLIPrinter;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.logging.Level;

import static com.example.easyguide.logic.model.domain.Role.TOURIST;

public class CLIHomeGraphicController extends AbstractCLIGraphicController {
    JoinTourController joinTourController;
    public CLIHomeGraphicController(){
        joinTourController = new JoinTourController();
    }


    public void start() {
        while (true) {
            int choice;
            try{
                choice = showMenu();
                switch (choice){
                    case 1 -> specifyCity();
                    case 2 -> viewMessages();
                    case 3 -> logout();
                    case 4 -> System.exit(0);
                    default -> throw new InvalidFormatException("Invalid choice\n");
                }
            }
            catch (IOException | InvalidFormatException e){
                logger.log(Level.INFO, e.getMessage());
            }
        }
    }

    public int showMenu() throws IOException {

        CLIPrinter.printMessage("What do you want to do?\n");
        CLIPrinter.printMessage("1) Chose a city\n");
        CLIPrinter.printMessage("2) View messages\n");
        CLIPrinter.printMessage("3) Logout\n");
        CLIPrinter.printMessage("4) Quit\n");

        return getMenuChoice(1,4);
    }
    private void specifyCity() {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try {
            CLIPrinter.printMessage("Which city do you want to visit(Italian name)? ");
            String city = reader.readLine();
            TourSearchBean bean = new TourSearchBean(city);
            List<TourBean> listOfTours = joinTourController.findTourOfCity(bean);
            new CLISelectTourGraphicController().start(listOfTours);
        }
        catch(Exception e){
            logger.log(Level.INFO, e.getMessage());
        }
    }

    private void logout(){
        new LoginController().logout();
        new CLILoginGraphicController().start();
    }
}
