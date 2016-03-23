/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.desertEscape.view;

import byui.cit260.desertEscape.control.GameControl;
import byui.cit260.desertEscape.exeptions.GameControlException;
import byui.cit260.desertEscape.model.Player;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Jeremy
 */
public class StartProgramView extends View {
    
    
    public StartProgramView() {
        super("\nWelcome to this game of escaping an alien desert!"
             +"\nPlease enter your name: ");
        
   
    }

   
    @Override
    public boolean doAction(String playersName) {
        if(playersName.length() < 2) {
            this.console.println("\nInvalid Name: The name must be longer than one character");
            return false;
        }
        Player player;
        try {
            player = GameControl.createPlayer(playersName);
            this.displayNextView(player);
        } catch (GameControlException ex) {
            ErrorView.display(this.getClass().getName(),"Could not create player" + ex.getMessage());
        }
               
        return true;
    }

    private void displayNextView(Player player) {
        this.console.println("\n Welcome to the game " + player.getName()
        + "\n We hope you have fun!");
        
        MainMenuView mainMenuView = new MainMenuView();
        
        mainMenuView.display();
       
    }

    
        
}
