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
 * @author tallroids
 */
class PrologueSceneView {

    private String prologue;
    private String view;
    private Double weight;
    private Double height;
    private Double bmi;
    public PrologueSceneView() {
        this.prologue = "\n"
                + "\n*** Welcome to Desert Escape," //+ player.getName() +"!***"
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
        
        boolean done = false;
        do {
            String input = this.getWeight();
            if (input.toUpperCase().equals('Q'))
                return;
            weight = Double.parseDouble(input);
            done = this.saveWeight(weight);
        } while (!done);
        do {
            String input = this.getHeight();
            if (input.toUpperCase().equals('Q'))
                return;
            height = Double.parseDouble(input);
            done = this.saveHeight(height);
        } while (!done);
}
    private String getWeight() {
        Scanner keyboard = new Scanner(System.in); 
        String value = ""; //return value
        boolean valid = false;
        
        System.out.println(this.prologue);
        while (!valid) { //loops until a valid input is entered
            System.out.println(this.promptWeight());
            
            value = keyboard.nextLine();
            value = value.trim(); // trims blanks at ends after getting line entered
            
            if (value.length() < 1) { // blank input
                System.out.println("\nInvalid value: Enter a valid weight");
                continue;
            }
            break;
        }
        return value;    
    }
    private boolean saveWeight(Double weight) {
        if (weight<20 || weight>500) {
            System.out.println("\nInvalid Weight: Let's be real!");
            return false;
        }
        
        Player player = GameControl.setPlayerWeight(weight);
        
        if (player == null) {
            System.out.println("\nError updating weight");
            return false;
        }
        //this.getHeight();
        return true;
}
    //bmi = 703*(weight/height);

    private String getHeight() {
    Scanner keyboard = new Scanner(System.in); 
        String value = ""; //return value
        boolean valid = false;
        
        while (!valid) { //loops until a valid input is entered
            System.out.println(this.promptHeight());
            
            value = keyboard.nextLine();
            value = value.trim(); // trims blanks at ends after getting line entered
            
            if (value.length() < 1) { // blank input
                System.out.println("\nInvalid value: Enter a valid weight");
                continue;
            }
            break;
        }
        return value;
}
    private boolean saveHeight(Double height) {
        if (height<30 || height>90) {
            System.out.println("\nInvalid Height: Let's be real!");
            return false;
        }
        
        Player player = GameControl.setPlayerHeight(height);
        
        if (player == null) {
            System.out.println("\nError updating height");
            return false;
        }
        bmi = 730*(weight/Math.pow(height, 2));
        player.setBmi(bmi);
        this.displayNextView(player);
        return true;
        
}

    private void displayNextView(Player player) {
        System.out.println("\nLooks like the suit fits, " + player.getName() + "!"
                + "\nYour BMI is"+bmi+"! Let's go outside...");
        DesertSceneView desertSceneView = new DesertSceneView();
        
        desertSceneView.displayDesertSceneView();
    }

}