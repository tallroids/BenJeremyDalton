/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.desertEscape.view;

import byui.cit260.desertEscape.control.MapControl;
import byui.cit260.desertEscape.model.Player;
import desert.escape.DesertEscape;
import java.io.BufferedReader;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 *
 * @author daltonsolo
 */
public abstract class View implements ViewInterface {

    protected String displayMessage;

    protected final BufferedReader keyboard = DesertEscape.getInFile();
    protected final PrintWriter console = DesertEscape.getOutFile();

    public View() {
    }

    public View(String message) {
        this.displayMessage = message;
    }

    @Override
    public void display() {
        boolean done = false;
        do {
            String value = this.getInput();
            if (value.toUpperCase().equals("Q")) {
                return;
            }

            done = this.doAction(value);
        } while (!done);
    }

    @Override
    public String getInput() {
        boolean valid = false;
        String value = null; //return value

        while (!valid) { //loops until a valid input is entered
            console.println("\n" + this.displayMessage);
            try {
                value = keyboard.readLine();
            } catch (Exception e) {
                throw new RuntimeException("Error reading input" + e.getMessage());
            }
            value = value.trim(); // trims blanks at ends after getting line entered

            if (value.length() < 1) { // blank input
                ErrorView.display(this.getClass().getName(), "\nInvalid value: Please try again");
                continue;
            }
            break;
        }

        return value;
    }
    
    @Override
    public void unblockAndDisplayMenu(Player player) {
        this.console.println("displayGameMenu called");
        MapControl.unblockLocation(player.getCurrentLocation());
        MapControl.moveToNextLocation(player);
        GameMenuView nextView = new GameMenuView();
        nextView.display();
    }

}
