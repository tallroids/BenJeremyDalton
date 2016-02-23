/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.desertEscape.control;

import byui.cit260.desertEscape.model.Player;
import desert.escape.DesertEscape;

/**
 *
 * @author Jeremy
 */
public class GameControl {

    public static Player createPlayer(String name) {
        if(name == null) {
            return null;
        }
        
        Player player = new Player();
        player.setName(name);
        
        DesertEscape.setPlayer(player); // saves the player
        
        return player;
    }

    public static void createNewGame(Player player) {
        System.out.println("createNewGame function called");
    }

    public static void resumeGame(Player player) {
        System.out.println("resumeGame function called");
    }

    public static void saveGame(Player player) {
        System.out.println("saveGame function called");
    }
    
}
