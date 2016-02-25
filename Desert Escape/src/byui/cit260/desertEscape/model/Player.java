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
 * @author Jeremy
 */
public class Player implements Serializable{
    
    private String name;
    private double weight;
    private double height;
    private double bmi;
    private double percentComplete;
    private String inventory;
    
    public Player() {
    }
    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getBmi() {
        return bmi;
    }

    public void setBmi(double bmi) {
        this.bmi = bmi;
    }

    public String getInventory() {
        return inventory;
    }

    public void setInventory(String inventory) {
        this.inventory = inventory;
    }
    

    public double getPercentComplete() {
        return percentComplete;
    }

    public void setPercentComplete(double percentComplete) {
        this.percentComplete = percentComplete;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        return hash;
    }

    @Override
    public String toString() {
        return "Player{" + "name=" + name + ", weight=" + weight + ", height=" + height + ", percentComplete=" + percentComplete + '}';
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
        final Player other = (Player) obj;
        if (Double.doubleToLongBits(this.weight) != Double.doubleToLongBits(other.weight)) {
            return false;
        }
        if (Double.doubleToLongBits(this.percentComplete) != Double.doubleToLongBits(other.percentComplete)) {
            return false;
        }
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        return true;
    }

    
    
    
    
}
