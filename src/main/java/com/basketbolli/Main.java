package com.basketbolli;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.util.Locale;
import java.util.ResourceBundle;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
       
        Locale locale = new Locale("sq");
        ResourceBundle bundle = ResourceBundle.getBundle("strings", locale);

        
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/MainView.fxml"), bundle);
        Parent root = loader.load();

        primaryStage.setTitle("HoopsStat - Basketball Analytics System");
        
        Scene scene = new Scene(root, 1200, 800);
        
        scene.getStylesheets().add(getClass().getResource("/css/style.css").toExternalForm());
        
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
