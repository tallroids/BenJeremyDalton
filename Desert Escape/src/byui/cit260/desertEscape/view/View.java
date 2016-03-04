/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.desertEscape.view;

import java.util.Scanner;

/**
 *
 * @author daltonsolo
 */
public abstract class View implements ViewInterface {
    protected String displayMessage;
    
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
            if (value.toUpperCase().equals("Q"))
                return;
            
            done = this.doAction(value);
        } while (!done);
    }
    @Override
          public String getInput() {
        Scanner keyboard = new Scanner(System.in); 
        boolean valid = false;
        String value = null; //return value
        
        while (!valid) { //loops until a valid input is entered
            System.out.println("\n" + this.displayMessage);
            
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
        
        
        
        
        
        
        
    
}
