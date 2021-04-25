/**
 * Write a description of class Player here.
 *
 * @author (Anusha Hamy)
 * @version (version 1 or a 25/03/2021)
 */

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

public class AH_PlayerList
{
    // list of player objects
    private ArrayList<Player> playerList;
 
    /**
     * Constructor for objects of class Player
     */
    public AH_PlayerList() {
        // initialise the player list
        
        playerList = new ArrayList<>();
        
  
 
    }

    /**
     * Method to add a Player
     * @params name, password
     * @return none
     */
    public void add(String name, String password) {
        Player player = new Player(name, password);
        playerList.add(player);
    }

    /**
     * Method to sort PlayerList
     * @params direction (A - Acsending order, D - Descending order)
     * @return none
     */
    public void sort(char direction) {
        //modify this method to makes it works as expected
        if(direction == 'A')
          Collections.sort(playerList);
        
        else
        if(direction == 'D')
          Collections.sort(playerList, Collections.reverseOrder());
    }
    
    public boolean matchPlayer(String name, String password) {
        boolean match = false;

        for (int i = 0; i < playerList.size(); i++) {
            Player p = playerList.get(i);
            if ((p.name.compareTo(name) == 0) && (p.password.compareTo(password) == 0)) {
                match = true;
                break; //a new command to break a loop
            }
        }
        
        return match;
        
    }
    
    /**
     * Method to convert the PlayerList to a string
     * @params none
     * @return none
     */
    @Override
    public String toString() {
        //modify this method to makes it works as expected
        String s =  "";
        Iterator<Player> itera = playerList.iterator();
        while (itera.hasNext()){
           Player p = itera.next();
           
           s =s + p.toString() + "\n";
        }
        return s;
    }
    
    /**
     * This private class for storing player's details 
     */
    class Player implements Comparable<Player> {
        public String name;
        public String password;
        
        public Player(String name, String password) {
            this.name = name;
            this.password = password;
        }
        
        @Override
        public String toString() {
            return name + "[pass=" + password + "]";
        }
 
        @Override
        public int compareTo(Player p) {
            return this.name.compareTo(p.name);
        }
    }

    /**
    */
   /*
    public static void main(String[] args) {
        AH_PlayerList playerList = new AH_PlayerList();

   
        //before sorting
        System.out.println("List before sorting: \n" + playerList);
        //sorting
        playerList.sort('D');
        //after sorting
        System.out.println("List after sorting: \n" + playerList);
    }
    */
}
