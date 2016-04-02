/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.desertEscape.model;

import byui.cit260.desertEscape.view.ErrorView;
import desert.escape.DesertEscape;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Objects;

/**
 *
 * @author tallroids
 */
public class Map implements Serializable{
    // class instance variables
    private String description;
    private double noOfRows;
    private double noOfColumns;
    private Location[][] locations;

    public Map() {
    }
    
    public Map(int noOfRows, int noOfColumns) {
        if(noOfRows < 1 || noOfColumns < 1) {
            ErrorView.display(this.getClass().getName(),"The number of rows and columns needs to be more than zero");
            return;
        }
        
        this.noOfRows = noOfRows;
        this.noOfColumns = noOfColumns;
        
        this.locations = new Location[noOfRows][noOfColumns];
        
        for (int row =0; row < noOfRows; row++){
            for(int column = 0; column<noOfColumns; column++){
                Location location = new Location();
                location.setColumn(column);
                location.setRow(row);
                location.setVisited(false);
                
                locations[row][column] = location;
            }
        }
    }

       
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getNoOfRows() {
        return noOfRows;
    }

    public void setNoOfRows(double noOfRows) {
        this.noOfRows = noOfRows;
    }

    public double getNoOfColumns() {
        return noOfColumns;
    }

    public void setNoOfColumns(double noOfColumns) {
        this.noOfColumns = noOfColumns;
    }

    public Location[][] getLocations() {
        return locations;
    }

    public void setLocations(Location[][] locations) {
        this.locations = locations;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 79 * hash + Objects.hashCode(this.description);
        hash = 79 * hash + (int) (Double.doubleToLongBits(this.noOfRows) ^ (Double.doubleToLongBits(this.noOfRows) >>> 32));
        hash = 79 * hash + (int) (Double.doubleToLongBits(this.noOfColumns) ^ (Double.doubleToLongBits(this.noOfColumns) >>> 32));
        hash = 79 * hash + Arrays.deepHashCode(this.locations);
        return hash;
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
        final Map other = (Map) obj;
        if (Double.doubleToLongBits(this.noOfRows) != Double.doubleToLongBits(other.noOfRows)) {
            return false;
        }
        if (Double.doubleToLongBits(this.noOfColumns) != Double.doubleToLongBits(other.noOfColumns)) {
            return false;
        }
        if (!Objects.equals(this.description, other.description)) {
            return false;
        }
        if (!Arrays.deepEquals(this.locations, other.locations)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Map{" + "description=" + description + ", noOfRows=" + noOfRows + ", noOfColumns=" + noOfColumns + ", locations=" + locations + '}';
    }

    public String getMapString() {
        String rtn = " ***** Map ****\n";
        for (int row = 0; row < noOfRows; row++) {
            for (int col = 0; col < noOfColumns; col++) {
                if (locations[row][col].getScene().getBlocked() == false) {
                    rtn += "| " + locations[row][col].getScene().getDescrption().charAt(0)
                                + locations[row][col].getScene().getDescrption().charAt(1) + " ";
                }else
                rtn += "| ?? ";
            }
            rtn += "|\n";
        }
        rtn += " **************";
        return rtn;

    }
    public Location getCurrentLocation(int row, int col){
        return locations[row][col];
    }
}
