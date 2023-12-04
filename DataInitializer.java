import java.util.ArrayList;

public class DataInitializer {

    public static void initializeTeamsAndPlayers(ArrayList<Team> teams, ArrayList<Player> players) {
        initializePlayers(players);
        initializeTeams(teams, players);
    }

    private static void initializePlayers(ArrayList<Player> players) {
        // Your player initialization logic here
        players.add(new Player("", 0, "", "", "", ""));
        players.add(new Player("Liam Johnson", 25, "£500", "Part-Time", "GK", "4-3-3"));
        players.add(new Player("Noah Williams", 37, "£750", "Full-Time", "GK", "4-4-2"));
        players.add(new Player("Elijah Brown", 27, "£250", "Full-Time", "CB", "4-4-2"));
        players.add(new Player("James Davis", 29, "£300", "On Loan", "CB", "4-4-2"));
        players.add(new Player("Benjamin Garcia", 30, "£200", "Part-Time", "CB", "4-3-3"));
        players.add(new Player("Samuel Martinez", 25, "£300", "Full-Time", "CB", "4-4-2"));
        players.add(new Player("Daniel Robinson", 24, "£450", "Full-Time", "LB", "4-4-2"));
        players.add(new Player("Matthew Rodriguez", 26, "£1000", "On Loan", "LB", "4-4-2"));
        players.add(new Player("Jackson Smith", 30, "£700", "Full-Time", "RB", "4-3-3"));
        players.add(new Player("Alexander Taylor", 24, "£800", "Full-Time", "RB", "4-4-2"));
        players.add(new Player("Henry Thomas", 28, "£500", "Full-Time", "CM", "4-4-2"));
        players.add(new Player("Sebastian Anderson", 26, "£350", "Full-Time", "CM", "4-4-2"));
        players.add(new Player("Owen Wilson", 25, "£500", "Part-Time", "CM", "4-3-3"));
        players.add(new Player("Jack Moore", 37, "£750", "Full-Time", "CM", "4-4-2"));
        players.add(new Player("Aiden White", 27, "£250", "Full-Time", "CM", "4-4-2"));
        players.add(new Player("Lucas Harris", 29, "£300", "On Loan", "CM", "4-4-2"));
        players.add(new Player("Carter Jackson", 30, "£200", "Part-Time", "LM/LW", "4-3-3"));
        players.add(new Player("Isaac Thompson", 25, "£300", "Full-Time", "LM/LW", "4-4-2"));
        players.add(new Player("Wyatt Clark", 24, "£450", "Full-Time", "RM/RW", "4-4-2"));
        players.add(new Player("Leo Lewis", 26, "£1000", "On Loan", "RM/RW", "4-4-2"));
        players.add(new Player("John Smith", 30, "£700", "Full-Time", "ST", "4-3-3"));
        players.add(new Player("Bob Barren", 24, "£800", "Full-Time", "ST", "4-4-2"));
    }

    private static void initializeTeams(ArrayList<Team> teams, ArrayList<Player> players) {
        // Your team initialization logic here
        Team burscoughBayonets = new Team("Burscough Bayonets", "Burscough", "80", new ArrayList<>(), 21);
        Team aughtonAlchemists = new Team("Aughton Alchemists", "Aughton", "120", new ArrayList<>(), 9);
        Team ruffordRavens = new Team("Rufford Ravens", "Rufford", "60", new ArrayList<>(), 12);
        Team scarisbrickSpartans = new Team("Scarisbrick Spartans", "Scarisbrick", "40", new ArrayList<>(), 32);
        Team halsallHurricanes = new Team("Halsall Hurricanes", "Halsall", "80", new ArrayList<>(), 15);
        Team lathomLynxes = new Team("Lathom Lynxes", "Lathom", "150", new ArrayList<>(), 18);
        Team ainsdaleAviators = new Team("Ainsdale Aviators", "Ainsdale", "200", new ArrayList<>(), 12);
        Team holmeswoodHornets = new Team("Holmeswood Hornets", "Holmeswood", "40", new ArrayList<>(), 9);
        Team mawdesleyMagicians = new Team("Mawdesley Magicians", "Mawdesley", "50", new ArrayList<>(), 15);
        Team westheadWanderers = new Team("Westhead Wanderers", "Westhead", "100", new ArrayList<>(), 9);
        Team newburghNomads = new Team("Newburgh Nomads", "Newburgh", "60", new ArrayList<>(), 12);
        Team downhollandDragons = new Team("Downholland Dragons", "Downholland", "90", new ArrayList<>(), 37);
        Team orrelOwls = new Team("Orrel Owls", "Orrel", "140", new ArrayList<>(), 15);
        Team townGreenGladiators = new Team("Town Green Gladiators", "Town Green", "30", new ArrayList<>(), 18);
        Team bickerstaffeBuccaneers = new Team("Bickerstaffe Buccaneers", "Bickerstaffe", "130", new ArrayList<>(), 8);
        // Add teams to teams array
        teams.add(burscoughBayonets);
        teams.add(aughtonAlchemists);
        teams.add(ruffordRavens);
        teams.add(scarisbrickSpartans);
        teams.add(halsallHurricanes);
        teams.add(lathomLynxes);
        teams.add(ainsdaleAviators);
        teams.add(holmeswoodHornets);
        teams.add(mawdesleyMagicians);
        teams.add(westheadWanderers);
        teams.add(newburghNomads);
        teams.add(downhollandDragons);
        teams.add(orrelOwls);
        teams.add(townGreenGladiators);
        teams.add(bickerstaffeBuccaneers);
        // Get the player
        Player playerPlaceholder = players.get(0);
        Player liamJohnson = players.get(1);
        Player noahWilliams = players.get(2);
        Player elijahBrown  = players.get(3);
        Player jamesDavis = players.get(4);
        Player benjaminGarcia = players.get(5);
        Player samuelMartinez = players.get(6);
        Player danielRobinson = players.get(7);
        Player matthewRodriguez = players.get(8);
        Player jacksonSmith = players.get(9);
        Player alexanderTaylor = players.get(10);
        Player henryThomas = players.get(11);
        Player sebastianAnderson = players.get(12);
        Player owenWilson = players.get(13);
        Player jackMoore = players.get(14);
        Player aidenWhite = players.get(15);
        Player lucasHarris = players.get(16);
        Player carterJackson = players.get(17);
        Player isaacThompson = players.get(18);
        Player wyattClark = players.get(19);
        Player leoLewis = players.get(20);
        Player johnSmith = players.get(21);
        Player bobBarren = players.get(22);
        // ... and add them to the team
        // Burscough players (11)
        burscoughBayonets.addPlayer(playerPlaceholder);
        burscoughBayonets.addPlayer(liamJohnson);
        burscoughBayonets.addPlayer(elijahBrown);
        burscoughBayonets.addPlayer(benjaminGarcia);
        burscoughBayonets.addPlayer(danielRobinson);
        burscoughBayonets.addPlayer(jacksonSmith);
        burscoughBayonets.addPlayer(henryThomas);
        burscoughBayonets.addPlayer(owenWilson);
        burscoughBayonets.addPlayer(aidenWhite);
        burscoughBayonets.addPlayer(carterJackson);
        burscoughBayonets.addPlayer(wyattClark);
        burscoughBayonets.addPlayer(johnSmith);
        // Aughton players (11)
        aughtonAlchemists.addPlayer(playerPlaceholder);
        aughtonAlchemists.addPlayer(noahWilliams);
        aughtonAlchemists.addPlayer(jamesDavis);
        aughtonAlchemists.addPlayer(samuelMartinez);
        aughtonAlchemists.addPlayer(matthewRodriguez);
        aughtonAlchemists.addPlayer(alexanderTaylor);
        aughtonAlchemists.addPlayer(sebastianAnderson);
        aughtonAlchemists.addPlayer(jackMoore);
        aughtonAlchemists.addPlayer(lucasHarris);
        aughtonAlchemists.addPlayer(isaacThompson);
        aughtonAlchemists.addPlayer(leoLewis);
        aughtonAlchemists.addPlayer(bobBarren);
        // Adding blanks to each team for aesthetic purposes


    }
}