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
public class IndoorTile implements Serializable{
    private String roomType;

    public IndoorTile() {
    }

    public String getRoomType() {
        return roomType;
    }

    public void setRoomType(String roomType) {
        this.roomType = roomType;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 37 * hash + Objects.hashCode(this.roomType);
        return hash;
    }

    @Override
    public String toString() {
        return "IndoorTile{" + "roomType=" + roomType + '}';
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
        final IndoorTile other = (IndoorTile) obj;
        if (!Objects.equals(this.roomType, other.roomType)) {
            return false;
        }
        return true;
    }
    
    
}
