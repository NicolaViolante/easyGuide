package com.example.easyguide;

import com.example.easyguide.logic.cli_graphic_controller.CLILoginGraphicController;

public class CLIMain {

    public static void main(String[] args){
        CLILoginGraphicController applicationController = new CLILoginGraphicController();
        applicationController.start();
    }
}
