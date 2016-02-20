/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.desertEscape.model;


import java.io.Serializable;
import java.util.Objects;
/**
 *
 * @author daltonsolo
 */
public class Character implements Serializable {
    
    //class instance variables
    
    private String name;
    private String characterType;
    private String characterLocation;


public Character() {
}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCharacterType() {
        return characterType;
    }

    public void setCharacterType(String characterType) {
        this.characterType = characterType;
    }

    public String getCharacterLocation() {
        return characterLocation;
    }

    public void setCharacterLocation(String characterLocation) {
        this.characterLocation = characterLocation;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 37 * hash + Objects.hashCode(this.name);
        hash = 37 * hash + Objects.hashCode(this.characterType);
        hash = 37 * hash + Objects.hashCode(this.characterLocation);
        return hash;
    }

    @Override
    public String toString() {
        return "Character{" + "name=" + name + ", characterType=" + characterType + ", characterLocation=" + characterLocation + '}';
    }
    
    
    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Character other = (Character) obj;
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        if (!Objects.equals(this.characterType, other.characterType)) {
            return false;
        }
        if (!Objects.equals(this.characterLocation, other.characterLocation)) {
            return false;
        }
        return true;
    }

    


}
