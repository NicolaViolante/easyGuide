package com.example.easyguide.logic.cli_graphic_controller;

import com.example.easyguide.logic.utilities.CLIPrinter;

import java.util.Scanner;
import java.util.logging.Logger;
public abstract class AbstractCLIGraphicController implements CLIGraphicControllerInterface {
    Logger logger = Logger.getAnonymousLogger();

    protected int getMenuChoice(int min, int max){
        Scanner input = new Scanner(System.in);
        int choice = 0;
        while (true){
            CLIPrinter.printMessage("Please enter your choice: ");
            choice = input.nextInt();
            if (choice >= min && choice <= max){
                break;
            }
            CLIPrinter.printMessage("Invalid option\n");
        }
        return choice;
    }
}
