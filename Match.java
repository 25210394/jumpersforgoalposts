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
    public void displayMatchDetailsInDialog(Map<String, Player> homeSelectedPlayers, Map<String, Player> awaySelectedPlayers) {

        // Create a dialog window
        JDialog dialog = new JDialog((Frame) null, "Match Details", true);
        dialog.setSize(1000, 1000);
        dialog.setLayout(new GridLayout(5, 2));
        dialog.setLocationRelativeTo(null); // Center the frame

        // Add labels for team details
        JLabel dateLabel = new JLabel("Date: " + date);
        JLabel scoreLabel = new JLabel("Score: " + score);
        JLabel homeTeamLabel = new JLabel("Home Team: " + homeTeam.getName());
        JLabel awayTeamLabel = new JLabel("Away Team: " + awayTeam.getName());
        String homeLineupText = "<html><b>Home Lineup:</b><br>" + formatLineup(homeLineup) + "</html>";
        String awayLineupText = "<html><b>Away Lineup:</b><br>" + formatLineup(awayLineup) + "</html>";
        JLabel homeLineupLabel = new JLabel(homeLineupText);
        JLabel awayLineupLabel = new JLabel(awayLineupText);

        // Add labels to the dialog
        dialog.add(dateLabel);
        dialog.add(scoreLabel);
        dialog.add(homeTeamLabel);
        dialog.add(awayTeamLabel);
        dialog.add(homeLineupLabel);
        dialog.add(awayLineupLabel);

        // Display goalscorers
        StringBuilder goalscorersText = new StringBuilder("<html><b>Goalscorers:</b><br>");
        for (MatchEvent goal : goalscorers) {
            goalscorersText.append(goal.getPlayer().getName()).append(" - ").append(goal.getTime()).append("<br>");
        }
        goalscorersText.append("</html>");

        JLabel goalscorersLabel = new JLabel(goalscorersText.toString());
        dialog.add(goalscorersLabel);

        // Display substitutions
        StringBuilder substitutionsText = new StringBuilder("<html><b>Substitutions:</b><br>");
        for (MatchEvent substitution : substitutions) {
            substitutionsText.append(substitution.getPlayer().getName()).append(" - ").append(substitution.getTime()).append("<br>");
        }
        substitutionsText.append("</html>");

        JLabel substitutionsLabel = new JLabel(substitutionsText.toString());
        dialog.add(substitutionsLabel);

        // Display cards
        StringBuilder cardsText = new StringBuilder("<html><b>Cards:</b><br>");
        for (MatchEvent card : cards) {
            cardsText.append(card.getPlayer().getName()).append(" - ").append(card.getTime()).append("<br>");
        }
        cardsText.append("</html>");

        JLabel cardsLabel = new JLabel(cardsText.toString());
        dialog.add(cardsLabel);

        // Set the dialog to be visible
        dialog.setVisible(true);
    }

    private String formatLineup(Map<String, Player> lineup) {
        StringBuilder formattedLineup = new StringBuilder();
        for (Map.Entry<String, Player> entry : lineup.entrySet()) {
            formattedLineup.append(entry.getKey()).append(": ").append(entry.getValue()).append("<br>");
        }
        return formattedLineup.toString();
    }
}
