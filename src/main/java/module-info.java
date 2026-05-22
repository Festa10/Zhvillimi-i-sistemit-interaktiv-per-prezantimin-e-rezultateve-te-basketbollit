module com.example.basketballsystem {

    requires javafx.controls;
    requires javafx.fxml;

    requires java.sql;

    opens com.example.basketballsystem to javafx.fxml;

    opens com.example.basketballsystem.dashboard to javafx.fxml;

    exports com.example.basketballsystem;
    exports com.example.basketballsystem.dashboard;
}