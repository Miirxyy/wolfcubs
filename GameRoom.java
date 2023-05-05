import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class GameRoom {
    
    public void assignRole(List<Player> players) {

        // Create a list of available type of villagers to be assign at random
        List<Role> roles = new ArrayList<>();
        roles.add(new Werewolf());
        roles.add(new Werewolf());
        roles.add(new Seer());
        roles.add(new Doctor());
        roles.add(Villager.createVillagers().get(0));
        roles.add(Villager.createVillagers().get(1));
        roles.add(Villager.createVillagers().get(2));
        
        Random random = new Random();
        
        for (int i = 1; i < players.size(); i++) {
            
            int index = random.nextInt(roles.size());
            
            // Remove the role of the chosen index from the list
            Role assignRole = roles.remove(index);
            
            players.get(i).setRole(assignRole);
            
        }
    }    
}
