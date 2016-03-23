/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.desertEscape.view;

import byui.cit260.desertEscape.control.GameControl;
import byui.cit260.desertEscape.model.Location;
import byui.cit260.desertEscape.model.Map;
import desert.escape.DesertEscape;

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
    
}
