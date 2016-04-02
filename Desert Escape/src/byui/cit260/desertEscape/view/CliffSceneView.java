/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.desertEscape.view;

/**
 *
 * @author tallroids
 */
class CliffSceneView extends View{

    public CliffSceneView() {
        super("\n"
                + "\n*** This view not yet developed ***"
                
                + "\nQ - Game Menu");
    }

    @Override
    public boolean doAction(String choice) {
     this.console.println("This scene is not created yet, sorry");
        choice = choice.toUpperCase();
        switch (choice) {
                
            default:
                ErrorView.display(this.getClass().getName(),"\n*** Please try again ***");
                break;
    }
    return false;
    
}
}
