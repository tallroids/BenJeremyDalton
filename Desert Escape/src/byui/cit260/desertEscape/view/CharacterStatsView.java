/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.desertEscape.view;

import byui.cit260.desertEscape.control.GameControl;
import byui.cit260.desertEscape.model.InventoryItem;
import byui.cit260.desertEscape.model.Item;
import byui.cit260.desertEscape.model.Location;
import byui.cit260.desertEscape.model.Map;
import desert.escape.DesertEscape;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author tallroids
 */
class CharacterStatsView extends View{

    public CharacterStatsView() {
        super("\n"
                + "\n*** Player Stats ***"
                + "\nH - View your height"
                + "\nW - View your weight"
                + "\nB - View your BMI"
                + "\nP - Percent complete"
                + "\nS - Print summary of Inventory to a text file"
                + "\nQ - Quit");
    }
    @Override
    public boolean doAction(String choice){
        choice = choice.toUpperCase();
        switch (choice) {
            case "H":
                this.displayHeight();
                break;
            case "W":
                this.displayWeight();
                break;
            case "B":
                this.displayBmi();
                break;
            case "P":
                this.displayPercentComplete();
                break;
            case "S":
                this.promptPrintInventory();
                break;
            default:
                ErrorView.display(this.getClass().getName(), "\n*** Please try again ***");
                break;
                
        }
        return false;
    }

    private void displayHeight() {
        this.console.println("Your height is:" + DesertEscape.getPlayer().getHeight());
                
    }

    private void displayWeight() {
        this.console.println("Your weight is:" + DesertEscape.getPlayer().getWeight());
    }

    private void displayBmi() {
        this.console.println("Your BMI is:" + Math.round(DesertEscape.getPlayer().getBmi()));
    }

    private void displayPercentComplete() {
        
        byui.cit260.desertEscape.control.GameControl.calculatePercentComplete();
        
        this.console.println("You have completed "+ GameControl.calculatePercentComplete() +"% of the game");
    }

    private void printInventory(Item[] inventory, String outputLocation) {        
        try (PrintWriter out = new PrintWriter(outputLocation)){
            out.println("\n\n     Inventory     ");
            out.printf("%n%-16s%-9s%-9s%10s", "Item Name", "Price", "Owned", "Description");
            out.printf("%n%-16s%-9s%-9s%10s", "*********", "*****", "*****", "***********");
            
            for (Item i : inventory) {
                out.printf("%n%-16s%-9.2f%-9d%-40s", i.getName(), i.getItemPrice(), i.getAmountInInventory(), i.getDescription());
            }
        } catch (IOException e){
            this.console.println("Error Saving names to file" + e.getMessage());
        }
    }

    private void promptPrintInventory() {
        
        this.console.println("Please enter the filepath for the document");
        String outputLocation;
        try {
            outputLocation = keyboard.readLine();
            printInventory(DesertEscape.getCurrentGame().getInventory(), outputLocation);
        } catch (IOException e) {
            this.console.println("Error Saving names to file" + e.getMessage());
        }
            
    
    }
    
}
