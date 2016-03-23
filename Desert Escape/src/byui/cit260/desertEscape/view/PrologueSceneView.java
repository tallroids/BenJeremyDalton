/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.desertEscape.view;

import byui.cit260.desertEscape.control.PlayerControl;
import byui.cit260.desertEscape.model.Location;
import byui.cit260.desertEscape.model.Player;
import byui.cit260.desertEscape.model.SceneType;
import desert.escape.DesertEscape;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author tallroids
 */
class PrologueSceneView {

    private String prologue;
    private String view;
    
    protected final BufferedReader keyboard = DesertEscape.getInFile();
    protected final PrintWriter console = DesertEscape.getOutFile();


    public PrologueSceneView() {
        this.prologue = "\n"
                + "\n*** Welcome to Desert Escape, " + DesertEscape.getPlayer().getName()
                + "\nTen years ago you would have never thought you would find"
                + "\nyourslef here. Alone, confused, and not that you would admit,"
                + "\nscared."
                + "\nBack on Earth things had completely fallen apart. You had"
                + "\nbarely managed to escape with your life, let alone a rig"
                + "\nthat would get you to a neighboring system. Such expeditions"
                + "\nhad been cut off years ago due to suspiscious lifeforms of "
                + "\nquestionable intelligence. Now, that intelligence is your "
                + "\nonly hope of survival."
                + "\nLucky for you, the automated flight controls had made the"
                + "\ntrip pretty simple. That doesn't make your surroundins any"
                + "\nless frightening. You found the suit that should prepare"
                + "\nyou for the surface conditions, it is asking for your height"
                + "\nand weight, seems simple enough....";
    }
    private String promptWeight(){
        this.view = "\n*** Enter your weight in pounds ***";
        return view;
    }
    private String promptHeight(){
        this.view = "\n*** Enter your height in inches ***";
        return view;
    }

    void displayScene() {
        this.console.println(this.prologue);
        boolean done = false;
        do {
            String input = this.getWeight();
            if (input.toUpperCase().equals("Q"))
                return;
            try {double weight = Double.parseDouble(input);
            done = this.saveWeight(weight);}
            catch (NumberFormatException nf) { ErrorView.display(this.getClass().getName(),"\nYou must enter a valid weight."
                                                                    + " Try again or enter 'Q' to quit."); }
        } while (!done);
        do {
            String input = this.getHeight();
            if (input.toUpperCase().equals("Q"))
                return;
            try {double height = Double.parseDouble(input);
            done = this.saveHeight(height);}
            catch (NumberFormatException nf) { ErrorView.display(this.getClass().getName(),"\nYou must enter a valid height."
                                                                    + " Try again or enter 'Q' to quit.");}
        } while (!done);
}
    private String getWeight() {
        
        String value = ""; //return value
        boolean valid = false;
        
        
        while (!valid) { //loops until a valid input is entered
            this.console.println(this.promptWeight());
            
            try {
                value = this.keyboard.readLine();
                value = value.trim(); // trims blanks at ends after getting line entered
            } catch (IOException ex) {
                ErrorView.display(this.getClass().getName(),"error getting input");
            }
            
            
            if (value.length() < 1) { // blank input
                ErrorView.display(this.getClass().getName(),"\nInvalid value: Enter a valid weight");
                continue;
            }
            break;
        }
        return value;    
    }
    private boolean saveWeight(Double weight) {
        if (weight<20 || weight>500) {
            ErrorView.display(this.getClass().getName(),"\nInvalid Weight: Let's be real!");
            return false;
        }
        DesertEscape.getPlayer().setWeight(weight);
        return true;
}

    private String getHeight() {
        String value = ""; //return value
        boolean valid = false;
        try{
        while (!valid) { //loops until a valid input is entered
            this.console.println(this.promptHeight());
            
            value = this.keyboard.readLine();
            value = value.trim(); // trims blanks at ends after getting line entered
            
            if (value.length() < 1) { // blank input
                this.console.println("\nInvalid value: Enter a valid height");
                continue;
            }
            break;
        }
        
        } catch (Exception e){
            this.console.println("Error reading height" + e.getMessage());
        }
        return value;
}
    private boolean saveHeight(Double height) {
        if (height<30 || height>90) {
            ErrorView.display(this.getClass().getName(),"\nInvalid Height: Let's be real!");
            return false;
        }
        
        PlayerControl.setBmi(DesertEscape.getPlayer().getWeight(), height);
        this.displayNextView(DesertEscape.getPlayer());
        return true;
        
}

    private void displayNextView(Player player) {
        this.console.println("\nLooks like the suit fits, " + player.getName() + "!"
                + "\nYour BMI is "+Math.round(player.getBmi())+"! Let's go outside...");
        DesertSceneView desertSceneView = new DesertSceneView();
        
        Location[][] locations = DesertEscape.getCurrentGame().getMap().getLocations();
        
        locations[0][0].getScene().setBlocked(false);
        desertSceneView.displayDesertSceneView();
    }

}