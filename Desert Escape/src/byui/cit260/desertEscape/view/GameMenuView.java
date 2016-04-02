/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.desertEscape.view;

import byui.cit260.desertEscape.control.GameControl;
import byui.cit260.desertEscape.control.MapControl;
import byui.cit260.desertEscape.model.Item;
import byui.cit260.desertEscape.model.Scene;
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

    private boolean continueGame() {
        String loc = DesertEscape.getCurrentGame().getPlayer().getCurrentLocation().getScene().getDescrption();
        this.console.println(loc);
        switch (loc) {
            case "Prologue":
                PrologueSceneView prologue = new PrologueSceneView();
                prologue.displayScene();
                break;
            case "Alien Camp":
                AlienCampSceneView camp = new AlienCampSceneView();
                camp.display();
                break;
            case "Caves":
                CavesSceneView caves = new CavesSceneView();
                caves.display();
                break;
            case "Cliff":
                CliffSceneView cliff = new CliffSceneView();
                cliff.display();
                break;
            case "Crevass":
                CrevassSceneView crevass = new CrevassSceneView();
                crevass.display();
                break;
            case "Desert":
                DesertSceneView desert = new DesertSceneView();
                desert.display();
                break;
            case "Mountains":
                MountainsSceneView mountains = new MountainsSceneView();
                mountains.display();
                break;
            case "Pit":
                PitSceneView pit = new PitSceneView();
                pit.display();
                break;
            case "Shop":
                ShopSceneView shop = new ShopSceneView();
                shop.display();
                break;
        }
        return false;
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
