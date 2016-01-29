
package desert.escape;

import byui.cit260.desertEscape.model.Player;

/**
 *
 * @author Jeremy, Dalton, Ben
 */
public class DesertEscape {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Player playerOne = new Player();
        playerOne.setWeight(100);
        playerOne.setHeight(70);
        playerOne.setName("player");
        String playerInfo = playerOne.toString();
        System.out.println(playerInfo);
    }
    
}
