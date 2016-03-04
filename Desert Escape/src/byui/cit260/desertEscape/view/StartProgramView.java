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
public class StartProgramView {
    
    private String promptMessage;
    public StartProgramView() {
        this.promptMessage = "\nPlease enter your name: ";
        
        this.displayBanner();
    }

    private void displayBanner() {
        System.out.println(
        "\n\nWelcome to this game of escaping an alien desert!"
        );
    }
  //displays the start program view
    public void displayStartProgramView() {
      boolean done = false;
      do{
      String playersName = this.getPlayersName();
      if (playersName.toUpperCase().equals("Q"))
          return; //quit after user inputs quit command
      done = this.doAction(playersName);
      } while (!done);
           
    }

    private String getPlayersName() {
        Scanner keyboard = new Scanner(System.in); 
        String value = ""; //return value
        boolean valid = false;
        
        while (!valid) { //loops until a valid input is entered
            System.out.println("\n" + this.promptMessage);
            
            value = keyboard.nextLine();
            value = value.trim(); // trims blanks at ends after getting line entered
            
            if (value.length() < 1) { // blank input
                System.out.println("\nInvalid value: Name cannot be blank");
                continue;
            }
            break;
        }
        return value;
    }

    private boolean doAction(String playersName) {
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
