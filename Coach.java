import javax.swing.*;
import java.awt.*;

// A class representing Coaches, with attributes specific to their role.

public class Coach extends Individual {

	// Attributes
	
	private String coachingTeam;
	private String qualification;

	// Methods
	
	// Creating a parameterised constructor
	public Coach(String name, int age, String pay, String employmentStatus, String coachingTeam, String qualification) {
		this.name = name;
		this.age = age;
		this.pay = pay;
		this.employmentStatus = employmentStatus;
		this.coachingTeam = coachingTeam;
		this.qualification = qualification;
	}

	// Create coach
	public static Coach getCoachFromUserInput() {
        JTextField nameField = new JTextField();
        JTextField ageField = new JTextField();
        JTextField payField = new JTextField();
        JTextField employmentStatusField = new JTextField();
        JTextField coachingTeamField = new JTextField();
        JTextField qualificationField = new JTextField();

        // Create a panel to hold the input components
        JPanel panel = new JPanel(new GridLayout(6, 2));
        panel.add(new JLabel("Coach Name:"));
        panel.add(nameField);
        panel.add(new JLabel("Coach Age:"));
        panel.add(ageField);
        panel.add(new JLabel("Yearly Pay:"));
        panel.add(payField);
        panel.add(new JLabel("Employment Status:"));
        panel.add(employmentStatusField);
        panel.add(new JLabel("Coaching Team:"));
        panel.add(coachingTeamField);
        panel.add(new JLabel("Qualification(s):"));
        panel.add(qualificationField);

        // Show the input dialog
        int result = JOptionPane.showConfirmDialog(null, panel, "Enter Coach Details",
                JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);

        // If the user clicks "OK", create and return the Coach object
        if (result == JOptionPane.OK_OPTION) {
            String coachName = nameField.getText();
            int coachAge = Integer.parseInt(ageField.getText());
            String coachPay = payField.getText();
            String coachEmploymentStatus = employmentStatusField.getText();
            String coachingTeam = coachingTeamField.getText();
            String coachQualifications = qualificationField.getText();

            return new Coach(coachName, coachAge, coachPay, coachEmploymentStatus, coachingTeam, coachQualifications);
        } else {
            // Return null or handle the cancellation as needed
            return null;
        }
    }

	// Display Coach details in a dialog
    public void displayCoachDetailsInDialog() {
        // Create a dialog window
        JDialog dialog = new JDialog((Frame) null, "Coach Details", true);
        dialog.setSize(300, 200);
        dialog.setLayout(new GridLayout(4, 1));

        // Add labels for team details
        JLabel nameLabel = new JLabel("Name: " + name);
        JLabel ageLabel = new JLabel("Age: " + age);
        JLabel payLabel = new JLabel("Pay: " + pay);
		JLabel employmentLabel = new JLabel("Employment Status: " + employmentStatus);
        JLabel coachingLabel = new JLabel("Coaching Team: " + coachingTeam);
        JLabel qualificationLabel = new JLabel("Coach's Qualifications: " + qualification);

        // Add labels to the dialog
        dialog.add(nameLabel);
        dialog.add(ageLabel);
        dialog.add(payLabel);
		dialog.add(employmentLabel);
        dialog.add(coachingLabel);
        dialog.add(qualificationLabel);

        // Set the dialog to be visible
        dialog.setVisible(true);
    }
}