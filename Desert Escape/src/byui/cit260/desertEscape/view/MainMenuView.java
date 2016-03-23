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
                ErrorView.display(this.getClass().getName(),"\n*** Please try again ***");
                break;
                
        }
        return false; 
        
    }

    private void startNewGame() {
        GameControl.createNewGame(DesertEscape.getPlayer());
        
        GameMenuView gameMenu = new GameMenuView();
        gameMenu.display();
    }

    private void startExistingGame() {
        console.println("Enter your game's name: ");
        try{
            String fileName = keyboard.readLine();
            GameControl.resumeGame(fileName);
        
        GameMenuView gameMenu = new GameMenuView(); 
        gameMenu.display();
        } catch (Exception e) {
            ErrorView.display(this.getClass().getName(), "Error loading game");
        }
}

    private void saveGame() {
        console.println("Please name your game: ");
        try{
            String fileName = keyboard.readLine();
            GameControl.saveGame(fileName);
        }catch(Exception e){
            ErrorView.display(this.getClass().getName(), "Error reading Game");
        }
      
    }

    private void displayHelpMenu() {
      
        HelpMenuView helpMenuView = new HelpMenuView();
        helpMenuView.display();
    }

    
}
