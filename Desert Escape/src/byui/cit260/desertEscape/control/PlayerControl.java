/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.desertEscape.control;

import desert.escape.DesertEscape;

/**
 *
 * @author tallroids
 */
public class PlayerControl {

    public static void setBmi(Double weight, Double height) {
        DesertEscape.getPlayer().setHeight(height);
        double bmi = 730*(weight/Math.pow(height, 2));
        DesertEscape.getPlayer().setBmi(bmi);
    }
    
}
