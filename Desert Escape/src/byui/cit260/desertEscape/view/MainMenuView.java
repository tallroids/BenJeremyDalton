/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.desertEscape.view;

import byui.cit260.desertEscape.control.GameControl;
import desert.escape.DesertEscape;
import java.util.Scanner;

/**
 *
 * @author Jeremy
 */
public class MainMenuView extends View {
 //deleted menu variable
    public MainMenuView() {
          super("\n"
                +"\n| Main Menu         |"
                + "\n--------------------"
                + "\nN - New Game"
                + "\nG - Resume"
                + "\nH - Help"
                + "\nS - Save"
                + "\nQ - Quit"
                + "\n--------------------");
    }
    
   //deleted display function

//deleted getInput function

    @Override
    public boolean doAction(String choice) {
        choice = choice.toUpperCase();
        switch (choice) {
            case "N":
                this.startNewGame();
                break;
            case "G":
                this.startExistingGame();
                break;
            case "S":
                this.saveGame();
                break;
            case "H":
                this.displayHelpMenu();
                break;
            default:
                System.out.println("\n*** Please try again ***");
                break;
                
        }
        return false; //different than instructions!!! false repeats menu
        
    }

    private void startNewGame() {
        GameControl.createNewGame(DesertEscape.getPlayer());
        
        GameMenuView gameMenu = new GameMenuView();
        gameMenu.display();
    }

    private void startExistingGame() {
        GameControl.resumeGame(DesertEscape.getPlayer());
        
        GameMenuView gameMenu = new GameMenuView(); //not sure what this should be
        gameMenu.display();
}

    private void saveGame() {
        GameControl.saveGame(DesertEscape.getPlayer());
        
        SaveMenuView saveMenu = new SaveMenuView();
        saveMenu.displayMenu();
    }

    private void displayHelpMenu() {
      
        HelpMenuView helpMenuView = new HelpMenuView();
        helpMenuView.display();
    }

    
}
