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
public class InventoryView extends View {
    
    
    public InventoryView() {
        
        super("\n"
                + "\n*** Inventory Menu***"
                + "\nC - View clothing"
                + "\nW - View weapons"
                + "\nF - View food"
                + "\nI - View quest items"
                + "\nQ - Quit");
                
    }
    
    
    @Override
    public boolean doAction(String choice) {
            choice = choice.toUpperCase();
        switch (choice) {
            case "C":
                this.playerClothing();
                break;
            case "W":
                this.playerWeapons();
                break;
            case "F":
                this.playerFood();
                break;
                case "I":
                this.playerQuestItems();
                break;
             
            default:
                System.out.println("\n*** Please try again ***");
                break;
                
        }
        return false;
     
    }

    private void playerClothing() {
        System.out.println("playerClothing function called");
    
    }
    private void playerWeapons() {
        System.out.println("playerWeapons function called");
    
    }
    private void playerFood() {
        System.out.println("playerFood function called");
    
    }
    private void playerQuestItems() {
        System.out.println("playerItems function called");
    
    }
    
    
}

