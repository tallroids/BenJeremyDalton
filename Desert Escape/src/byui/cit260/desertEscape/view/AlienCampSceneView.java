/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.desertEscape.view;

import byui.cit260.desertEscape.control.GameControl;
import desert.escape.DesertEscape;

/**
 *
 * @author tallroids
 */
class AlienCampSceneView extends View{

    public AlienCampSceneView() {
        super("\n"
                + "\n*** Alien Camp ***"
                + "\nYou wandered into a camp of aliens, what will you do?"
                + "\n\nS - Search for items"
                + "\nR - Run!"
                + "\nH - Say Hello"
                + "\nQ - Game Menu");
    }

    @Override
    public boolean doAction(String choice) {
        choice = choice.toUpperCase();
        switch (choice) {
            case "S":
                this.console.println("You carefully move through the camp, searching for something valuable.");
                this.collectItems();
                break;
            case "R":
                this.console.println("Good choice, you would probably regret sticking around longer");
                this.unblockAndDisplayMenu(DesertEscape.getPlayer());
                break;
            case "H":
                this.console.println("Bad choice, you died");
                break;
         
            default:
                ErrorView.display(this.getClass().getName(),"\n*** Please try again ***");
                break;
    }
    return false;
}

    private void collectItems() {
            GameControl.addParts(DesertEscape.getPlayer().getCurrentLocation());
            GameControl.addRayGun();
    }
}
