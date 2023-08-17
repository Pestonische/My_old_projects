package com.example.lab4;

import com.example.lab4.view.Gui;
import javafx.application.Application;
import javafx.stage.Stage;

import java.io.IOException;

public class RasterApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        new Gui().start(stage);
    }

    public static void main(String[] args) {
        launch();
    }
}