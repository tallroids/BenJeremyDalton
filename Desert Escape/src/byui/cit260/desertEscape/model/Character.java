/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.desertEscape.model;


import java.awt.Point;
import java.io.Serializable;
import java.util.Objects;
/**
 *
 * @author daltonsolo
 */
public enum Character implements Serializable {
    
    Alien("It is the enemy"),
    Shopkeeper("He sells you what you will need to stay alive");
    
    //class instance variables
    
    private final String description;
    private final Point characterLocation;

Character(String description) {
    this.description = description;
    characterLocation = new Point(1,1);
}

    public Point getCharacterLocation() {
        return characterLocation;
    }
    
    public String getDescription() {
        return description;
    }

    @Override
    public String toString() {
        return "Character{" + "description=" + description + ", characterLocation=" + characterLocation + '}';
    }
    
}