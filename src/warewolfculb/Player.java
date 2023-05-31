/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package warewolfculb;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/**
 *
 * @author HP
 */
public class Player {
    private String playerID;
    private String name;
    private Role role;
    private boolean eliminated;
    private boolean protecteD;
    private List<Player> votes;

    // Constructor for player class
    public Player(String playerID, String name) {
        
        this.playerID = playerID;
        this.name = name;
        this.eliminated = false;
        this.protecteD = false;
        this.votes = new ArrayList<>();
        
    }
    
    public Player(Role role) {
        this.role = role;
    }
    
    // Allow players to vote for a specific player to eliminate
    public void vote(Player player) {
        
        this.votes.add(player);
        
    }
    
    // Get the name of player with the most vote
    public Player getMostVotedPlayer() {
        
        Map<Player, Integer> voteCounts = new HashMap<>();

        // Count the number of votes for each player
        // Interate through vote list to count the number of vote for each player 
        for (Player player : votes) {
            int voteSum = voteCounts.getOrDefault(player, 0);
            voteCounts.put(player, voteSum + 1);
        }

        // Find the player with the most votes
        Player mostVotedPlayer = null;
        int maxVotes = 0;
        for (Map.Entry<Player, Integer> entry : voteCounts.entrySet()) {
            if (entry.getValue() > maxVotes) {
                mostVotedPlayer = entry.getKey();
                maxVotes = entry.getValue();
            }
        }
        
        mostVotedPlayer.setEliminated(true);
        
        // Eliminate the player that has the most vote 
        return mostVotedPlayer;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    // PlayerID getter 
    public String getPlayerID() {
        return playerID;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    
    // Get the role of the players 
    public Role getRole() {
        return role;
    }

    public boolean isEliminated() {
        return eliminated;
    }

    public void setEliminated(boolean eliminated) {
        this.eliminated = eliminated;
    }

    public boolean isProtected() {
        return protecteD;
    }

    public void setProtected(boolean protecteD) {
        this.protecteD = protecteD;
    }
}