package com.example.easyguide.logic.cli_graphic_controller;

import com.example.easyguide.logic.beans.CredentialsBean;
import com.example.easyguide.logic.controller.LoginController;
import com.example.easyguide.logic.exceptions.InvalidFormatException;
import com.example.easyguide.logic.exceptions.SessionUserException;
import com.example.easyguide.logic.utilities.CLIPrinter;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.logging.Level;

import static com.example.easyguide.logic.utilities.CLIPrinter.printMessage;

public class CLILoginGraphicController extends AbstractCLIGraphicController{
    @Override
    public void start(){
        while (true){
            int choice;
            try{
                choice = showMenu();
                switch (choice){
                    case 1 -> login();
                   // case 2 -> new CLISignUpGraphicController.start();
                    case 3 -> System.exit(0);
                    default -> throw new InvalidFormatException("invalid choice");
                }
            } catch (IOException | InvalidFormatException e){
                logger.log(Level.INFO, e.getMessage());
            }
        }
    }
    @Override
    public int showMenu() throws IOException{
        CLIPrinter.printMessage("What do you want to do?\n");
        CLIPrinter.printMessage("1) Login\n");
        CLIPrinter.printMessage("2) Sign Up\n");
        CLIPrinter.printMessage("Quit\n");

        return getMenuChoice(1, 3);
    }

    private void login(){
        LoginController loginController = new LoginController();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try{
            CLIPrinter.printMessage("username: ");
            String username = reader.readLine();
            CLIPrinter.printMessage("password: ");
            String password = reader.readLine();
            CredentialsBean bean = new CredentialsBean(username,password);
            loginController.login(bean);
            new CLIHomeGraphicController().start();
        }
        catch (SessionUserException e){
            logger.log(Level.INFO, e.getMessage());
            new CLIHomeGraphicController().start();
        }
        catch (Exception e){
            logger.log(Level.INFO, e.getMessage());
        }
    }
}