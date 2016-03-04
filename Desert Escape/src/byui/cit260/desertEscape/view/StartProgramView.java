/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.desertEscape.view;

import byui.cit260.desertEscape.control.GameControl;
import byui.cit260.desertEscape.model.Player;
import java.util.Scanner;

/**
 *
 * @author Jeremy
 */
public class StartProgramView extends View {
    
    
    public StartProgramView() {
        super("\nWelcome to this game of escaping an alien desert!"
             +"\n\nPlease enter your name: ");
        
   
    }

   
    @Override
    public boolean doAction(String playersName) {
        if(playersName.length() < 2) {
            System.out.println("\nInvalid Name: The name must be longer than one character");
            return false;
        }
        Player player = GameControl.createPlayer(playersName);
        
        if (player == null) { // unsuccessful creation of player
            System.out.println("\nError creating the player.");
            return false;
        }
        this.displayNextView(player);
        
        return true;
    }

    private void displayNextView(Player player) {
        System.out.println("\n Welcome to the game " + player.getName()
        + "\n We hope you have fun!");
        
        MainMenuView mainMenuView = new MainMenuView();
        
        mainMenuView.display();
       
    }

    
        
}
