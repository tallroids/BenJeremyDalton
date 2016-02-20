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
public class MainMenuView {
    private String menu;

    public MainMenuView() {
        this.menu = "\n"
                +"\n| Main Menu         |"
                + "\n--------------------"
                + "\nN - New Game"
                + "\nG - Resume"
                + "\nH - Help"
                + "\nS - Save"
                + "\nQ - Quit"
                + "\n--------------------";
    }
    
    public void displayMainMenuView() {
        boolean done = false;
        do {
            String menuOption = this.getMenuOption();
            if (menuOption.toUpperCase().equals('Q'))
                return;
            
            done = this.doAction(menuOption);
        } while (!done);
    }

    private String getMenuOption() {
        Scanner keyboard = new Scanner(System.in); 
        String value = ""; //return value
        boolean valid = false;
        
        while (!valid) { //loops until a valid input is entered
            System.out.println("\n" + this.menu);
            
            value = keyboard.nextLine();
            value = value.trim(); // trims blanks at ends after getting line entered
            
            if (value.length() < 1) { // blank input
                System.out.println("\nInvalid value: No menu item selected");
                continue;
            }
            break;
        }
        return value;    
    }

    private boolean doAction(String choice) {
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
        
        return false;
    }

    private void startNewGame() {
        GameControl.createNewGame(DesertEscape.getPlayer());
        
        GameMenuView gameMenu = new GameMenuView();
        gameMenu.displayMenu();
    }

    private void startExistingGame() {
        System.out.println("startExistingGame funtion called");
    }

    private void saveGame() {
        System.out.println("saveGame funtion called");
    }

    private void displayHelpMenu() {
        System.out.println("displayHelpMenu funtion called");
    }

    
}
