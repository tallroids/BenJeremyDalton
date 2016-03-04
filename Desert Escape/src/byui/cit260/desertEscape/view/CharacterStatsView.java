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
class CharacterStatsView extends View{

    public CharacterStatsView() {
        super("\n"
                + "\n*** Player Stats ***"
                + "\nH - View your height"
                + "\nW - View your weight"
                + "\nB - View your BMI"
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
            default:
                System.out.println("\n*** Please try again ***");
                break;
                
        }
        return false;
    }

    private void displayHeight() {
        System.out.println("Your height is:" + DesertEscape.getPlayer().getHeight());
                
    }

    private void displayWeight() {
        System.out.println("Your weight is:" + DesertEscape.getPlayer().getWeight());
    }

    private void displayBmi() {
        System.out.println("Your BMI is:" + Math.round(DesertEscape.getPlayer().getBmi()));
    }
    
}
