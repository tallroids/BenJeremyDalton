/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.desertEscape.control;
import static java.lang.Math.*;
/**
 *
 * @author tallroids
 */
public class ManufactureControl {
    public double calcShovelVolume (double shovelLength, double shovelWidth, double shovelDepth){
        if (shovelLength < 0 || shovelLength > 10) {
            return -1;
        } 
        if (shovelWidth < 0 || shovelWidth > 10) {
            return -1;
        } 
        if (shovelDepth < 0 || shovelDepth > 10) {
            return -1;
        }

        double shovelVolume = shovelLength * shovelWidth * shovelDepth;

        return shovelVolume;
       }
    
    public double calcShovelsFull ( double shovelVolume, double pitVolume){
        if (shovelVolume <= 0 || shovelVolume > 1000) {
            return -1;
        }
        if (pitVolume <= 0 || pitVolume > 1000) {
            return -1;
        }
        
        double shovelsFull = pitVolume / shovelVolume;
        
        return shovelsFull;
    }
    public double calcTreeHeight (double treeDistance, double treeAngle) {
        if (treeDistance <= 0 || treeDistance > 5000) {
            return -1;
        }
        if (treeAngle <= 0 || treeAngle >= 180) {
            return -1;
        }
        
        double treeHeight = (tan(treeAngle)) * treeDistance;
        
        return treeHeight;
        
    }
}
