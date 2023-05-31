/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package warewolfculb;

/**
 *
 * @author HP
 */
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class GameRoom {
    private List<Player> players;
    
    public void assignRole(List<Player> players) {

        // Create a list of available role to be assign at random for each player
        List<Role> roles = new ArrayList<>();
        roles.add(new Werewolf());
        roles.add(new Werewolf());
        roles.add(new Seer());
        roles.add(new Doctor());
        roles.add(Villager.createVillagers().get(0));
        roles.add(Villager.createVillagers().get(1));
        roles.add(Villager.createVillagers().get(2));
        
        Random random = new Random();
        
        // Iterate the list of players to assign role
        for (int i = 0; i < players.size(); i++) {
            
            int index = random.nextInt(roles.size());
            
            // Remove the role of the chosen index from the list
            Role assignRole = roles.remove(index);
            
            // Assign role to players 
            players.get(i).setRole(assignRole);
            
        }

    }
}