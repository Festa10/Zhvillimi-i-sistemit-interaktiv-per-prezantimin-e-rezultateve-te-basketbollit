package com.basketbolli;

import javafx.fxml.FXML;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.XYChart;

public class DashboardController {

    @FXML private BarChart<String, Number> pointsChart;
    @FXML private LineChart<String, Number> aiChart;

    @FXML
    public void initialize() {
       
        XYChart.Series<String, Number> series1 = new XYChart.Series<>();
        series1.setName("Pikët për Ndeshje");
        series1.getData().add(new XYChart.Data<>("Ndeshja 1", 85));
        series1.getData().add(new XYChart.Data<>("Ndeshja 2", 92));
        series1.getData().add(new XYChart.Data<>("Ndeshja 3", 78));
        series1.getData().add(new XYChart.Data<>("Ndeshja 4", 95));
        pointsChart.getData().add(series1);

        
        XYChart.Series<String, Number> aiSeries = new XYChart.Series<>();
        aiSeries.setName("Probabiliteti i Fitores (%)");
        aiSeries.getData().add(new XYChart.Data<>("Jan", 50));
        aiSeries.getData().add(new XYChart.Data<>("Shk", 65));
        aiSeries.getData().add(new XYChart.Data<>("Mar", 70));
        aiSeries.getData().add(new XYChart.Data<>("Prill", 72));
        aiChart.getData().add(aiSeries);
    }
}
