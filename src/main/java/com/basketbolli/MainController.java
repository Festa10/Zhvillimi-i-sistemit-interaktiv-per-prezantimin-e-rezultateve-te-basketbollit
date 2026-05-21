package com.basketbolli;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class MainController {

    
    @FXML
    private void handleDashboard() {
        System.out.println("Duke hapur Dashboard-in e Analitikës AI...");
      
    }

    @FXML
    private void handleLanguageAlbanian() {
        showInfo("Lokalizimi", "Sistemi tani është në gjuhën Shqipe.");
    }

    @FXML
    private void handleLanguageEnglish() {
        showInfo("Localization", "System language set to English.");
    }

    @FXML
    private void handleHelp() {
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle("Ndihmë / Help");
        alert.setHeaderText("Sistemi i Analitikës së Basketbollit v1.0");
        alert.setContentText("Ky aplikacion përdor BI dhe AI për të parashikuar rezultatet e ndeshjeve.\n\nShortcuts:\nCtrl+S: Ruaj\nCtrl+Q: Dil");
        alert.showAndWait();
    }

 
    private void showInfo(String titulli, String mesazhi) {
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle(titulli);
        alert.setHeaderText(null);
        alert.setContentText(mesazhi);
        alert.showAndWait();
    }

    @FXML
    private void handleExit() {
        System.exit(0);
    }
}
