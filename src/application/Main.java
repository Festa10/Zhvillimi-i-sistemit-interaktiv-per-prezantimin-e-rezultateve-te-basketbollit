package application;

import com.example.basketballsystem.database.DatabaseManager;
import com.example.basketballsystem.controller.MainController;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {
    
    @Override
    public void init() {
        // Initialize SQLite local database and load seed data
        DatabaseManager.initializeDatabase();
    }

    @Override
    public void start(Stage stage) {
        // Load the main view manager
        MainController mainRoot = new MainController();

        // Create the scene with main layout
        Scene scene = new Scene(mainRoot, 1100, 750);
        
        stage.setTitle("Sistemi Interaktiv i Basketbollit / Basketball Results System");
        stage.setScene(scene);
        stage.setMinWidth(950);
        stage.setMinHeight(600);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
