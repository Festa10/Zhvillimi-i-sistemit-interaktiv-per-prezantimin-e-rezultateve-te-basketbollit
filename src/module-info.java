module com.example.basketballsystem {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;

    opens com.example.basketballsystem to javafx.fxml;
    opens com.example.basketballsystem.controller to javafx.fxml;
    opens com.example.basketballsystem.model to javafx.base;
    opens application to javafx.graphics, javafx.fxml;

    exports com.example.basketballsystem;
    exports com.example.basketballsystem.model;
    exports com.example.basketballsystem.controller;
    exports com.example.basketballsystem.database;
    exports com.example.basketballsystem.service;
    exports application;
}
