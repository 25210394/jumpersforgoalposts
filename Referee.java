package jumpersforgoalposts;

import javax.swing.*;
import java.awt.*;

// A class representing Referees, with attributes specific to their role.

public class Referee extends Individual {

	// Attributes
	
	private String league;
	private String international;

	// Methods
	
	// Creating a parameterised constructor
	public Referee(String name, int age, String pay, String employmentStatus, String league, String international) {
		this.name = name;
		this.age = age;
		this.pay = pay;
		this.employmentStatus = employmentStatus;
		this.league = league;
		this.international = international;
	}

	// Create Referee
	public static Referee getRefereeFromUserInput() {
        JTextField nameField = new JTextField();
        JTextField ageField = new JTextField();
        JTextField payField = new JTextField();
        JTextField employmentStatusField = new JTextField();
        JTextField leagueField = new JTextField();
        JTextField internationalField = new JTextField();

        // Create a panel to hold the input components
        JPanel panel = new JPanel(new GridLayout(6, 2));
        panel.add(new JLabel("Referee Name:"));
        panel.add(nameField);
        panel.add(new JLabel("Referee Age:"));
        panel.add(ageField);
        panel.add(new JLabel("Yearly Pay:"));
        panel.add(payField);
        panel.add(new JLabel("Employment Status:"));
        panel.add(employmentStatusField);
        panel.add(new JLabel("Refereeing League:"));
        panel.add(leagueField);
        panel.add(new JLabel("International Duty:"));
        panel.add(internationalField);

        // Show the input dialog
        int result = JOptionPane.showConfirmDialog(null, panel, "Enter Referee Details",
                JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);

        // If the user clicks "OK", create and return the Referee object
        if (result == JOptionPane.OK_OPTION) {
            String refereeName = nameField.getText();
            int refereeAge = Integer.parseInt(ageField.getText());
            String refereePay = payField.getText();
            String refereeEmploymentStatus = employmentStatusField.getText();
            String refereeingLeague = leagueField.getText();
            String refereeInternational = internationalField.getText();

            return new Referee(refereeName, refereeAge, refereePay, refereeEmploymentStatus, refereeingLeague, refereeInternational);
        } else {
            // Return null or handle the cancellation as needed
            return null;
        }
    }

	// Display Referee details in a dialog
    public void displayRefereeDetailsInDialog() {
        // Create a dialog window
        JDialog dialog = new JDialog((Frame) null, "Referee Details", true);
        dialog.setSize(300, 200);
        dialog.setLayout(new GridLayout(4, 1));

        // Add labels for team details
        JLabel nameLabel = new JLabel("Name: " + name);
        JLabel ageLabel = new JLabel("Age: " + age);
        JLabel payLabel = new JLabel("Pay: " + pay);
		JLabel employmentLabel = new JLabel("Employment Status: " + employmentStatus);
        JLabel leagueLabel = new JLabel("Refereeing League: " + league);
        JLabel internationalLabel = new JLabel("Referee's Internationally?: " + international);

        // Add labels to the dialog
        dialog.add(nameLabel);
        dialog.add(ageLabel);
        dialog.add(payLabel);
		dialog.add(employmentLabel);
        dialog.add(leagueLabel);
        dialog.add(internationalLabel);

        // Set the dialog to be visible
        dialog.setVisible(true);
    }
}