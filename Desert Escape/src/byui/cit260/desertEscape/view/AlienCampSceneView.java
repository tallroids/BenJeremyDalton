/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.desertEscape.view;

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
                + "\n\nR - Run!"
                + "\nH - Say Hello"
                + "\nQ - Game Menu");
    }

    @Override
    public boolean doAction(String choice) {
        choice = choice.toUpperCase();
        switch (choice) {
            case "R":
                this.console.println("Good choice, you would probably regret that");
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
}
