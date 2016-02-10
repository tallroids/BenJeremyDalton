
package desert.escape;

import byui.cit260.desertEscape.model.Location;
import byui.cit260.desertEscape.model.OutdoorTile;
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
        
        Location locationOne = new Location();
        locationOne.setDescription("desert");
        locationOne.setColumn(1);
        locationOne.setRow(1);
        String locationInfo = locationOne.toString();
        System.out.println(locationInfo);
        
        OutdoorTile out = new OutdoorTile();
        out.setClimate("desert");
        String climateInfo = out.toString();
        System.out.println(out);
    }
    
}
