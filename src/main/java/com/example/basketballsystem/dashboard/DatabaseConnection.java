package com.example.basketballsystem.dashboard;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {

    private static final String URL = "jdbc:sqlite:basketball.db";

    public static Connection connect() {
        try {
            Connection conn = DriverManager.getConnection(URL);
            System.out.println("Database connected successfully");
            return conn;
        } catch (SQLException e) {
            System.out.println("DB error: " + e.getMessage());
            return null;
        }
    }
}