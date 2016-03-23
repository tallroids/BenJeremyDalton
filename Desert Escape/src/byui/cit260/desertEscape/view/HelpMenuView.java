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
public class HelpMenuView extends View {
   
    public HelpMenuView() {
        super("\n"
                + "\n*** Help Menu***"
                + "\nG - What is the goal of the game?"
                + "\nC - What are the controls?"
                + "\nP - How do I solve puzzles?"
                + "\nQ - Quit");
    }

    @Override
    public boolean doAction(String choice) {
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
                this.console.println("\n*** Please try again ***");
                break;
                
        }
        return false;
    
}

    private void gameGoal() {
        this.console.println("\n"
                + "\nDesert Escape is a game where you try to solve"
                + "\npuzzles in order to escape the desert wasteland");
    }

    private void gameControls() {
        this.console.println("\n"
                + "\nFuture Description of Game Controls");    
    }

    private void solvingPuzzles() {
        this.console.println("\n"
                + "\nPuzzles are solved using math and wit. Look for clues"
                + "\nwherever you go, and get ready to solve problems!");    
    }

    
}
