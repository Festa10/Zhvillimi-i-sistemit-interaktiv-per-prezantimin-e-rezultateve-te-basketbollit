package com.basketbolli;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.layout.BorderPane;
import java.io.IOException;

public class MainController {

    @FXML
    private BorderPane mainPane; 

    
    @FXML
    private void handleShowDashboard() {
        loadView("Dashboard");
    }

    
    @FXML
    private void handleShowHelp() {
        loadView("HelpView");
    }

    
    private void loadView(String fxmlFile) {
        try {
          
            Parent view = FXMLLoader.load(getClass().getResource("/view/" + fxmlFile + ".fxml"));
            mainPane.setCenter(view);
        } catch (IOException e) {
            System.err.println("Gabim gjatë ngarkimit të faqes: " + fxmlFile);
            e.printStackTrace();
        }
    }
    
 
}
