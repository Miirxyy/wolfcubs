package Werewolf;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class GameRoom {
    private String roomID;
    private boolean isFull;
    private int numDay;
    private Timer time;
    private List<Player> players;
    private List<Role> roles;
    private Timer discussionTimer;

    public GameRoom(String roomID, Timer time, List<Player>players, List<Role>roles) {
        this.roomID = roomID;
        this.isFull = false;
        this.numDay = 0;
        this.time = time;
        this.players = players;
        this.roles = roles;
    }

    public String getRoomID() {
        return roomID;
    }

    public boolean isFull() {
        return isFull;
    }

    public int getNumDay() {
        return numDay;
    }

    public Timer getTime() {
        return time;
    }

    public List<Player> getPlayers() {
        return players;
    }

    public void addPlayer(Player player) {
        players.add(player);
    }

    public void removePlayer(Player player) {
        players.remove(player);
    }

    public void startGame() {
        System.out.println("Game started!");
        this.time.start();
        numDay++;
        assignPlayerRoles(this.players, this.roles);
    }

    public void assignPlayerRoles(List<Player> players, List<Role> role) {
        Random rand = new Random();
        for(int i=0; i<players.size(); i++){
            int role_index = rand.nextInt(roles.size());
            players.get(i).setPlayerRole(role.get(role_index));
            roles.remove(role_index);
        }
    }

    public void endGame() {
        // Logic to end the game
        // This method will be responsible for resetting the game state, clearing player data, etc.
    }

    public void dayPhase() {
        System.out.println("Day phase begins...");

        // Start the discussion timer for 30 seconds
        discussionTimer = new Timer(30000);
        discussionTimer.start();

        // Wait for the discussion timer to complete
        while (!discussionTimer.isExpired()) {
            // Allow players to discuss
        }

        System.out.println("Discussion time is over!");
        //voting phase
    }

    public void nightPhase() {
        // Logic for the night phase of the game
        // This method will handle the actions and events that occur during the night phase of the game
    }

    public boolean isLocked() {
        if (this.players.size() == 7)
            return true;
        return false;
    }

    public String roomStatus() {
        // Return the status of the game room
        // This method can be used to retrieve information about the current status of the game room
        // You can return a string containing relevant details such as room ID, number of players, game phase, etc.
        // Customize the implementation based on your specific needs
        return "";
    }
}
