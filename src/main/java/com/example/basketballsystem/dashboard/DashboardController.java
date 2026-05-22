package com.example.basketballsystem.dashboard;

import javafx.fxml.FXML;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.PieChart;
import javafx.scene.chart.XYChart;

public class DashboardController {

    @FXML
    private PieChart pieChart;

    @FXML
    private BarChart<String, Number> barChart;

    @FXML
    private LineChart<String, Number> lineChart;

    @FXML
    public void initialize() {
        loadPieChart();
        loadBarChart();
        loadLineChart();
    }

    private void loadPieChart() {
        pieChart.getData().add(new PieChart.Data("Team A Wins", 12));
        pieChart.getData().add(new PieChart.Data("Team B Wins", 8));
    }

    private void loadBarChart() {
        XYChart.Series<String, Number> series = new XYChart.Series<>();
        series.setName("Points");

        series.getData().add(new XYChart.Data<>("Team A", 120));
        series.getData().add(new XYChart.Data<>("Team B", 95));
        series.getData().add(new XYChart.Data<>("Team C", 110));

        barChart.getData().add(series);
    }

    private void loadLineChart() {
        XYChart.Series<String, Number> series = new XYChart.Series<>();
        series.setName("Performance");

        series.getData().add(new XYChart.Data<>("Match 1", 20));
        series.getData().add(new XYChart.Data<>("Match 2", 25));
        series.getData().add(new XYChart.Data<>("Match 3", 30));

        lineChart.getData().add(series);
    }
}