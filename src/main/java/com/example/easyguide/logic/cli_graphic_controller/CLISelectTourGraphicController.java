package com.example.easyguide.logic.cli_graphic_controller;

import com.example.easyguide.logic.beans.TourBean;
import com.example.easyguide.logic.utilities.CLIPrinter;

import java.io.IOException;
import java.util.List;

public class CLISelectTourGraphicController extends AbstractCLIGraphicController{


    public void start(List<TourBean> tourBean) {
        int i = 1;
        for (TourBean tour : tourBean){
            System.out.printf("%s) Tour: %s, prezzo %s\n",i , tour.getTourName(), tour.getPrice());
            i++;
        }
        CLIPrinter.printMessage("programma terminatoo\n");
        System.exit(0);
    }



    @Override
    public int showMenu() throws IOException {
        return 0;
    }
}
