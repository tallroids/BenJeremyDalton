/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.desertEscape.view;

import byui.cit260.desertEscape.model.Player;

/**
 *
 * @author daltonsolo
 */
public interface ViewInterface {
    public void display();
    public String getInput();
    public boolean doAction(String value);
    public void unblockAndDisplayMenu(Player player);
}
