import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Player {
    
    private String playerID;
    private String name;
    private Role role;
    private boolean isEliminated;
    private boolean isProtected;
    private List<Player> votes;

    public Player(String playerID, String name) {
        this.playerID = playerID;
        this.name = name;
        this.isEliminated = false;
        this.isProtected = false;
        this.votes = new ArrayList<>();
    }
    
    public void assignRole(Role[] roles) {
        
        Random random = new Random();
        int index = random.nextInt(roles.length);
        this.role = roles[index];
        this.role.setPlayer(this);
        
    }
    
    public void vote(Player player) {
        this.votes.add(player);
        
    }
    
    public List<Player> getVotes() {
        return this.votes;
    }

    
}