package com.example.easyguide.logic.cli_graphic_controller;

import com.example.easyguide.logic.beans.SignUpBean;
import com.example.easyguide.logic.controller.SignUpController;
import com.example.easyguide.logic.exceptions.InvalidFormatException;
import com.example.easyguide.logic.exceptions.InvalidRoleException;
import com.example.easyguide.logic.model.domain.Role;
import com.example.easyguide.logic.utilities.CLIPrinter;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLException;
import java.util.logging.Level;

public class CLISignUpGraphicController extends AbstractCLIGraphicController{

    public void start(){
        boolean bool = true;
        while(bool){
            int choice;
            try{
                choice = showMenu();
                switch (choice){
                    case 1 -> {
                        bool = false;
                        signUp();
                    }
                    case 2 -> {
                        bool = false;
                        new CLILoginGraphicController().start();
                    }
                    case 3 -> {
                        bool = false;
                        System.exit(0);
                    }
                    default -> throw new InvalidFormatException("Invalid choice");
                }
            } catch (InvalidFormatException e) {
                logger.log(Level.INFO, e.getMessage());
            }
        }
    }

    public int showMenu() {
        CLIPrinter.printMessage("What do you want to do?\n");
        CLIPrinter.printMessage("1) SignUp\n");
        CLIPrinter.printMessage("2) Login\n");
        CLIPrinter.printMessage("3) Quit\n");

        return getMenuChoice(1,3);
    }

    private void signUp(){
        SignUpController signUpController = new SignUpController();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try{
            CLIPrinter.printMessage("name: ");
            String name = reader.readLine();
            CLIPrinter.printMessage("surname: ");
            String surname = reader.readLine();
            CLIPrinter.printMessage("username: ");
            String username = reader.readLine();
            CLIPrinter.printMessage("email: ");
            String email = reader.readLine();
            CLIPrinter.printMessage("password: ");
            String password = reader.readLine();
            CLIPrinter.printMessage("role (1 for tourist, 2 for guide): ");
            String role1 = reader.readLine();
            Role role;

            if(role1.equals("1")) role = Role.TOURIST;

            else if (role1.equals("2")) role = Role.GUIDE;

            else throw new InvalidRoleException("Invalid role");

            SignUpBean bean = new SignUpBean(
                    username,
                    name,
                    surname,
                    email,
                    password,
                    role.getId()
            );

            int result = signUpController.signUp(bean);
            switch (result){
                case 1 -> new CLIHomeGraphicController().start();

                case -1 -> logger.log(Level.INFO,"Username already in use");

                default -> logger.log(Level.INFO,"Unknown error");
            }


        } catch (SQLException | IOException | InvalidRoleException | InvalidFormatException e) {
            logger.log(Level.INFO, e.getMessage());
            start();
        }
    }
}
