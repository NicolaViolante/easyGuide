package com.example.easyguide.logic.utilities;

import java.io.IOException;

public class NavigatorCLI {
    private static NavigatorCLI navigator = null;
    private NavigatorCLI() {}
    public static NavigatorCLI getInstance(){
        if(navigator == null){
            navigator = new NavigatorCLI();
        }
        return navigator;
    }

    public void goTO(String CLIInterface) throws IOException{
        switch (CLIInterface){
            case ""
        }
    }
}
