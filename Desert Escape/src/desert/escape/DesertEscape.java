
package desert.escape;

import byui.cit260.desertEscape.model.Game;
import byui.cit260.desertEscape.model.Player;
import byui.cit260.desertEscape.view.StartProgramView;

/**
 *
 * @author Jeremy, Dalton, Ben
 */
public class DesertEscape {

    /**
     * @param args the command line arguments
     */
    private static Game currentGame = null;
    private static Player player = null;
    
    public static void main(String[] args) {
        StartProgramView startprogramView = new StartProgramView();
        startprogramView.display();
    }

    public static Game getCurrentGame() {
        return currentGame;
    }

    public static void setCurrentGame(Game currentGame) {
        DesertEscape.currentGame = currentGame;
    }

    public static Player getPlayer() {
        return player;
    }

    public static void setPlayer(Player player) {
        DesertEscape.player = player;
    }

    
    
}
