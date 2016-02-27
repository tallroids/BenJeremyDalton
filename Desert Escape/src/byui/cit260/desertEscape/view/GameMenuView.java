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
class GameMenuView {

    
    private String menu;
    public GameMenuView() {
        this.menu = "\n"
                + "\n*** Game Menu***"
                + "\nC - Continue?"
                + "\nI - Check Inventory"
                + "\nS - View character stats?"
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
            case "C":
                this.continueGame();
                break;
            case "I":
                this.checkInventory();
                break;
            case "S":
                this.characterStats();
                break;
            default:
                System.out.println("\n*** Please try again ***");
                break;
                
        }
        return false;
    
}

    private void continueGame() {
        System.out.println("continueGame function called");
        PrologueSceneView prologueSceneView = new PrologueSceneView();
        prologueSceneView.displayScene();
    }

    private void checkInventory() {
        System.out.println("checkInventory function called");
}

    private void characterStats() {
        System.out.println("characterStats function called");
}
    
}
