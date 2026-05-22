package com.example.basketballsystem.dashboard;

public class BIService {

        public static String compareTeams(int winsA, int winsB) {

            if (winsA > winsB) {
                return "Team A has better performance";
            } else if (winsB > winsA) {
                return "Team B has better performance";
            } else {
                return "Teams are equal";
            }
        }

        public static String performanceLevel(double avgPoints) {

            if (avgPoints >= 100) return "High Performance";
            if (avgPoints >= 70) return "Medium Performance";
            return "Low Performance";
        }
}