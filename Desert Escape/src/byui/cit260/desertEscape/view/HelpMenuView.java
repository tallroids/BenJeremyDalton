/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.desertEscape.view;

import java.util.Scanner;

/**
 *
 * @author tallroids
 */
public class HelpMenuView {
    private String menu;
    public HelpMenuView() {
        this.menu = "\n"
                + "\n*** Help Menu***"
                + "\nG - What is the goal of the game?"
                + "\nC - What are the controls?"
                + "\nP - How do I solve puzzles?"
                + "\nQ - Quit";
    }

    void displayMenu() {
        
        
        boolean done = false;
        do {
            String menuOption = this.getMenuOption();
            if (menuOption.toUpperCase().equals("Q"))
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
            case "G":
                this.gameGoal();
                break;
            case "C":
                this.gameControls();
                break;
            case "P":
                this.solvingPuzzles();
                break;
            default:
                System.out.println("\n*** Please try again ***");
                break;
                
        }
        return false;
    
}

    private void gameGoal() {
        System.out.println("\n"
                + "\nDesert Escape is a game where you try to solve"
                + "\npuzzles in order to escape the desert wasteland");
    }

    private void gameControls() {
        System.out.println("\n"
                + "\nFuture Description of Game Controls");    
    }

    private void solvingPuzzles() {
        System.out.println("\n"
                + "\nPuzzles are solved using math and wit. Look for clues"
                + "\nwherever you go, and get ready to solve problems!");    
    }

    
}
