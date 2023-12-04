package jumpersforgoalposts;

import java.util.List;
import java.util.Map;
import javax.swing.*;
import java.awt.*;

// A class to store and manage match results, including information about the week of the match, home and away teams, goal-scorers, player positions, substitutions, and cards.

public class Match {

    // Attributes

    private String date;
    private String score;
    private Team homeTeam;
    private Team awayTeam;
    private List<MatchEvent> goalscorers;
    private List<MatchEvent> substitutions;
    private List<MatchEvent> cards;
    private Map<String, Player> homeLineup;
    private Map<String, Player> awayLineup;

    // Methods

    // Constructor
    public Match(String date, String score, Team homeTeam, Team awayTeam, Map<String, Player> homeLineup, Map<String, Player> awayLineup, List<MatchEvent> goalscorers, List<MatchEvent> substitutions, List<MatchEvent> cards) {
        this.date = date;
        this.score = score;
        this.homeTeam = homeTeam;
        this.awayTeam = awayTeam;
        this.homeLineup = homeLineup;
        this.awayLineup = awayLineup;
        this.goalscorers = goalscorers;
        this.substitutions = substitutions;
        this.cards = cards;
    }

    public String getDate() {
        return date;
    }

    // Display match details in a dialog
    public void displayMatchDetailsInDialog(Map<String, Player> selectedPlayers) {

        // Create a dialog window
        JDialog dialog = new JDialog((Frame) null, "Match Details", true);
        dialog.setSize(1000, 1000);
        dialog.setLayout(new GridLayout(7, 1));

        // Add labels for team details
        JLabel dateLabel = new JLabel("Date: " + date);
        JLabel scoreLabel = new JLabel("Score: " + score);
        JLabel homeTeamLabel = new JLabel("Home Team: " + homeTeam.getName());
        JLabel awayTeamLabel = new JLabel("Away Team: " + awayTeam.getName());
        JLabel homeLineupLabel = new JLabel("Home Lineup: " + homeLineup);
        JLabel awayLineupLabel = new JLabel("Away Lineup: " + awayLineup);

        // Add labels to the dialog
        dialog.add(dateLabel);
        dialog.add(scoreLabel);
        dialog.add(homeTeamLabel);
        dialog.add(awayTeamLabel);
        dialog.add(homeLineupLabel);
        dialog.add(awayLineupLabel);

        // Display goalscorers
        JLabel goalscorersLabel = new JLabel("Goalscorers:");
        dialog.add(goalscorersLabel);
        for (MatchEvent goal : goalscorers) {
            JLabel goalLabel = new JLabel(goal.getPlayer().getName() + " - " + goal.getTime());
            dialog.add(goalLabel);
        }

        // Display substitutions
        JLabel substitutionsLabel = new JLabel("Substitutions:");
        dialog.add(substitutionsLabel);
        for (MatchEvent substitution : substitutions) {
            JLabel substitutionLabel = new JLabel(substitution.getPlayer().getName() + " - " + substitution.getTime());
            dialog.add(substitutionLabel);
        }

        // Display cards
        JLabel cardsLabel = new JLabel("Cards:");
        dialog.add(cardsLabel);
        for (MatchEvent card : cards) {
            JLabel cardLabel = new JLabel(card.getPlayer().getName() + " - " + card.getTime());
            dialog.add(cardLabel);
        }

        // Set the dialog to be visible
        dialog.setVisible(true);
    }
}
