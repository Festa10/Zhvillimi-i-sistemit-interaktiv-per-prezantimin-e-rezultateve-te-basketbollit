package models;

public class Match {

    // =========================
    // ATTRIBUTES
    // =========================

    private String homeTeam;
    private String awayTeam;

    private int homeScore;
    private int awayScore;

    private String matchType;

    private boolean finished;

    private String referee;
    private String stadium;

    // =========================
    // CONSTRUCTOR
    // =========================

    public Match(String homeTeam,
                 String awayTeam,
                 int homeScore,
                 int awayScore,
                 String matchType,
                 boolean finished,
                 String referee,
                 String stadium) {

        this.homeTeam = homeTeam;
        this.awayTeam = awayTeam;
        this.homeScore = homeScore;
        this.awayScore = awayScore;
        this.matchType = matchType;
        this.finished = finished;
        this.referee = referee;
        this.stadium = stadium;
    }

    // =========================
    // HOME TEAM
    // =========================

    public String getHomeTeam() {
        return homeTeam;
    }

    public void setHomeTeam(String homeTeam) {
        this.homeTeam = homeTeam;
    }

    // =========================
    // AWAY TEAM
    // =========================

    public String getAwayTeam() {
        return awayTeam;
    }

    public void setAwayTeam(String awayTeam) {
        this.awayTeam = awayTeam;
    }

    // =========================
    // HOME SCORE
    // =========================

    public int getHomeScore() {
        return homeScore;
    }

    public void setHomeScore(int homeScore) {
        this.homeScore = homeScore;
    }

    // =========================
    // AWAY SCORE
    // =========================

    public int getAwayScore() {
        return awayScore;
    }

    public void setAwayScore(int awayScore) {
        this.awayScore = awayScore;
    }

    // =========================
    // MATCH TYPE
    // =========================

    public String getMatchType() {
        return matchType;
    }

    public void setMatchType(String matchType) {
        this.matchType = matchType;
    }

    // =========================
    // FINISHED
    // =========================

    public boolean isFinished() {
        return finished;
    }

    public void setFinished(boolean finished) {
        this.finished = finished;
    }

    // =========================
    // REFEREE
    // =========================

    public String getReferee() {
        return referee;
    }

    public void setReferee(String referee) {
        this.referee = referee;
    }

    // =========================
    // STADIUM
    // =========================

    public String getStadium() {
        return stadium;
    }

    public void setStadium(String stadium) {
        this.stadium = stadium;
    }

    // =========================
    // SCORE FORMAT
    // =========================

    public String getScore() {
        return homeScore + " - " + awayScore;
    }

    // =========================
    // WINNER
    // =========================

    public String getWinner() {

        if (homeScore > awayScore) {
            return homeTeam;
        }

        else if (awayScore > homeScore) {
            return awayTeam;
        }

        return "Draw";
    }
}