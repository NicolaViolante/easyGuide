package com.example.easyguide.logic.cli_graphic_controller;

import com.example.easyguide.logic.controller.JoinTourController;
import com.example.easyguide.logic.utilities.CLIPrinter;

public class CLIPaymentGraphicController {
    public void pay()  {
        new JoinTourController().pay(); //dummy
        CLIPrinter.printMessage("You payed");
    }
}
