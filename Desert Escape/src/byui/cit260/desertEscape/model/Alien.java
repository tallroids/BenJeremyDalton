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
 * @author tallroids
 */
public class Alien implements Serializable{
    private String alienType;

    public Alien() {
    }

    public String getAlienType() {
        return alienType;
    }

    public void setAlienType(String alienType) {
        this.alienType = alienType;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 23 * hash + Objects.hashCode(this.alienType);
        return hash;
    }

    @Override
    public String toString() {
        return "Alien{" + "alienType=" + alienType + '}';
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Alien other = (Alien) obj;
        if (!Objects.equals(this.alienType, other.alienType)) {
            return false;
        }
        return true;
    }
    
    
}
