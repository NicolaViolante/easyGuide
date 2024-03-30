package com.example.easyguide.logic.cli_graphic_controller;

import com.example.easyguide.logic.exceptions.InvalidFormatException;
import com.example.easyguide.logic.session.SessionManager;
import com.example.easyguide.logic.utilities.CLIPrinter;

import java.util.logging.Level;

public class CLIViewProfile extends AbstractCLIGraphicController {
    public void start() {
        boolean select = true;
        while (select) {
            int choice;
            try{
                choice = showMenu();
                switch (choice){
                    case 1 -> {select = false;
                        goBack();}
                    case 2 -> {select = false;
                        goHome();}
                    case 3 -> {select = false;
                        viewMessages();}
                    case 4 -> {select = false;
                        logout();}
                    case 5 -> {select = false;
                        viewProfileInfo();}
                    case 6 -> {select = false;
                        System.exit(0);}
                    default -> throw new InvalidFormatException("Invalid choice\n");
                }
            }
            catch (InvalidFormatException e){
                logger.log(Level.INFO, e.getMessage());
            }
        }
    }
    public int showMenu() {

        CLIPrinter.printMessage("What do you want to do?\n");
        CLIPrinter.printMessage("1) Go back\n");
        CLIPrinter.printMessage("2) Go home\n");
        CLIPrinter.printMessage("3) View messages\n");
        CLIPrinter.printMessage("4) Logout\n");
        CLIPrinter.printMessage("5) View profile info\n");
        CLIPrinter.printMessage("6) Quit\n");

        return getMenuChoice(1,6);
    }

    private void goBack(){
        new CLIHomeGraphicController().start();
    }

    private void viewProfileInfo(){
        CLIPrinter.printMessage("Name: ");
        CLIPrinter.printMessage(SessionManager.getInstance().getCurrentUser().getName());
        CLIPrinter.newLine();
        CLIPrinter.printMessage("Surname: ");
        CLIPrinter.printMessage(SessionManager.getInstance().getCurrentUser().getSurname());
        CLIPrinter.newLine();
        CLIPrinter.printMessage("Mail: ");
        CLIPrinter.printMessage(SessionManager.getInstance().getCurrentUser().getEmail());
        CLIPrinter.newLine();
        CLIPrinter.printMessage("Username: ");
        CLIPrinter.printMessage(SessionManager.getInstance().getCurrentUser().getUsername());
        CLIPrinter.newLine();
        CLIPrinter.printMessage("Role: ");
        CLIPrinter.printMessage(SessionManager.getInstance().getCurrentUser().getUserType().getId());
        CLIPrinter.newLine();
        CLIPrinter.printMessage("-------------------");
        CLIPrinter.newLine();
        start();
    }
}
