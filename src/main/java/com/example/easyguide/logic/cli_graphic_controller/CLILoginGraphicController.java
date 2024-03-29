package com.example.easyguide.logic.cli_graphic_controller;

import com.example.easyguide.logic.beans.CredentialsBean;
import com.example.easyguide.logic.controller.LoginController;
import com.example.easyguide.logic.exceptions.DAOException;
import com.example.easyguide.logic.exceptions.InvalidFormatException;
import com.example.easyguide.logic.utilities.CLIPrinter;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLException;
import java.util.logging.Level;


public class CLILoginGraphicController extends AbstractCLIGraphicController{
    public void start(){
        boolean a = true;
        while (a){
            int choice;
            try{
                choice = showMenu();
                switch (choice){
                    case 1 -> {
                        a = false;
                        login();
                    }
                    case 2 -> {
                        a = false;
                        new CLISignUpGraphicController().start();
                    }

                    case 3 -> {
                        a = false;
                        System.exit(0);
                    }
                    default -> throw new InvalidFormatException("invalid choice");
                }
            } catch (InvalidFormatException e){
                logger.log(Level.INFO, e.getMessage());
            }
        }
    }

    public int showMenu() {
        CLIPrinter.printMessage("What do you want to do?\n");
        CLIPrinter.printMessage("1) Login\n");
        CLIPrinter.printMessage("2) Sign Up\n");
        CLIPrinter.printMessage("3) Quit\n");

        return getMenuChoice(1, 3);
    }

    private void login() {
        LoginController loginController = new LoginController();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try {
            CLIPrinter.printMessage("username: ");
            String username = reader.readLine();
            CLIPrinter.printMessage("password: ");
            String password = reader.readLine();
            CredentialsBean bean = new CredentialsBean(username, password);
            loginController.login(bean);

            new CLIHomeGraphicController().start();
        } catch (InvalidFormatException | DAOException | IOException | SQLException e) {
            logger.log(Level.INFO, e.getMessage());
            start();
        }
    }
}
