public class MatchEvent {

    // Attributes
    private Player player;
    private String time;
    
    // Constructor
    public MatchEvent(Player player, String time) {
        this.player = player;
        this.time = time;
    }

    // Methods
    public String getTime() {
        return time;
    }

    public Player getPlayer() {
        return player;
    }
}
