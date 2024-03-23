package com.example.easyguide;

import com.example.easyguide.logic.graphic_controller.LoginGraphicController;
import com.example.easyguide.logic.utilities.NavigatorSingleton;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;

public class Main extends Application {
    @Override
    public void start(Stage primaryStage) throws IOException {

        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("login.fxml"));
        Scene scene = new Scene(fxmlLoader.load());

        NavigatorSingleton n = NavigatorSingleton.getInstance(primaryStage);

        n.getStg().setTitle("EasyGuide");
        n.getStg().setResizable(false);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}