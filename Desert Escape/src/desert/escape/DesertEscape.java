
package desert.escape;

import byui.cit260.desertEscape.model.Location;
import byui.cit260.desertEscape.model.Player;
import byui.cit260.desertEscape.model.Character;
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
        playerOne.setLives(9);
        String playerInfo = playerOne.toString();
        System.out.println(playerInfo);
        
        Location locationOne = new Location();
        locationOne.setDescription("Desert");
        locationOne.setColumn(1);
        locationOne.setRow(1);
        String locationInfo = locationOne.toString();
        System.out.println(locationInfo);
        
        Character characterOne = new Character();
        characterOne.setName("Alien");
        characterOne.setCharacterType("Enemy");
        characterOne.setCharacterLocation("Alien Camp");
        String characterInfo = characterOne.toString();
        System.out.println(characterInfo);
                
    }
    
}
