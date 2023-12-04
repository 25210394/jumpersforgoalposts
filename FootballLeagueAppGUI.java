import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import javax.swing.text.MaskFormatter;
import java.text.ParseException;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Vector;
import java.util.List;
import java.util.Map;

public class FootballLeagueAppGUI {

    // Attributes 

    private JFrame frame;
    private ArrayList<Team> teams;  // List to store created teams
    private ArrayList<Player> players;  // List to store created teams
    private ArrayList<Coach> coaches; // List to store created coaches
    private ArrayList<Referee> referees; // List to store created referees
    private ArrayList<Match> matches; // List to store created matches
    private JPanel playerPanel;
    private JTextField searchBar;
    private Map<String, Player> awaySelectedPlayers = new HashMap<>();
    private Map<String, Player> homeSelectedPlayers = new HashMap<>();

    public FootballLeagueAppGUI() {
        teams = new ArrayList<>();  // Initialise the list of teams
        players = new ArrayList<>(); // Initialise the list of players
        coaches = new ArrayList<>(); // Initialise the list of coaches
        referees = new ArrayList<>(); // Initialise the list of referees
        matches = new ArrayList<>(); // Initialise the list of matches

        // Calling method to add players to teams during initialisation
        DataInitializer.initializeTeamsAndPlayers(teams, players);

        // Other misc. initialisation
        coaches.add(new Coach("Terry Yates", 38, "£700", "Full-Time", "Burscough Bayonets", "Masters Degree"));
        coaches.add(new Coach("Micky Downs", 34, "£00", "Full-Time", "Orrel Owls", "Level 3 BTEC"));
        referees.add(new Referee("Mike Dean", 38, "£1700", "Full-Time", "Ormskirk", "Yes"));
        referees.add(new Referee("Rio Small", 45, "£800", "Part-Time", "Ormskirk", "No"));
    }

    // Methods
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            FootballLeagueAppGUI appGUI = new FootballLeagueAppGUI();
            appGUI.showMainMenu();
        });
    }

    public void showMainMenu() {
        frame = new JFrame("Football League App");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1600, 800);
        frame.setLayout(new BorderLayout());
    
        // Set resizable to false
        frame.setResizable(false);
        frame.setLocationRelativeTo(null); // Center the frame
    
        JPanel mainMenuPanel = new JPanel();
        mainMenuPanel.setLayout(new GridLayout(2, 4));
    
        JButton profileViewer = new JButton();
        profileViewer.setIcon(new ImageIcon(new javax.swing.ImageIcon(getClass().getResource("/images/playerSearch.png")).getImage().getScaledInstance(200, 200, Image.SCALE_SMOOTH)));
        JButton teamViewer = new JButton();
        teamViewer.setIcon(new ImageIcon(new javax.swing.ImageIcon(getClass().getResource("/images/teamViewer.png")).getImage().getScaledInstance(200, 200, Image.SCALE_SMOOTH)));
        JButton leagueViewer = new JButton();
        leagueViewer.setIcon(new ImageIcon(new javax.swing.ImageIcon(getClass().getResource("/images/leagueViewer.png")).getImage().getScaledInstance(200, 200, Image.SCALE_SMOOTH)));
        JButton playerCreator = new JButton();
        playerCreator.setIcon(new ImageIcon(new javax.swing.ImageIcon(getClass().getResource("/images/playerCreator.png")).getImage().getScaledInstance(200, 200, Image.SCALE_SMOOTH)));
        JButton teamCreator = new JButton();
        teamCreator.setIcon(new ImageIcon(new javax.swing.ImageIcon(getClass().getResource("/images/teamCreator.png")).getImage().getScaledInstance(200, 200, Image.SCALE_SMOOTH)));
        JButton matchRecorder = new JButton();
        matchRecorder.setIcon(new ImageIcon(new javax.swing.ImageIcon(getClass().getResource("/images/matchRecorder.png")).getImage().getScaledInstance(200, 200, Image.SCALE_SMOOTH)));
        JButton teamEditor = new JButton();
        teamEditor.setIcon(new ImageIcon(new javax.swing.ImageIcon(getClass().getResource("/images/teamEditor.png")).getImage().getScaledInstance(200, 200, Image.SCALE_SMOOTH)));
        JButton matchViewer = new JButton();
        matchViewer.setIcon(new ImageIcon(new javax.swing.ImageIcon(getClass().getResource("/images/matchViewer.png")).getImage().getScaledInstance(200, 200, Image.SCALE_SMOOTH)));

        // Main menu action listeners

        playerCreator.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showCreatePlayerDialog(); // Call method to show the dialog
            }
        });

        teamCreator.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showCreateTeamDialog(); // Call method to show the team creation dialog
            }
        });

        teamViewer.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showTeamViewer();
            }
        });

        profileViewer.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showProfileViewer();
            }
        });

        teamEditor.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showTeamEditorViewer();
            }
        });
        
        matchRecorder.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showMatchRecorder();
            }
        });

        matchViewer.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showMatchViewer();
            }
        });

        leagueViewer.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showLeagueTable();
            }
        });

        mainMenuPanel.add(profileViewer);
        mainMenuPanel.add(teamViewer);
        mainMenuPanel.add(leagueViewer);
        mainMenuPanel.add(playerCreator);
        mainMenuPanel.add(teamCreator);
        mainMenuPanel.add(matchRecorder);
        mainMenuPanel.add(teamEditor);
        mainMenuPanel.add(matchViewer);

        frame.add(mainMenuPanel, BorderLayout.CENTER);
        frame.setVisible(true);
    }

    private void showCreatePlayerDialog() {
        // Create a dialog window
        JDialog dialog = new JDialog(frame, "Add Player", true);
        dialog.setSize(300, 200);
        dialog.setLayout(new GridLayout(2, 1));
        dialog.setLocationRelativeTo(null); // Center the frame

        // Add buttons for different types of individuals
        JButton addPlayerButton = new JButton("Add Player");
        JButton addCoachButton = new JButton("Add Coach");
        JButton addRefereeButton = new JButton("Add Referee");
        JButton deleteIndividualButton = new JButton("Delete Individual");

        // Add action listeners to handle button clicks
        addPlayerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Call the method to get player input and create a Player object
                Player newPlayer = Player.getPlayerFromUserInput();
                players.add(newPlayer); // Add the created player to the list
                JOptionPane.showMessageDialog(frame, "Player added: " + newPlayer.getName());
                dialog.dispose();
            }
        });

        addCoachButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Call the method to get player input and create a Player object
                Coach newCoach = Coach.getCoachFromUserInput();
                coaches.add(newCoach); // Add the created coach to the list
                JOptionPane.showMessageDialog(frame, "Coach added: " + newCoach.getName());
                dialog.dispose();
            }
        });

        addRefereeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Call the method to get player input and create a Player object
                Referee newReferee = Referee.getRefereeFromUserInput();
                referees.add(newReferee); // Add the created coach to the list
                JOptionPane.showMessageDialog(frame, "Referee added: " + newReferee.getName());
                dialog.dispose();
            }
        });

        deleteIndividualButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Handle deleting an individual
                showDeleteIndividualDialog();
                dialog.dispose();
            }
        });

        // Add buttons to the dialog
        dialog.add(addPlayerButton);
        dialog.add(addCoachButton);
        dialog.add(addRefereeButton);
        dialog.add(deleteIndividualButton);

        // Set the dialog to be visible
        dialog.setVisible(true);
    }

    private void showCreateTeamDialog() {
        // Create a dialog window for team creation
        JDialog dialog = new JDialog(frame, "Team Creator", true);
        dialog.setSize(300, 200);
        dialog.setLayout(new GridLayout(2, 1));
        dialog.setLocationRelativeTo(null); // Center the frame

        // Add buttons for different team-related options (if needed)
        JButton addTeamButton = new JButton("Create Team");
        JButton deleteTeamButton = new JButton("Delete Team");

        addTeamButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Call the method to get team input and create a Team object
                Team newTeam = Team.getTeamFromUserInput();
                teams.add(newTeam);  // Add the created team to the list
                JOptionPane.showMessageDialog(frame, "Team created: " + newTeam.getName());
                dialog.dispose();
            }
        });

        deleteTeamButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Handle deleting a team
                showDeleteTeamDialog();
                dialog.dispose();
            }
        });

        // Add buttons to the dialog
        dialog.add(addTeamButton);
        dialog.add(deleteTeamButton);

        // Set the dialog to be visible
        dialog.setVisible(true);
    }

    private void showTeamViewer() {
        JFrame teamViewerFrame = new JFrame("Team Viewer");
        teamViewerFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        teamViewerFrame.setSize(1000, 300);
        teamViewerFrame.setLayout(new GridLayout(3, 1));
        teamViewerFrame.setLocationRelativeTo(null); // Center the frame

        // Create buttons for each team
        for (Team team : teams) {
            JButton teamButton = new JButton(team.getName());
            teamButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    // Call method for displaying the team details
                    team.displayTeamDetailsInDialog();
                }
            });

            teamViewerFrame.add(teamButton);
        }

        teamViewerFrame.setVisible(true);
    }

    private void showProfileViewer() {
        JFrame profileViewerFrame = new JFrame("Profile Viewer");
        profileViewerFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        profileViewerFrame.setLayout(new BorderLayout());
        profileViewerFrame.setLocationRelativeTo(null); // Center the frame
    
        // Create a panel to hold the search bar and player buttons
        JPanel mainPanel = new JPanel(new BorderLayout());
    
        // Create a search bar with initial text
        searchBar = new JTextField("Search...");
        searchBar.addActionListener(e -> filterProfiles(searchBar.getText()));
    
        // Add the search bar to the main panel
        mainPanel.add(searchBar, BorderLayout.NORTH);
    
        // Initialize playerPanel
        playerPanel = new JPanel();
        playerPanel.setLayout(new GridLayout(0, 1)); // 0 means as many rows as needed, 1 column
    
        // Create buttons for each player
        for (Player player : players) {
            JButton playerButton = new JButton(player.getName() + " (Player)");
            playerButton.addActionListener(e -> player.displayPlayerDetailsInDialog());
            playerPanel.add(playerButton);
        }
    
        // Add coaches and referees to the player panel
        for (Coach coach : coaches) {
            JButton coachButton = new JButton(coach.getName() + " (Coach)");
            coachButton.addActionListener(e -> coach.displayCoachDetailsInDialog());
            playerPanel.add(coachButton);
        }
    
        for (Referee referee : referees) {
            JButton refereeButton = new JButton(referee.getName() + " (Referee)");
            refereeButton.addActionListener(e -> referee.displayRefereeDetailsInDialog());
            playerPanel.add(refereeButton);
        }
    
        // Add the player panel to a scroll pane
        JScrollPane scrollPane = new JScrollPane(playerPanel);
        mainPanel.add(scrollPane, BorderLayout.CENTER);
    
        // Set the preferred size of the scroll pane
        scrollPane.setPreferredSize(new Dimension(300, 500));
    
        // Add the main panel to the frame
        profileViewerFrame.add(mainPanel);
    
        profileViewerFrame.pack();
        profileViewerFrame.setLocationRelativeTo(null); // Center the frame
        profileViewerFrame.setVisible(true);
    }

    private void filterProfiles(String searchText) {
        // Clear the existing components in the playerPanel
        playerPanel.removeAll();
        
        // Create a new panel to hold the filtered player buttons
        JPanel filteredPlayerPanel = new JPanel();
        filteredPlayerPanel.setLayout(new GridLayout(0, 1));
    
        // Iterate through players
        for (Player player : players) {
            if (player.getName().toLowerCase().contains(searchText.toLowerCase())) {
                JButton playerButton = new JButton(player.getName() + " (Player)");
                playerButton.addActionListener(e -> player.displayPlayerDetailsInDialog());
                filteredPlayerPanel.add(playerButton);
            }
        }
    
        // Iterate through coaches
        for (Coach coach : coaches) {
            if (coach.getName().toLowerCase().contains(searchText.toLowerCase())) {
                JButton coachButton = new JButton(coach.getName() + " (Coach)");
                coachButton.addActionListener(e -> coach.displayCoachDetailsInDialog());
                filteredPlayerPanel.add(coachButton);
            }
        }
    
        // Iterate through referees
        for (Referee referee : referees) {
            if (referee.getName().toLowerCase().contains(searchText.toLowerCase())) {
                JButton refereeButton = new JButton(referee.getName() + " (Referee)");
                refereeButton.addActionListener(e -> referee.displayRefereeDetailsInDialog());
                filteredPlayerPanel.add(refereeButton);
            }
        }
    
        // Add the filtered player panel to the scroll pane
        playerPanel.add(filteredPlayerPanel);
        
        // Repaint the panel to reflect the changes
        playerPanel.revalidate();
        playerPanel.repaint();
    }

    private void showTeamEditorViewer() {
        JFrame teamViewerFrame = new JFrame("Team Editor");
        teamViewerFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        teamViewerFrame.setSize(1000, 300);
        teamViewerFrame.setLayout(new GridLayout(3, 1));
        teamViewerFrame.setLocationRelativeTo(null); // Center the frame

        // Create buttons for each team
        for (Team team : teams) {
            JButton teamButton = new JButton(team.getName());
            teamButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    showTeamEditorDialog(team);
                }
            });

            teamViewerFrame.add(teamButton);
        }

        teamViewerFrame.setVisible(true);
    }

    private void showTeamEditorDialog(Team team) {
        JDialog dialog = new JDialog((Frame) null, "Team Editor", true);
        dialog.setSize(200, 100);
        dialog.setLayout(new GridLayout(2, 1));
        dialog.setLocationRelativeTo(null); // Center the frame
    
        JButton addPlayerButton = new JButton("Add Player");
        JButton deletePlayerButton = new JButton("Remove Player");
    
        addPlayerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Call the method to show the dialog for adding a player to the team
                showAddPlayerDialog(team);
                dialog.dispose(); // Optional: Close the current dialog after adding a player
            }
        });
    
        deletePlayerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Call the method to show the dialog for deleting a player from the team
                showRemovePlayerDialog(team);
                dialog.dispose(); // Optional: Close the current dialog after deleting a player
            }
        });
    
        dialog.add(addPlayerButton);
        dialog.add(deletePlayerButton);
    
        dialog.setVisible(true);
    }

    private void showAddPlayerDialog(Team team) {
        JDialog dialog = new JDialog(frame, "Add Player to " + team.getName(), true);
        dialog.setLayout(new BorderLayout());
    
        // Get the list of all players
        ArrayList<Player> allPlayers = getAllPlayers();
    
        // Create a panel to hold the search bar and player buttons
        JPanel mainPanel = new JPanel(new BorderLayout());
    
        // Create a search bar with initial text
        JTextField searchBar = new JTextField("Search...");
        searchBar.addActionListener(e -> filterPlayersForAddition(searchBar.getText(), team, dialog));
    
        // Add the search bar to the main panel
        mainPanel.add(searchBar, BorderLayout.NORTH);
    
        // Initialize playerPanel
        JPanel playerPanel = new JPanel();
        playerPanel.setLayout(new GridLayout(0, 1)); // 0 means as many rows as needed, 1 column
    
        // Create buttons for each player
        for (Player player : allPlayers) {
            addAddButtonToPanel(player, playerPanel, team, dialog);
        }
    
        // Add the player panel to a scroll pane
        JScrollPane scrollPane = new JScrollPane(playerPanel);
        mainPanel.add(scrollPane, BorderLayout.CENTER);
    
        // Set the preferred size of the scroll pane
        scrollPane.setPreferredSize(new Dimension(300, 200));
    
        // Add the main panel to the dialog
        dialog.add(mainPanel);
    
        dialog.pack();
        dialog.setLocationRelativeTo(null); // Center the dialog
        dialog.setVisible(true);
    }
    
    private void filterPlayersForAddition(String searchText, Team team, JDialog dialog) {
        // Clear the existing components in the playerPanel
        JPanel playerPanel = (JPanel) ((BorderLayout) dialog.getContentPane().getLayout()).getLayoutComponent(BorderLayout.CENTER);
        playerPanel.removeAll();
    
        // Get the list of all players
        ArrayList<Player> allPlayers = getAllPlayers();
    
        // Create a panel to hold the filtered player buttons
        JPanel filteredPlayerPanel = new JPanel();
        filteredPlayerPanel.setLayout(new GridLayout(0, 1));
    
        // Iterate through players
        for (Player player : allPlayers) {
            if (player.getName().toLowerCase().contains(searchText.toLowerCase())) {
                addAddButtonToPanel(player, filteredPlayerPanel, team, dialog);
            }
        }
    
        // Add the filtered player panel to the scroll pane
        playerPanel.add(filteredPlayerPanel);
    
        // Repaint the panel to reflect the changes
        playerPanel.revalidate();
        playerPanel.repaint();
    }
    
    private void showRemovePlayerDialog(Team team) {
        JDialog dialog = new JDialog(frame, "Remove Player from " + team.getName(), true);
        dialog.setLayout(new BorderLayout());
    
        // Get the list of all players
        ArrayList<Player> allPlayers = getAllPlayers();
    
        // Create a panel to hold the search bar and player buttons
        JPanel mainPanel = new JPanel(new BorderLayout());
    
        // Create a search bar with initial text
        JTextField searchBar = new JTextField("Search...");
        searchBar.addActionListener(e -> filterPlayersForRemoval(searchBar.getText(), team, dialog));
    
        // Add the search bar to the main panel
        mainPanel.add(searchBar, BorderLayout.NORTH);
    
        // Initialize playerPanel
        JPanel playerPanel = new JPanel();
        playerPanel.setLayout(new GridLayout(0, 1)); // 0 means as many rows as needed, 1 column
    
        // Create buttons for each player
        for (Player player : allPlayers) {
            addRemoveButtonToPanel(player, playerPanel, team, dialog);
        }
    
        // Add the player panel to a scroll pane
        JScrollPane scrollPane = new JScrollPane(playerPanel);
        mainPanel.add(scrollPane, BorderLayout.CENTER);
    
        // Set the preferred size of the scroll pane
        scrollPane.setPreferredSize(new Dimension(300, 200));
    
        // Add the main panel to the dialog
        dialog.add(mainPanel);
    
        dialog.pack();
        dialog.setLocationRelativeTo(null); // Center the dialog
        dialog.setVisible(true);
    }
    
    private void filterPlayersForRemoval(String searchText, Team team, JDialog dialog) {
        // Clear the existing components in the playerPanel
        JPanel playerPanel = (JPanel) ((BorderLayout) dialog.getContentPane().getLayout()).getLayoutComponent(BorderLayout.CENTER);
        playerPanel.removeAll();
    
        // Get the list of all players
        ArrayList<Player> allPlayers = getAllPlayers();
    
        // Create a panel to hold the filtered player buttons
        JPanel filteredPlayerPanel = new JPanel();
        filteredPlayerPanel.setLayout(new GridLayout(0, 1));
    
        // Iterate through players
        for (Player player : allPlayers) {
            if (player.getName().toLowerCase().contains(searchText.toLowerCase())) {
                addRemoveButtonToPanel(player, filteredPlayerPanel, team, dialog);
            }
        }
    
        // Add the filtered player panel to the scroll pane
        playerPanel.add(filteredPlayerPanel);
    
        // Repaint the panel to reflect the changes
        playerPanel.revalidate();
        playerPanel.repaint();
    }
    
    private void addAddButtonToPanel(Player player, JPanel panel, Team team, JDialog dialog) {
        JButton playerButton = new JButton(player.getName());
        playerButton.addActionListener(e -> {
            // Add the selected player to the team
            team.addPlayer(player);
            JOptionPane.showMessageDialog(dialog, player.getName() + " added to " + team.getName());
            dialog.dispose(); // Close the dialog after adding a player
        });
    
        panel.add(playerButton);
    }
    
    private void addRemoveButtonToPanel(Player player, JPanel panel, Team team, JDialog dialog) {
        JButton playerButton = new JButton(player.getName());
        playerButton.addActionListener(e -> {
            // Remove the selected player from the team
            team.removePlayer(player);
            JOptionPane.showMessageDialog(dialog, player.getName() + " removed from " + team.getName());
            dialog.dispose(); // Close the dialog after removing a player
        });
    
        panel.add(playerButton);
    }
    
    // Method to get all players
    public ArrayList<Player> getAllPlayers() {
        return players;
    }

    // Method to get all coaches
    public ArrayList<Coach> getAllCoaches() {
        return coaches;
    }

    // Method to get all referees
    public ArrayList<Referee> getAllReferees() {
        return referees;
    }

    private void showDeleteIndividualDialog() {
        JFrame profileViewerFrame = new JFrame("Delete Individual");
        profileViewerFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        profileViewerFrame.setLayout(new BorderLayout());
        profileViewerFrame.setLocationRelativeTo(null); // Center the frame
    
        // Create a panel to hold the search bar and player buttons
        JPanel mainPanel = new JPanel(new BorderLayout());
    
        // Create a search bar with initial text
        searchBar = new JTextField("Search...");
        searchBar.addActionListener(e -> filterProfilesForDeletion(searchBar.getText()));
    
        // Add the search bar to the main panel
        mainPanel.add(searchBar, BorderLayout.NORTH);
    
        // Initialize playerPanel
        playerPanel = new JPanel();
        playerPanel.setLayout(new GridLayout(0, 1)); // 0 means as many rows as needed, 1 column
    
        // Create buttons for each player
        for (Player player : players) {
            addButtonToPanel(player, playerPanel, "Player");
        }
    
        // Add coaches and referees to the player panel
        for (Coach coach : coaches) {
            addButtonToPanel(coach, playerPanel, "Coach");
        }
    
        for (Referee referee : referees) {
            addButtonToPanel(referee, playerPanel, "Referee");
        }
    
        // Add the player panel to a scroll pane
        JScrollPane scrollPane = new JScrollPane(playerPanel);
        mainPanel.add(scrollPane, BorderLayout.CENTER);
    
        // Set the preferred size of the scroll pane
        scrollPane.setPreferredSize(new Dimension(300, 500));
    
        // Add the main panel to the frame
        profileViewerFrame.add(mainPanel);
    
        // Call filterProfilesForDeletion with an empty search text to display all players by default
        filterProfilesForDeletion("");
    
        profileViewerFrame.pack();
        profileViewerFrame.setLocationRelativeTo(null); // Center the frame
        profileViewerFrame.setVisible(true);
    }

    private void filterProfilesForDeletion(String searchText) {
        // Clear the existing components in the playerPanel
        playerPanel.removeAll();

        // Create a new panel to hold the filtered player buttons
        JPanel filteredPlayerPanel = new JPanel();
        filteredPlayerPanel.setLayout(new GridLayout(0, 1));

        // Iterate through players
        for (Player player : players) {
            if (player.getName().toLowerCase().contains(searchText.toLowerCase())) {
                addButtonToPanel(player, filteredPlayerPanel, "Player");
            }
        }

        // Iterate through coaches
        for (Coach coach : coaches) {
            if (coach.getName().toLowerCase().contains(searchText.toLowerCase())) {
                addButtonToPanel(coach, filteredPlayerPanel, "Coach");
            }
        }

        // Iterate through referees
        for (Referee referee : referees) {
            if (referee.getName().toLowerCase().contains(searchText.toLowerCase())) {
                addButtonToPanel(referee, filteredPlayerPanel, "Referee");
            }
        }

        // Add the filtered player panel to the scroll pane
        playerPanel.add(filteredPlayerPanel);

        // Repaint the panel to reflect the changes
        playerPanel.revalidate();
        playerPanel.repaint();
    }

    private void addButtonToPanel(Object individual, JPanel panel, String role) {
        JButton individualButton = new JButton(individual.toString() + " (" + role + ")");
        individualButton.addActionListener(e -> {
            if (individual instanceof Player) {
                removePlayer((Player) individual);
                JOptionPane.showMessageDialog(playerPanel, ((Player) individual).getName() + " deleted");
            } else if (individual instanceof Coach) {
                removeCoach((Coach) individual);
                JOptionPane.showMessageDialog(playerPanel, ((Coach) individual).getName() + " deleted");
            } else if (individual instanceof Referee) {
                removeReferee((Referee) individual);
                JOptionPane.showMessageDialog(playerPanel, ((Referee) individual).getName() + " deleted");
            }
        });

        panel.add(individualButton);
    }

    // Method to remove a player from the array
    private void removePlayer(Player player) {
        // Assuming 'players' is the ArrayList<Player> containing all players
        players.remove(player);
    }

    // Method to remove a coach from the array
    private void removeCoach(Coach coach) {
        // Assuming 'coaches' is the ArrayList<Coaches> containing all coaches
        coaches.remove(coach);
    }

    // Method to remove a referee from the array
    private void removeReferee(Referee referee) {
        // Assuming 'referees' is the ArrayList<Referee> containing all referees
        referees.remove(referee);
    }

    private void showDeleteTeamDialog() {
        JDialog dialog = new JDialog(frame, "Delete Team", true);
        dialog.setSize(1000, 300);
        dialog.setLayout(new GridLayout(3, 1));
        dialog.setLocationRelativeTo(null); // Center the frame
    
        // Create buttons for each team
        for (Team team : teams) {
            JButton teamButton = new JButton(team.getName());
            teamButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    // Remove the selected team from the array
                    removeTeam(team);
                    JOptionPane.showMessageDialog(frame, team.getName() + " deleted");
                    dialog.dispose(); // Close the dialog after deleting a team
                }
            });
    
            dialog.add(teamButton);
        }
    
        dialog.setVisible(true);
    }
    
    // Method to remove a team from the array
    private void removeTeam(Team team) {
        // Assuming 'teams' is the ArrayList<Team> containing all teams
        teams.remove(team);
    }

    public void showMatchRecorder() {
        JDialog dialog = new JDialog((Frame) null, "Match Recorder", true);
        dialog.setSize(900, 500);
        dialog.setLocationRelativeTo(null); // Center the frame
    
        // Input fields
        JFormattedTextField dateField = createDateField();
        JFormattedTextField scoreField = createScoreField();
        JComboBox<Team> homeTeamList = new JComboBox<>(new Vector<>(teams));
        JComboBox<Team> awayTeamList = new JComboBox<>(new Vector<>(teams));
        List<JComboBox<Player>> goalscorersLists = new ArrayList<>();
        List<JComboBox<Player>> substitutionsLists = new ArrayList<>();
        List<JComboBox<Player>> cardsLists = new ArrayList<>();
        List<JTextField> goalscorerTimes = new ArrayList<>();
        List<JTextField> substitutionTimes = new ArrayList<>();
        List<JTextField> cardTimes = new ArrayList<>();
    
        // Toggle buttons
        JButton addGoalscorerButton = new JButton("Add Goalscorer");
        JButton addSubstitutionButton = new JButton("Add Substitution");
        JButton addCardButton = new JButton("Add Yellow/Red Cards");
        JButton submitButton = new JButton("Submit Match");
    
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.PAGE_AXIS));

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
    
        panel.add(new JLabel("Date: "));
        panel.add(dateField);
        panel.add(new JLabel("Score: "));
        panel.add(scoreField);
        panel.add(new JLabel("Select Home Team: "));
        panel.add(homeTeamList);
        homeTeamList.setSelectedItem(0);
        panel.add(new JLabel("Select Away Team: "));
        panel.add(awayTeamList);
        awayTeamList.setSelectedIndex(1);

        // Create player selection panel
        panel.add(Box.createRigidArea(new Dimension(0, 20)));

        JPanel homePlayerSelectionPanel = createHomePlayerSelectionPanel(homeTeamList);
        panel.add(homePlayerSelectionPanel);

        panel.add(Box.createRigidArea(new Dimension(0, 20)));

        JPanel awayPlayerSelectionPanel = createAwayPlayerSelectionPanel(awayTeamList);
        panel.add(awayPlayerSelectionPanel);

        panel.add(Box.createRigidArea(new Dimension(0, 20)));

        // Button action listeners

        // In your ActionListener for home team selection
        homeTeamList.addActionListener(e -> {
            Team selectedHomeTeam = (Team) homeTeamList.getSelectedItem();
            if (selectedHomeTeam != null) {
                updatePlayerSelectionBoxes(homePlayerSelectionPanel, players, "4-3-3", homeSelectedPlayers, homeTeamList);
                updatePlayerComboBox(goalscorersLists, selectedHomeTeam.getAllPlayers());
                updatePlayerComboBox(substitutionsLists, selectedHomeTeam.getAllPlayers());
                updatePlayerComboBox(cardsLists, selectedHomeTeam.getAllPlayers());
            }
        });
        
        awayTeamList.addActionListener(e -> {
            Team selectedAwayTeam = (Team) awayTeamList.getSelectedItem();
            if (selectedAwayTeam != null) {
                updatePlayerSelectionBoxes(awayPlayerSelectionPanel, players, "4-3-3", awaySelectedPlayers, awayTeamList);
                updatePlayerComboBox(goalscorersLists, selectedAwayTeam.getAllPlayers());
                updatePlayerComboBox(substitutionsLists, selectedAwayTeam.getAllPlayers());
                updatePlayerComboBox(cardsLists, selectedAwayTeam.getAllPlayers());
            }
        });

        addGoalscorerButton.addActionListener(e -> {
            // Add goalscorer input box
            JComboBox<Player> goalscorersList = new JComboBox<>(new Vector<>(players));
            goalscorersLists.add(goalscorersList);
            panel.add(new JLabel("Goalscorer:"));
            panel.add(goalscorersList);

            // Add time input box for goalscorer
            JTextField timeField = new JTextField();
            goalscorerTimes.add(timeField);
            panel.add(new JLabel("Time:"));
            panel.add(timeField);

            dialog.revalidate();
            dialog.repaint();  

            // Automatically adjust the size of the window
            dialog.pack();
        });

        addSubstitutionButton.addActionListener(e -> {
            // Add substitution input box
            JComboBox<Player> substitutionsList = new JComboBox<>(new Vector<>(players));
            substitutionsLists.add(substitutionsList);
            panel.add(new JLabel("Substitution:"));
            panel.add(substitutionsList);
        
            // Add time input box for substitution
            JTextField timeField = new JTextField();
            substitutionTimes.add(timeField);
            panel.add(new JLabel("(On/Off) + Time:"));
            panel.add(timeField);
        
            dialog.revalidate();
            dialog.repaint();

            // Automatically adjust the size of the window
            dialog.pack();
        });

        addCardButton.addActionListener(e -> {
            // Add card input box
            JComboBox<Player> cardsList = new JComboBox<>(new Vector<>(players));
            cardsLists.add(cardsList);
            panel.add(new JLabel("Carded Player"));
            panel.add(cardsList);

            // Add time input box for card
            JTextField timeField = new JTextField();
            cardTimes.add(timeField);
            panel.add(new JLabel("Colour + Time:"));
            panel.add(timeField);

            dialog.revalidate();
            dialog.repaint();  

            // Automatically adjust the size of the window
            dialog.pack();
        });       

        // Submit button action listener
        submitButton.addActionListener(e -> {
            // Retrieve values from input fields
            String date = dateField.getText();
            String score = scoreField.getText();
            Team homeTeam = (Team) homeTeamList.getSelectedItem();
            Team awayTeam = (Team) awayTeamList.getSelectedItem();
            Map<String, Player> homeLineup = homeSelectedPlayers; // Assuming this is the home lineup
            Map<String, Player> awayLineup = awaySelectedPlayers; // You need to implement this based on your UI        
            // Create a list of goalscorers, substitutions, and cards with associated times
            List<MatchEvent> goalscorers = getMatchEvents(goalscorersLists, goalscorerTimes);
            List<MatchEvent> substitutions = getMatchEvents(substitutionsLists, substitutionTimes);
            List<MatchEvent> cards = getMatchEvents(cardsLists, cardTimes);

            // Create a new Match object
            Match match = new Match(date, score, homeTeam, awayTeam, homeLineup, awayLineup, goalscorers, substitutions, cards);

            // Print or store the match object as needed
            System.out.println("Match recorded: " + match);

            matches.add(match);

            // Close the dialog
            dialog.dispose();
    });

    // Add buttons to toggle visibility
    buttonPanel.add(addGoalscorerButton);
    buttonPanel.add(addSubstitutionButton);
    buttonPanel.add(addCardButton);
    buttonPanel.add(submitButton);
    panel.add(buttonPanel);

    dialog.add(panel);
    dialog.setVisible(true);
    
    }

    private JPanel createHomePlayerSelectionPanel(JComboBox<Team> teamComboBox) {
        JPanel homePlayerSelectionPanel = new JPanel(new GridLayout(3, 4));
    
        List<Player> players = getAllPlayers(); // Assume you have a method to create players
    
        // Create JComboBox for formations
        String[] formations = {"4-3-3", "4-4-2", "3-5-2"};
        JComboBox<String> formationComboBox = new JComboBox<>(formations);
    
        // Add listener to adjust player selection boxes based on the selected formation
        formationComboBox.addActionListener(e -> {
            String selectedFormation = (String) formationComboBox.getSelectedItem();
            updatePlayerSelectionBoxes(homePlayerSelectionPanel, players, selectedFormation, homeSelectedPlayers, teamComboBox);
        });
    
        homePlayerSelectionPanel.add(new JLabel("Home Formation:"));
        homePlayerSelectionPanel.add(formationComboBox);
    
        // Initially, use the first formation in the JComboBox
        updatePlayerSelectionBoxes(homePlayerSelectionPanel, players, "4-3-3", homeSelectedPlayers, teamComboBox);
    
        return homePlayerSelectionPanel;
    }

    private JPanel createAwayPlayerSelectionPanel(JComboBox<Team> teamComboBox) {
        JPanel awayPlayerSelectionPanel = new JPanel(new GridLayout(3, 4));

        List<Player> players = getAllPlayers(); // Assume you have a method to create players

        // Create JComboBox for formations
        String[] formations = {"4-3-3", "4-4-2", "3-5-2"};
        JComboBox<String> formationComboBox = new JComboBox<>(formations);

        // Add listener to adjust player selection boxes based on the selected formation
        formationComboBox.addActionListener(e -> {
            String selectedFormation = (String) formationComboBox.getSelectedItem();
            updatePlayerSelectionBoxes(awayPlayerSelectionPanel, players, selectedFormation, awaySelectedPlayers, teamComboBox);
        });

        awayPlayerSelectionPanel.add(new JLabel("Away Formation:"));
        awayPlayerSelectionPanel.add(formationComboBox);

        // Initially, use the first formation in the JComboBox
        updatePlayerSelectionBoxes(awayPlayerSelectionPanel, players, "4-3-3", awaySelectedPlayers, teamComboBox);

        return awayPlayerSelectionPanel;
    }

    private void updatePlayerSelectionBoxes(JPanel panel, List<Player> players, String formation, Map<String, Player> selectedPlayers, JComboBox<Team> teamComboBox) {
        // Remove all existing components except the formation combo box and team combo box
        Component[] components = panel.getComponents();
        for (int i = 2; i < components.length; i++) {
            panel.remove(components[i]);
        }
    
        // Get the selected team
        Team selectedTeam = (Team) teamComboBox.getSelectedItem();
    
        if (selectedTeam != null) {
            List<Player> teamPlayers = selectedTeam.getAllPlayers();
    
            // Create JComboBox for each position based on the selected formation and team
            String[] positions = getPositionsForFormation(formation);
            for (String position : positions) {
                JComboBox<Player> playerComboBox = new JComboBox<>(teamPlayers.toArray(new Player[0]));
    
                // Add an ActionListener to capture the selected player for each position
                playerComboBox.addActionListener(e -> {
                    Player selectedPlayer = (Player) playerComboBox.getSelectedItem();
                    if (selectedPlayer != null) {
                        // Store the selected player for the corresponding position
                        selectedPlayers.put(position, selectedPlayer);
                    }
                });
    
                panel.add(new JLabel(position));
                panel.add(playerComboBox);
            }
        }
    
        // Revalidate and repaint the panel
        panel.revalidate();
        panel.repaint();
    }

    private void updatePlayerComboBox(List<JComboBox<Player>> playerComboBoxes, List<Player> teamPlayers) {
        for (JComboBox<Player> comboBox : playerComboBoxes) {
            DefaultComboBoxModel<Player> model = new DefaultComboBoxModel<>(teamPlayers.toArray(new Player[0]));
            comboBox.setModel(model);
        }
    }

    private String[] getPositionsForFormation(String formation) {
        switch (formation) {
            case "4-3-3":
                return new String[]{"GK", "RB", "CB1", "CB2", "LB", "CM1", "CM2", "CM3", "RW", "ST", "LW"};
            case "4-4-2":
                return new String[]{"GK", "RB", "CB1", "CB2", "LB", "RM", "CM1", "CM2", "LM", "ST1", "ST2"};
            case "3-5-2":
                return new String[]{"GK", "CB1", "CB2", "CB3", "RM", "CM1", "CM2", "CM3", "LM", "ST1", "ST2"};
            default:
                return new String[]{};
        }
    }

    private JFormattedTextField createDateField() {
        try {
            MaskFormatter formatter = new MaskFormatter("##/##/####");
            JFormattedTextField dateField = new JFormattedTextField(formatter);
            dateField.setColumns(10);
            return dateField;
        } catch (ParseException e) {
            e.printStackTrace(); // Handle the exception appropriately
            return new JFormattedTextField(); // Return a default field if an exception occurs
        }
    }

    private JFormattedTextField createScoreField() {
        try {
            MaskFormatter formatter = new MaskFormatter("##-##");
            JFormattedTextField scoreField = new JFormattedTextField(formatter);
            scoreField.setColumns(10);
            return scoreField;
        } catch (ParseException e) {
            e.printStackTrace(); // Handle the exception appropriately
            return new JFormattedTextField(); // Return a default field if an exception occurs
        }
    }

    private List<MatchEvent> getMatchEvents(List<JComboBox<Player>> playerLists, List<JTextField> timeFields) {
    List<MatchEvent> matchEvents = new ArrayList<>();
    for (int i = 0; i < playerLists.size(); i++) {
        Player player = (Player) playerLists.get(i).getSelectedItem();
        String time = timeFields.get(i).getText();
        matchEvents.add(new MatchEvent(player, time));
    }
    return matchEvents;
    }

    private void showMatchViewer() {
        JFrame matchViewerFrame = new JFrame("Match Viewer");
        matchViewerFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        matchViewerFrame.setSize(400, 300);
        matchViewerFrame.setLayout(new FlowLayout());
        matchViewerFrame.setLocationRelativeTo(null); // Center the frame

        // Create buttons for each team
        for (Match match : matches) {
            JButton matchButton = new JButton(match.getDate());
            matchButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    // Call method for displaying the team details
                    match.displayMatchDetailsInDialog(homeSelectedPlayers, awaySelectedPlayers);
                }
            });

            matchViewerFrame.add(matchButton);
        }

        matchViewerFrame.setVisible(true);
    }

    private void showLeagueTable() {
        JFrame frame = new JFrame("League Table");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(600, 400);
        frame.setLocationRelativeTo(null); // Center the frame

        JTable table = createLeagueTable();
        JScrollPane scrollPane = new JScrollPane(table);

        frame.add(scrollPane, BorderLayout.CENTER);
        frame.setVisible(true);
    }

    private JTable createLeagueTable() {
        String[] columnNames = {"Team", "Points"};
    
        Object[][] data = new Object[teams.size()][columnNames.length];
    
        for (int i = 0; i < teams.size(); i++) {
            Team team = teams.get(i);
            data[i][0] = team.getName();
            data[i][1] = team.getPoints();
        }
    
        DefaultTableModel model = new DefaultTableModel(data, columnNames) {
            /**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			@Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
    
            // Override the getColumnClass method to specify the data type for sorting
            @Override
            public Class<?> getColumnClass(int columnIndex) {
                return (columnIndex == 1) ? Integer.class : Object.class;
            }
        };
    
        JTable table = new JTable(model);
    
        // Create a TableRowSorter to sort the table by the "Points" column
        TableRowSorter<TableModel> sorter = new TableRowSorter<>(model);
        table.setRowSorter(sorter);
    
        // Specify the column to be sorted (column index 1, which is the "Points" column)
        List<RowSorter.SortKey> sortKeys = new ArrayList<>();
        sortKeys.add(new RowSorter.SortKey(1, SortOrder.DESCENDING));
        sorter.setSortKeys(sortKeys);
        sorter.sort();
    
        return table;
    }
}
