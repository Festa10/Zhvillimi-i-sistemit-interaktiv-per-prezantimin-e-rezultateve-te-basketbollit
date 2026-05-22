package com.example.basketballsystem.dashboard;

public class StatsService {

        public static int totalMatches(int wins, int losses) {
            return wins + losses;
        }

        public static double winRate(int wins, int matches) {
            if (matches == 0) return 0;
            return (wins * 100.0) / matches;
        }

        public static double averagePoints(int totalPoints, int matches) {
            if (matches == 0) return 0;
            return (double) totalPoints / matches;
        }
}