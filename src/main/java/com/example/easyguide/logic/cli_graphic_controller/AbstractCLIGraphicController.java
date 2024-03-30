package com.example.easyguide.logic.cli_graphic_controller;

import com.example.easyguide.logic.beans.ReservationInfoBean;
import com.example.easyguide.logic.controller.JoinTourController;
import com.example.easyguide.logic.controller.LoginController;
import com.example.easyguide.logic.session.SessionManager;
import com.example.easyguide.logic.utilities.CLIPrinter;

import java.util.List;
import java.util.Scanner;
import java.util.logging.Logger;

import static com.example.easyguide.logic.model.domain.Role.TOURIST;

public abstract class AbstractCLIGraphicController {
    Logger logger = Logger.getAnonymousLogger();

    protected int getMenuChoice(int min, int max) {
        Scanner input = new Scanner(System.in);
        int choice = 0;
        while (true) {
            CLIPrinter.printMessage("Please enter your choice: ");
            choice = input.nextInt();
            if (choice >= min && choice <= max) {
                break;
            }
            CLIPrinter.printMessage("Invalid option\n");
        }
        return choice;
    }
    protected void logout(){
        new LoginController().logout();
        new CLILoginGraphicController().start();
    }

    protected void goHome() {
        new CLIHomeGraphicController().start();
    }

    protected void viewMessages(){
        if (SessionManager.getInstance().getCurrentUser().getUserType() == TOURIST) {
            new JoinTourController().showMessages();
            new CLIMessagesGraphicController();
        } else {
            CLIPrinter.printNumbers(1);
            CLIPrinter.printMessage("Show messages\n");
            CLIPrinter.printNumbers(2);
            CLIPrinter.printMessage("Show requests\n");
            int choice = getMenuChoice(1, 2);
            if (choice == 1) {
                new JoinTourController().showMessages();
                new CLIMessagesGraphicController();
            } else if (choice == 2) {
                List<ReservationInfoBean> tourInfo = new JoinTourController().showRequests();
                new CLIRequestsGraphicController().start(tourInfo);
            }
        }

    }
}
