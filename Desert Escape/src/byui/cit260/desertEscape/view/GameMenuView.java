/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.desertEscape.view;

import byui.cit260.desertEscape.control.GameControl;
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
            default:
                System.out.println("\n*** Please try again ***");
                break;
                
        }
        return false;
    
}

    private void continueGame() {
        GameControl.resumeGame(DesertEscape.getPlayer());
        PrologueSceneView prologueSceneView = new PrologueSceneView();
        prologueSceneView.displayScene();
    }

    private void checkInventory() {
      
        InventoryView inventoryView = new InventoryView();
        inventoryView.display();
}

    private void characterStats() {
        System.out.println(DesertEscape.getPlayer().toString());
        CharacterStatsView characterStatsView = new CharacterStatsView();
        characterStatsView.display();
                
}
    
}
