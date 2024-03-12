package com.example.easyguide.logic.cli_graphic_controller;

import com.example.easyguide.logic.beans.SignUpBean;
import com.example.easyguide.logic.controller.SignUpController;
import com.example.easyguide.logic.exceptions.InvalidFormatException;
import com.example.easyguide.logic.model.domain.Role;
import com.example.easyguide.logic.utilities.CLIPrinter;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.logging.Level;

public class CLISignUpGraphicController extends AbstractCLIGraphicController{

    public void start(){
        while(true){
            int choice;
            try{
                choice = showMenu();
                switch (choice){
                    case 1 -> signUp();
                    case 2 -> new CLILoginGraphicController().start();
                    case 3 -> System.exit(0);
                    default -> throw new InvalidFormatException("Invalid choice");
                }
            } catch (IOException | InvalidFormatException e) {
                logger.log(Level.INFO, e.getMessage());
            }
        }
    }

    @Override
    public int showMenu() throws IOException {
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

            else throw new InvalidFormatException("Invalid role");

            SignUpBean bean = new SignUpBean(username,name,surname,email,password,role.getId());
            signUpController.signUp(bean);
            new CLIHomeGraphicController().start();

        } catch (Exception e) {
            logger.log(Level.INFO, e.getMessage());
        }
    }
}
