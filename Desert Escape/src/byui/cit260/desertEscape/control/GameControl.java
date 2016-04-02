/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.desertEscape.control;

import byui.cit260.desertEscape.exeptions.GameControlException;
import byui.cit260.desertEscape.exeptions.MapControlExeption;
import byui.cit260.desertEscape.model.Game;
import byui.cit260.desertEscape.model.Item;
import byui.cit260.desertEscape.model.InventoryItem;
import byui.cit260.desertEscape.model.Location;
import byui.cit260.desertEscape.model.Map;
import byui.cit260.desertEscape.model.Player;
import byui.cit260.desertEscape.model.Scene;
import byui.cit260.desertEscape.model.SceneType;
import byui.cit260.desertEscape.model.TimeMachine;
import byui.cit260.desertEscape.view.ErrorView;
import desert.escape.DesertEscape;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Jeremy
 */
public class GameControl {

    protected final BufferedReader keyboard = DesertEscape.getInFile();
    protected final PrintWriter console = DesertEscape.getOutFile();

    public static Player createPlayer(String name)
            throws GameControlException {
        if (name == null) {
            throw new GameControlException("Player could not be created, please enter a valid name");
        }

        Player player = new Player();
        player.setName(name);

        DesertEscape.setPlayer(player); // saves the player

        return player;
    }

    public static void createNewGame(Player player) {
        Game game = new Game();

        game.setPlayer(player);
        game.getPlayer().setPercentComplete(0.0);
        
        Item[] inventoryList = GameControl.createInventoryList();
        game.setInventory(inventoryList);

        TimeMachine timeMachine = new TimeMachine();
        game.setTimeMachine(timeMachine);

        Map map = MapControl.createMap();
        game.setMap(map);
        
        game.getPlayer().setCurrentLocation(map.getCurrentLocation(0,0));
        
        DesertEscape.setCurrentGame(game);

    }

    public static void resumeGame(String filePath) {
        Game game = null;
        
        try {
            FileInputStream fis = new FileInputStream(filePath);
            ObjectInputStream ois = new ObjectInputStream(fis);

            game = (Game)ois.readObject();
            
            DesertEscape.setCurrentGame(game);
            DesertEscape.setPlayer(game.getPlayer());
        } catch (Exception e) {
            ErrorView.display("GameController", e.getMessage());
        }
    }

    public static void saveGame(String filePath) {
        try {
            FileOutputStream fos = new FileOutputStream(filePath);
            ObjectOutputStream oos = new ObjectOutputStream(fos);

            oos.writeObject(DesertEscape.getCurrentGame());

        } catch (Exception e) {
            ErrorView.display("GameController", e.getMessage());
        }
    }

    public static Player setPlayerWeight(Double weight) {
        if (weight == null) {
            return null;
        }

        Player player = new Player();
        player.setWeight(weight);

        DesertEscape.setPlayer(player); // saves the player

        return player;
    }

    public static Player setPlayerHeight(Double height) {
        if (height == null) {
            return null;
        }

        Player player = new Player();
        player.setHeight(height);

        DesertEscape.setPlayer(player); // saves the player

        return player;
    }

    private static Item[] createInventoryList() {
        Item[] inventory = new Item[3];

        Item shovel = new Item();
        shovel.setName("Shovel");
        shovel.setDescription("Dig holes, fill holes");
        shovel.setItemPrice(0);
        shovel.setAmountInInventory(0);
        inventory[InventoryItem.shovel.ordinal()] = shovel;

        Item timeMachineParts = new Item();
        timeMachineParts.setName("Parts");
        timeMachineParts.setDescription("Use these to fix the time machine");
        timeMachineParts.setItemPrice(0);
        timeMachineParts.setAmountInInventory(0);
        inventory[InventoryItem.timeMachineParts.ordinal()] = timeMachineParts;

        Item rayGun = new Item();
        rayGun.setName("Ray Gun");
        rayGun.setDescription("Shoot aliens with this bad-boy");
        rayGun.setItemPrice(20);
        rayGun.setAmountInInventory(0);
        inventory[InventoryItem.rayGun.ordinal()] = rayGun;

        return inventory;
    }

    static void assignScenesToLocations(Map map, Scene[] scenes) {
        Location[][] locations = map.getLocations();

        locations[0][0].setScene(scenes[SceneType.prologueScene.ordinal()]);
        locations[0][1].setScene(scenes[SceneType.alienCamp.ordinal()]);
        locations[0][2].setScene(scenes[SceneType.caves.ordinal()]);
        locations[1][0].setScene(scenes[SceneType.cliff.ordinal()]);
        locations[1][1].setScene(scenes[SceneType.crevass.ordinal()]);
        locations[1][2].setScene(scenes[SceneType.desert.ordinal()]);
        locations[2][0].setScene(scenes[SceneType.mountains.ordinal()]);
        locations[2][1].setScene(scenes[SceneType.pit.ordinal()]);
        locations[2][2].setScene(scenes[SceneType.shop.ordinal()]);

    }

    public static double calculatePercentComplete() {
        Map map = DesertEscape.getCurrentGame().getMap();
        Location[][] locations = DesertEscape.getCurrentGame().getMap().getLocations();
        double rtn = 0.0;
        for (int row = 0; row < map.getNoOfRows(); row++) {
            for (int col = 0; col < map.getNoOfColumns(); col++) {
                if (locations[row][col].getScene().getBlocked() == false) {
                    rtn += 11.11;
                } else {
                    rtn += 0;
                }
            }

        }
        return rtn;

    }

    public static double calcSumPriceInventoryItems() {

        Item[] inventory = DesertEscape.getCurrentGame().getInventory();
        double sum = 0.00;

        DesertEscape.getOutFile().println("\nSum price of items:");
        for (Item item : inventory) {
            if (item.getAmountInInventory() > 0) {
                sum = sum + item.getItemPrice();
            } else {
                sum += 0.00;
            }

        }
        return sum;

    }

}
