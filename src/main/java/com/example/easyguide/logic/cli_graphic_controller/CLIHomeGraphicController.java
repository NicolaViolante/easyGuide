package com.example.easyguide.logic.cli_graphic_controller;

import com.example.easyguide.logic.controller.JoinTourController;
import com.example.easyguide.logic.controller.LoginController;
import com.example.easyguide.logic.exceptions.InvalidFormatException;
import com.example.easyguide.logic.utilities.CLIPrinter;

import java.io.IOException;
import java.util.logging.Level;

public class CLIHomeGraphicController extends AbstractCLIGraphicController {
    JoinTourController joinTourController;
    LoginController loginController;
    public CLIHomeGraphicController(){
        joinTourController = new JoinTourController();
    }

    @Override
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
                    default -> throw new InvalidFormatException("Invalid cgoice\n");
                }
            }
            catch (IOException | InvalidFormatException e){
                logger.log(Level.INFO, e.getMessage());
            }
        }
    }

    @Override
    public int showMenu() throws IOException {

        CLIPrinter.printMessage("What do you want to do?\n");
        CLIPrinter.printMessage("1) Chose a city\n");
        CLIPrinter.printMessage("2) View messages\n");
        CLIPrinter.printMessage("3) Logout\n");
        CLIPrinter.printMessage("4) Quit\n");

        return getMenuChoice(1,4);
    }
    private void specifyCity(){
        CLIPrinter.printMessage("da implementare\n");
    }
    private void viewMessages(){
        CLIPrinter.printMessage("da implementare\n");
    }
    private void logout(){
        new LoginController().logout();
        new CLILoginGraphicController().start();
    }
}
