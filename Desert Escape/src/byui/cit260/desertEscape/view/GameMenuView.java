/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.desertEscape.view;

import byui.cit260.desertEscape.control.GameControl;
import byui.cit260.desertEscape.model.Item;
import desert.escape.DesertEscape;
import java.util.Scanner;

/**
 *
 * @author tallroids
 */
class GameMenuView extends View {

    public GameMenuView() {
        super("\n"
                + "\n*** Game Menu***"
                + "\nC - Continue?"
                + "\nI - Check Inventory"
                + "\nS - View character stats?"
                + "\nM - View Map"
                + "\nQ - Quit");
    }

    @Override
    public boolean doAction(String choice) {
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
            case "M":
                this.displayMap();
                break;
            default:
                ErrorView.display(this.getClass().getName(),"\n*** Please try again ***");
                break;

        }
        return false;

    }

    private void continueGame() {
        GameControl.resumeGame("");
        PrologueSceneView prologueSceneView = new PrologueSceneView();
        prologueSceneView.displayScene();
    }

    private void checkInventory() {

        //InventoryView inventoryView = new InventoryView();
        //inventoryView.display();
        Item[] inventory = DesertEscape.getCurrentGame().getInventory();
        
        this.console.println("\n*** Inventory ***");
        this.console.println("Name" + "\t  Price" + "\t  You have"+" Description");

        for (int i = 0; i < inventory.length; i++) {
            if (inventory[i].getName() != null) {
                this.console.println(inventory[i].getName() + "\t  "
                        + inventory[i].getItemPrice()+ "\t  "
                        + inventory[i].getAmountInInventory()+ "\t   "
                        + inventory[i].getDescription() );
                        
            }else
                this.console.println("");
        }
        this.console.println(GameControl.calcSumPriceInventoryItems());
    }

    private void characterStats() {
        CharacterStatsView characterStatsView = new CharacterStatsView();
        characterStatsView.display();

    }

    private void displayMap() {
        this.console.println(DesertEscape.getCurrentGame().getMap().getMapString());
    }

}
