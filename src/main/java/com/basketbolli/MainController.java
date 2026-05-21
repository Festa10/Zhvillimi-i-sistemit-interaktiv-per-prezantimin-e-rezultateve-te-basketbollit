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
        updateUI();
    }

    @FXML
    private void setEnglish() {
        currentLocale = new Locale("en");
        updateUI();
    }

    private void updateUI() {
        loadLanguage();
        if (statusLabel != null) {
            statusLabel.setText(bundle.getString("status.ready"));
        }
        handleShowDashboard();
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

   
    @FXML
    private void handleExit() {
        System.exit(0);
    }

    private void loadView(String fxmlFile) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/" + fxmlFile + ".fxml"));
            loader.setResources(ResourceBundle.getBundle("strings", currentLocale));
            Parent view = loader.load();
            mainPane.setCenter(view);
        } catch (IOException e) {
            System.err.println("Gabim: Nuk u gjet skedari /view/" + fxmlFile + ".fxml");
            e.printStackTrace();
        }
    }
}
