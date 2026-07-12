package com.bandforge;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class BandForgeApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(
                BandForgeApplication.class.getResource("/com/bandforge/fxml/WelcomeView.fxml"));

        Scene scene = new Scene(fxmlLoader.load(), 320, 240);

        stage.setTitle("BandForge");
        stage.setScene(scene);
        stage.show();
    }
}
