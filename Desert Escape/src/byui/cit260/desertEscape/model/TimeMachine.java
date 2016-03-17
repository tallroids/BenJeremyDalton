/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.desertEscape.model;

import java.io.Serializable;

/**
 *
 * @author tallroids
 */
public class TimeMachine implements Serializable{
    private double chamberHeight;
    private double chamberWidth;
    private double maximumWeight;

    public TimeMachine() {
        this.chamberHeight = 0;
        this.chamberWidth = 0;
        this.maximumWeight = 500;
    }

    
    public double getChamberHeight() {
        return chamberHeight;
    }

    public void setChamberHeight(double chamberHeight) {
        this.chamberHeight = chamberHeight;
    }

    public double getChamberWidth() {
        return chamberWidth;
    }

    public void setChamberWidth(double chamberWidth) {
        this.chamberWidth = chamberWidth;
    }

    public double getMaximumWeight() {
        return maximumWeight;
    }

    public void setMaximumWeight(double maximumWeight) {
        this.maximumWeight = maximumWeight;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 47 * hash + (int) (Double.doubleToLongBits(this.chamberHeight) ^ (Double.doubleToLongBits(this.chamberHeight) >>> 32));
        hash = 47 * hash + (int) (Double.doubleToLongBits(this.chamberWidth) ^ (Double.doubleToLongBits(this.chamberWidth) >>> 32));
        hash = 47 * hash + (int) (Double.doubleToLongBits(this.maximumWeight) ^ (Double.doubleToLongBits(this.maximumWeight) >>> 32));
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
        final TimeMachine other = (TimeMachine) obj;
        if (Double.doubleToLongBits(this.chamberHeight) != Double.doubleToLongBits(other.chamberHeight)) {
            return false;
        }
        if (Double.doubleToLongBits(this.chamberWidth) != Double.doubleToLongBits(other.chamberWidth)) {
            return false;
        }
        if (Double.doubleToLongBits(this.maximumWeight) != Double.doubleToLongBits(other.maximumWeight)) {
            return false;
        }
        return true;
    }
    
    
}
