package com.example.basketballsystem.dashboard;

public class PredictionService {

        public static String predictWinner(int winsA, int winsB) {

            if (winsA > winsB) {
                return "Predicted Winner: Team A";
            } else if (winsB > winsA) {
                return "Predicted Winner: Team B";
            } else {
                return "Prediction: 50/50 match";
            }
        }
}