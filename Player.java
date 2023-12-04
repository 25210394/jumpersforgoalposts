import javax.swing.*;
import java.awt.*;

// A class representing individual players, including attributes such as position, preferred formation, pay, and employment status.

public class Player extends Individual {

	// Attributes
	
	private String position;
	private String preferredFormation;
	
	// Methods
	
	// Creating a parameterised constructor
	public Player(String name, int age, String pay, String employmentStatus, String position, String preferredFormation) {
		this.name = name;
		this.age = age;
		this.pay = pay;
		this.employmentStatus = employmentStatus;
		this.position = position;
		this.preferredFormation = preferredFormation;
	}
	
	// Create player
	public static Player getPlayerFromUserInput() {
        JTextField nameField = new JTextField();
        JTextField ageField = new JTextField();
        JTextField payField = new JTextField();
        JTextField employmentStatusField = new JTextField();
        JTextField positionField = new JTextField();
        JTextField preferredFormationField = new JTextField();

        // Create a panel to hold the input components
        JPanel panel = new JPanel(new GridLayout(6, 2));
        panel.add(new JLabel("Player Name:"));
        panel.add(nameField);
        panel.add(new JLabel("Player Age:"));
        panel.add(ageField);
        panel.add(new JLabel("Yearly Pay:"));
        panel.add(payField);
        panel.add(new JLabel("Employment Status:"));
        panel.add(employmentStatusField);
        panel.add(new JLabel("Position:"));
        panel.add(positionField);
        panel.add(new JLabel("Preferred Formation:"));
        panel.add(preferredFormationField);

        // Show the input dialog
        int result = JOptionPane.showConfirmDialog(null, panel, "Enter Player Details",
                JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);

        // If the user clicks "OK", create and return the Player object
        if (result == JOptionPane.OK_OPTION) {
            String playerName = nameField.getText();
            int playerAge = Integer.parseInt(ageField.getText());
            String playerPay = payField.getText();
            String playerEmploymentStatus = employmentStatusField.getText();
            String playerPosition = positionField.getText();
            String playerPreferredFormation = preferredFormationField.getText();

            return new Player(playerName, playerAge, playerPay, playerEmploymentStatus, playerPosition, playerPreferredFormation);
        } else {
            // Return null or handle the cancellation as needed
            return null;
        }
    }
	
	// Display player details in a dialog
    public void displayPlayerDetailsInDialog() {
        // Create a dialog window
        JDialog dialog = new JDialog((Frame) null, "Player Details", true);
        dialog.setSize(300, 200);
        dialog.setLayout(new GridLayout(4, 1));
        dialog.setLocationRelativeTo(null); // Center the frame

        // Add labels for team details
        JLabel nameLabel = new JLabel("Name: " + name);
        JLabel ageLabel = new JLabel("Age: " + age);
        JLabel payLabel = new JLabel("Pay: " + pay);
		JLabel employmentLabel = new JLabel("Employment Status: " + employmentStatus);
        JLabel positionLabel = new JLabel("Position: " + position);
        JLabel formationLabel = new JLabel("Preferred Formation: " + preferredFormation);

        // Add labels to the dialog
        dialog.add(nameLabel);
        dialog.add(ageLabel);
        dialog.add(payLabel);
		dialog.add(employmentLabel);
        dialog.add(positionLabel);
        dialog.add(formationLabel);

        // Set the dialog to be visible
        dialog.setVisible(true);
    }
}
