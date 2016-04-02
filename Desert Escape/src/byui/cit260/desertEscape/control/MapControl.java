/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.desertEscape.control;

import byui.cit260.desertEscape.model.Game;
import byui.cit260.desertEscape.model.Location;
import byui.cit260.desertEscape.model.Map;
import byui.cit260.desertEscape.model.Player;
import byui.cit260.desertEscape.model.Scene;
import byui.cit260.desertEscape.model.SceneType;
import desert.escape.DesertEscape;

/**
 *
 * @author tallroids
 */
public class MapControl {

    public static Map createMap() {
        Map map = new Map(3,3);   
        Scene[] scenes = createScenes();
        
        GameControl.assignScenesToLocations(map, scenes);
        
        return map;    
    }

    private static Scene[] createScenes() {
        Game game = DesertEscape.getCurrentGame();
        
        Scene[] scenes = new Scene[SceneType.values().length];
        
        Scene prologueScene = new Scene();
        prologueScene.setDescrption("Prologue");
        prologueScene.setBlocked(true);
        scenes[SceneType.prologueScene.ordinal()] = prologueScene;
        
        Scene desert = new Scene();
        desert.setDescrption("Desert");
        desert.setBlocked(true);
        scenes[SceneType.desert.ordinal()] = desert;
        
        Scene pyramid = new Scene();
        pyramid.setDescrption("Pyramid");
        pyramid.setBlocked(true);
        scenes[SceneType.pyramid.ordinal()] = pyramid;
        
        Scene alienCamp = new Scene();
        alienCamp.setDescrption("Alien Camp");
        alienCamp.setBlocked(true);
        scenes[SceneType.alienCamp.ordinal()] = alienCamp;
        
        Scene caves = new Scene();
        caves.setDescrption("Caves");
        caves.setBlocked(true);
        scenes[SceneType.caves.ordinal()] = caves;
        
        Scene mountains = new Scene();
        mountains.setDescrption("Mountains");
        mountains.setBlocked(true);
        scenes[SceneType.mountains.ordinal()] = mountains;
        
        Scene cliff = new Scene();
        cliff.setDescrption("Cliff");
        cliff.setBlocked(true);
        scenes[SceneType.cliff.ordinal()] = cliff;
        
        Scene shop = new Scene();
        shop.setDescrption("Shop");
        shop.setBlocked(true);
        scenes[SceneType.shop.ordinal()] = shop;
        
        Scene pit = new Scene();
        pit.setDescrption("Pit");
        pit.setBlocked(true);
        scenes[SceneType.pit.ordinal()] = pit;
        
        Scene crevass = new Scene();
        crevass.setDescrption("Crevass");
        crevass.setBlocked(true);
        scenes[SceneType.crevass.ordinal()] = crevass;
        
        return scenes;
    }

    public static void unblockLocation(Location currentLocation) {
        currentLocation.getScene().setBlocked(false);
        return;
    }

    public static void moveToNextLocation(Player player) {
        Map map = DesertEscape.getCurrentGame().getMap();
        
        double oldCol = player.getCurrentLocation().getColumn();
        double oldRow = player.getCurrentLocation().getRow();
        int newCol = 0;
        int newRow = 0;
        
        
        if (oldCol < 2){
            newCol = (int) (oldCol + 1);
            newRow = (int) oldRow;
        } else{
            newCol = 0;
            newRow = (int) (oldRow + 1);
        }
        Location[][] newLocation = map.getLocations();
        player.setCurrentLocation(newLocation[newRow][newCol]);
    }
    
}
