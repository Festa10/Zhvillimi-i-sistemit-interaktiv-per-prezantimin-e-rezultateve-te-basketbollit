module com.example.basketballsystem {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.basketballsystem to javafx.fxml;
    exports com.example.basketballsystem;
}