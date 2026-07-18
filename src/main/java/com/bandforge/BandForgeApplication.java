package com.bandforge;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.web.WebView;
import javafx.stage.Stage;
import javafx.concurrent.Worker;
import java.io.File;

public class BandForgeApplication extends Application {
    @Override
    public void start(Stage stage) {
        WebView webView = new WebView();
        
        // Enable JavaScript and configure WebView
        webView.getEngine().setJavaScriptEnabled(true);
        
        // Add error listeners
        webView.getEngine().getLoadWorker().stateProperty().addListener((obs, oldState, newState) -> {
            System.out.println("Load worker state changed: " + newState);
            if (newState == Worker.State.FAILED) {
                System.err.println("Loading failed: " + webView.getEngine().getLoadWorker().getException());
            }
            if (newState == Worker.State.SUCCEEDED) {
                System.out.println("Loading succeeded");
            }
        });
        
        // Get the absolute path to the HTML file
        File htmlFile = new File("src/main/resources/web/index.html");
        String fileUrl = htmlFile.toURI().toString();
        
        System.out.println("Loading file: " + fileUrl);
        System.out.println("JavaScript enabled: " + webView.getEngine().isJavaScriptEnabled());
        
        // Load the HTML file using file:// protocol
        webView.getEngine().load(fileUrl);
        
        Scene scene = new Scene(webView, 1200, 800);
        
        stage.setTitle("BandForge");
        stage.setScene(scene);
        stage.show();
    }
}
