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
public class OutdoorTile implements Serializable{
    private String climate;

    public OutdoorTile() {
    }

    public String getClimate() {
        return climate;
    }

    public void setClimate(String climate) {
        this.climate = climate;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 47 * hash + Objects.hashCode(this.climate);
        return hash;
    }

    @Override
    public String toString() {
        return "OutdoorTile{" + "climate=" + climate + '}';
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
        final OutdoorTile other = (OutdoorTile) obj;
        if (!Objects.equals(this.climate, other.climate)) {
            return false;
        }
        return true;
    }
    
    
}
