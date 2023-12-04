import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

// A class representing teams participating in the league. It includes attributes like the home ground and capacity.

public class Team {

	// Attributes
	
	private String teamName;
	private String homeGround;
	private String capacity;
	private ArrayList<Player> players;
    private int teamPoints;
	
	// Methods

	// Creating a parameterised constructor
	public Team(String teamName, String homeGround, String capacity, ArrayList<Player> players, int teamPoints) {
		this.teamName = teamName;
		this.homeGround = homeGround;
		this.capacity = capacity;
		this.players = new ArrayList<>();
        this.teamPoints = teamPoints;
	}
	
	// Getter for team name
	public String getName() {
		return teamName;
	}

    // Getter for team name
	public int getPoints() {
		return teamPoints;
	}
    
	// Create Team using GUI input
    public static Team getTeamFromUserInput() {
        JTextField teamNameField = new JTextField();
        JTextField homeGroundField = new JTextField();
        JTextField capacityField = new JTextField();
        JTextField teamPointsField = new JTextField();

        JPanel panel = new JPanel(new GridLayout(4, 2));
        panel.add(new JLabel("Team Name:"));
        panel.add(teamNameField);
        panel.add(new JLabel("Home Ground:"));
        panel.add(homeGroundField);
        panel.add(new JLabel("Capacity:"));
        panel.add(capacityField);
        panel.add(new JLabel("Current Points: "));
        panel.add(teamPointsField);

        int result = JOptionPane.showConfirmDialog(null, panel, "Enter Team Details",
                JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);

        if (result == JOptionPane.OK_OPTION) {
            String teamName = teamNameField.getText();
            String homeGround = homeGroundField.getText();
            String capacity = capacityField.getText();
            ArrayList<Player> players = new ArrayList<>();
            int teamPoints = Integer.parseInt(teamPointsField.getText());

            return new Team(teamName, homeGround, capacity, players, teamPoints);
        } else {
            return null;  // Handle cancellation
        }
    }

	// Add player to team
	public void addPlayer(Player player) {
        players.add(player);
        System.out.println(player.getName() + " added to " + teamName);
    }
	
	// Remove player from team
    public void removePlayer(Player player) {
        players.remove(player);
        System.out.println(player.getName() + " removed from " + teamName);
    }

    // Display team details in a dialog
    public void displayTeamDetailsInDialog() {
        // Create a dialog window
        JDialog dialog = new JDialog((Frame) null, "Team Details", true);
        dialog.setSize(300, 200);
        dialog.setLayout(new GridLayout(4, 1));
        dialog.setLocationRelativeTo(null); // Center the frame

        // Add labels for team details
        JLabel nameLabel = new JLabel("Team Name: " + teamName);
        JLabel groundLabel = new JLabel("Home Ground: " + homeGround);
        JLabel capacityLabel = new JLabel("Capacity: " + capacity);

        // Add labels to the dialog
        dialog.add(nameLabel);
        dialog.add(groundLabel);
        dialog.add(capacityLabel);

		// Display current players
        if (!players.isEmpty()) {
            JTextArea playersTextArea = new JTextArea("Current Players:\n");
            playersTextArea.setEditable(false);

            for (Player player : players) {
                playersTextArea.append("- " + player.getName() + "\n");
            }

            // Create a scroll pane if needed
            JScrollPane scrollPane = new JScrollPane(playersTextArea);

            dialog.add(scrollPane);
        }

        // Set the dialog to be visible
        dialog.setVisible(true);
    }

    @Override
    public String toString() {
        return teamName; // or any other meaningful representation
    }

    public ArrayList<Player> getAllPlayers() {
        return players;
    }

}
