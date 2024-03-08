package com.example.easyguide.logic.cli_graphic_controller;

import com.example.easyguide.logic.utilities.CLIPrinter;

import java.io.IOException;

public class CLIHomeGraphicController extends AbstractCLIGraphicController {

    @Override
    public void start(){
        System.exit(0);
    }

    @Override
    public int showMenu() throws IOException {
        return 0;
    }
}
