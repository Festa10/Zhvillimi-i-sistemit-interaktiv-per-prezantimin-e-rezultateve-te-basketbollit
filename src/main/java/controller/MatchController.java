package controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
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
    private TextField homeScoreField;

    @FXML
    private TextField awayScoreField;

    @FXML
    private TextField refereeField;

    @FXML
    private TextField stadiumField;

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

    @FXML
    private TableColumn<Match, String> winnerColumn;

    // =========================
    // MATCH LIST
    // =========================

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
                "Ylli",
                "Bashkimi"
        );

        awayTeamCombo.getItems().addAll(
                "Peja",
                "Prishtina",
                "Ylli",
                "Bashkimi"
        );

        // =========================
        // TABLE COLUMNS
        // =========================

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

        winnerColumn.setCellValueFactory(
                new PropertyValueFactory<>("winner")
        );

        // =========================
        // TABLE SETTINGS
        // =========================

        matchTable.setItems(matchList);

        matchTable.setColumnResizePolicy(
                TableView.CONSTRAINED_RESIZE_POLICY
        );

        matchTable.setPlaceholder(
                new Label("Nuk ka ndeshje")
        );

        // =========================
        // CLICK ROW TO EDIT
        // =========================

        matchTable.setOnMouseClicked(event -> {

            Match selectedMatch =
                    matchTable.getSelectionModel()
                            .getSelectedItem();

            if (selectedMatch != null) {

                homeTeamCombo.setValue(
                        selectedMatch.getHomeTeam()
                );

                awayTeamCombo.setValue(
                        selectedMatch.getAwayTeam()
                );

                homeScoreField.setText(
                        String.valueOf(
                                selectedMatch.getHomeScore()
                        )
                );

                awayScoreField.setText(
                        String.valueOf(
                                selectedMatch.getAwayScore()
                        )
                );

                refereeField.setText(
                        selectedMatch.getReferee()
                );

                stadiumField.setText(
                        selectedMatch.getStadium()
                );

                if (selectedMatch.getMatchType()
                        .equals("Liga")) {

                    ligaRadio.setSelected(true);

                } else {

                    kupaRadio.setSelected(true);
                }

                finishedCheckBox.setSelected(
                        selectedMatch.isFinished()
                );
            }
        });

        // =========================
        // LIVE SEARCH
        // =========================

        searchField.textProperty().addListener(
                (observable, oldValue, newValue) -> {

                    ObservableList<Match> filteredList =
                            FXCollections.observableArrayList();

                    for (Match match : matchList) {

                        if (match.getHomeTeam()
                                .toLowerCase()
                                .contains(newValue.toLowerCase())

                                ||

                                match.getAwayTeam()
                                        .toLowerCase()
                                        .contains(newValue.toLowerCase())) {

                            filteredList.add(match);
                        }
                    }

                    matchTable.setItems(filteredList);

                    if (newValue.isEmpty()) {

                        matchTable.setItems(matchList);
                    }
                });
    }

    // =========================
    // ADD MATCH
    // =========================

    @FXML
    void saveMatch() {

        String homeTeam =
                homeTeamCombo.getValue();

        String awayTeam =
                awayTeamCombo.getValue();

        String homeScoreText =
                homeScoreField.getText();

        String awayScoreText =
                awayScoreField.getText();

        // =========================
        // VALIDATION
        // =========================

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

        if (homeScoreText.isEmpty()
                || awayScoreText.isEmpty()) {

            showAlert(
                    Alert.AlertType.ERROR,
                    "Gabim",
                    "Shkruaj rezultatet!"
            );

            return;
        }

        int homeScore;
        int awayScore;

        try {

            homeScore =
                    Integer.parseInt(homeScoreText);

            awayScore =
                    Integer.parseInt(awayScoreText);

        } catch (NumberFormatException e) {

            showAlert(
                    Alert.AlertType.ERROR,
                    "Gabim",
                    "Rezultati duhet të jetë numër!"
            );

            return;
        }

        // =========================
        // MATCH TYPE
        // =========================

        String matchType =
                ligaRadio.isSelected() ? "Liga" :
                        kupaRadio.isSelected() ? "Kupa" :
                                "Nuk është zgjedhur";

        // =========================
        // CREATE MATCH
        // =========================

        Match match = new Match(

                homeTeam,
                awayTeam,

                homeScore,
                awayScore,

                matchType,

                finishedCheckBox.isSelected(),

                refereeField.getText(),

                stadiumField.getText()
        );

        // =========================
        // ADD TO TABLE
        // =========================

        matchList.add(match);

        showAlert(
                Alert.AlertType.INFORMATION,
                "Sukses",
                "Ndeshja u shtua me sukses!"
        );

        clearFields();
    }

    // =========================
    // EDIT MATCH
    // =========================

    @FXML
    void editMatch() {

        Match selectedMatch =
                matchTable.getSelectionModel()
                        .getSelectedItem();

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

        selectedMatch.setHomeScore(
                Integer.parseInt(
                        homeScoreField.getText()
                )
        );

        selectedMatch.setAwayScore(
                Integer.parseInt(
                        awayScoreField.getText()
                )
        );

        selectedMatch.setMatchType(
                ligaRadio.isSelected()
                        ? "Liga"
                        : "Kupa"
        );

        selectedMatch.setFinished(
                finishedCheckBox.isSelected()
        );

        selectedMatch.setReferee(
                refereeField.getText()
        );

        selectedMatch.setStadium(
                stadiumField.getText()
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
    void deleteMatch() {

        Match selectedMatch =
                matchTable.getSelectionModel()
                        .getSelectedItem();

        if (selectedMatch == null) {

            showAlert(
                    Alert.AlertType.ERROR,
                    "Gabim",
                    "Zgjidh një ndeshje!"
            );

            return;
        }

        Alert confirm = new Alert(
                Alert.AlertType.CONFIRMATION
        );

        confirm.setTitle("Konfirmim");

        confirm.setHeaderText(null);

        confirm.setContentText(
                "A dëshiron ta fshish ndeshjen?"
        );

        if (confirm.showAndWait().get()
                != ButtonType.OK) {

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
    void clearFields() {

        homeTeamCombo.setValue(null);

        awayTeamCombo.setValue(null);

        homeScoreField.clear();

        awayScoreField.clear();

        refereeField.clear();

        stadiumField.clear();

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

        alert.showAndWait();
    }
}