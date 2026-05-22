package controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import models.Match;

public class MatchController {

    // =========================
    // FORM COMPONENTS
    // =========================

    @FXML
    private ComboBox<String> homeTeamCombo;

    @FXML
    private ComboBox<String> awayTeamCombo;

    @FXML
    private TextField scoreField;

    @FXML
    private RadioButton ligaRadio;

    @FXML
    private RadioButton kupaRadio;

    @FXML
    private CheckBox finishedCheckBox;

    @FXML
    private TextField searchField;

    @FXML
    private ToggleGroup matchTypeGroup;

    // =========================
    // TABLE VIEW
    // =========================

    @FXML
    private TableView<Match> matchTable;

    @FXML
    private TableColumn<Match, String> homeColumn;

    @FXML
    private TableColumn<Match, String> awayColumn;

    @FXML
    private TableColumn<Match, String> scoreColumn;

    @FXML
    private TableColumn<Match, String> typeColumn;

    @FXML
    private TableColumn<Match, Boolean> finishedColumn;

    // Lista e ndeshjeve
    private ObservableList<Match> matchList =
            FXCollections.observableArrayList();

    // =========================
    // INITIALIZE
    // =========================

    @FXML
    public void initialize() {

        // ToggleGroup
        matchTypeGroup = new ToggleGroup();

        ligaRadio.setToggleGroup(matchTypeGroup);
        kupaRadio.setToggleGroup(matchTypeGroup);

        // Teams
        homeTeamCombo.getItems().addAll(
                "Peja",
                "Prishtina",
                "Trepça",
                "Bashkimi"
        );

        awayTeamCombo.getItems().addAll(
                "Peja",
                "Prishtina",
                "Trepça",
                "Bashkimi"
        );

        // Table Columns
        homeColumn.setCellValueFactory(
                new PropertyValueFactory<>("homeTeam")
        );

        awayColumn.setCellValueFactory(
                new PropertyValueFactory<>("awayTeam")
        );

        scoreColumn.setCellValueFactory(
                new PropertyValueFactory<>("score")
        );

        typeColumn.setCellValueFactory(
                new PropertyValueFactory<>("matchType")
        );

        finishedColumn.setCellValueFactory(
                new PropertyValueFactory<>("finished")
        );

        // Set data to table
        matchTable.setItems(matchList);

        // Klikimi në tabelë
        matchTable.setOnMouseClicked(event -> {

            Match selectedMatch =
                    matchTable.getSelectionModel().getSelectedItem();

            if (selectedMatch != null) {

                homeTeamCombo.setValue(selectedMatch.getHomeTeam());

                awayTeamCombo.setValue(selectedMatch.getAwayTeam());

                scoreField.setText(selectedMatch.getScore());

                if (selectedMatch.getMatchType().equals("Liga")) {
                    ligaRadio.setSelected(true);
                } else {
                    kupaRadio.setSelected(true);
                }

                finishedCheckBox.setSelected(
                        selectedMatch.isFinished()
                );
            }
        });
    }

    // =========================
    // ADD MATCH
    // =========================

    @FXML
    void saveMatch(ActionEvent event) {

        String homeTeam = homeTeamCombo.getValue();
        String awayTeam = awayTeamCombo.getValue();
        String score = scoreField.getText();

        // Validation
        if (homeTeam == null || awayTeam == null) {

            showAlert(
                    Alert.AlertType.ERROR,
                    "Gabim",
                    "Zgjidh të dy ekipet!"
            );

            return;
        }

        if (homeTeam.equals(awayTeam)) {

            showAlert(
                    Alert.AlertType.ERROR,
                    "Gabim",
                    "Ekipet duhet të jenë të ndryshme!"
            );

            return;
        }

        if (score == null || score.isEmpty()) {

            showAlert(
                    Alert.AlertType.ERROR,
                    "Gabim",
                    "Shkruaj rezultatin!"
            );

            return;
        }

        // Match Type
        String matchType =
                ligaRadio.isSelected() ? "Liga" :
                        kupaRadio.isSelected() ? "Kupa" :
                                "Nuk është zgjedhur";

        // Create Match Object
        Match match = new Match(
                homeTeam,
                awayTeam,
                score,
                matchType,
                finishedCheckBox.isSelected()
        );

        // Add to table
        matchList.add(match);

        showAlert(
                Alert.AlertType.INFORMATION,
                "Sukses",
                "Ndeshja u shtua me sukses!"
        );

        clearFields(null);
    }

    // =========================
    // EDIT MATCH
    // =========================

    @FXML
    void editMatch(ActionEvent event) {

        Match selectedMatch =
                matchTable.getSelectionModel().getSelectedItem();

        if (selectedMatch == null) {

            showAlert(
                    Alert.AlertType.ERROR,
                    "Gabim",
                    "Zgjidh një ndeshje!"
            );

            return;
        }

        selectedMatch.setHomeTeam(
                homeTeamCombo.getValue()
        );

        selectedMatch.setAwayTeam(
                awayTeamCombo.getValue()
        );

        selectedMatch.setScore(
                scoreField.getText()
        );

        selectedMatch.setMatchType(
                ligaRadio.isSelected() ? "Liga" : "Kupa"
        );

        selectedMatch.setFinished(
                finishedCheckBox.isSelected()
        );

        matchTable.refresh();

        showAlert(
                Alert.AlertType.INFORMATION,
                "Sukses",
                "Ndeshja u editua!"
        );
    }

    // =========================
    // DELETE MATCH
    // =========================

    @FXML
    void deleteMatch(ActionEvent event) {

        Match selectedMatch =
                matchTable.getSelectionModel().getSelectedItem();

        if (selectedMatch == null) {

            showAlert(
                    Alert.AlertType.ERROR,
                    "Gabim",
                    "Zgjidh një ndeshje!"
            );

            return;
        }

        matchList.remove(selectedMatch);

        showAlert(
                Alert.AlertType.INFORMATION,
                "Sukses",
                "Ndeshja u fshi!"
        );
    }

    // =========================
    // CLEAR FIELDS
    // =========================

    @FXML
    void clearFields(ActionEvent event) {

        homeTeamCombo.setValue(null);

        awayTeamCombo.setValue(null);

        scoreField.clear();

        ligaRadio.setSelected(false);

        kupaRadio.setSelected(false);

        finishedCheckBox.setSelected(false);
    }

    // =========================
    // ALERT METHOD
    // =========================

    private void showAlert(
            Alert.AlertType type,
            String title,
            String message
    ) {

        Alert alert = new Alert(type);

        alert.setTitle(title);

        alert.setHeaderText(null);

        alert.setContentText(message);

        alert.show();
    }
}