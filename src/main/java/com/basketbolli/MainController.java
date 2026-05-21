package com.basketbolli;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.layout.BorderPane;
import javafx.scene.control.Label;
import java.io.IOException;
import java.util.Locale;
import java.util.ResourceBundle;

public class MainController {

    @FXML private BorderPane mainPane;
    @FXML private Label statusLabel;
    
    private ResourceBundle bundle;
    private Locale currentLocale = new Locale("sq"); 

    @FXML
    public void initialize() {
        loadLanguage();
        handleShowDashboard(); 
    }

    @FXML
    private void setAlbanian() {
        currentLocale = new Locale("sq");
        loadLanguage();
    }

    @FXML
    private void setEnglish() {
        currentLocale = new Locale("en");
        loadLanguage();
    }

    private void loadLanguage() {
        bundle = ResourceBundle.getBundle("strings", currentLocale);
        
    }

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
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/" + fxmlFile + ".fxml"));
            loader.setResources(ResourceBundle.getBundle("strings", currentLocale));
            Parent view = loader.load();
            mainPane.setCenter(view);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
