/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.desertEscape.control;

import byui.cit260.desertEscape.exeptions.ManufactureControlException;
import desert.escape.DesertEscape;
import java.io.BufferedReader;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author tallroids
 */
public class ManufactureControlTest {
    
    protected final BufferedReader keyboard = DesertEscape.getInFile();
    protected final PrintWriter console = DesertEscape.getOutFile();

    public ManufactureControlTest() {
    }

    /**
     * Test of calcShovelVolume method, of class ManufactureControl.
     */
    @Test
    public void testCalcShovelVolume() {
        this.console.println("calcShovelVolume");
        /** Test case #1 **/
        this.console.println("/tTest case #1");
        
        // input values for test case 1
        double shovelLength = 2.0;
        double shovelWidth = 4.0;
        double shovelDepth = 5.0;
        
        double expResult = 40.0; // expected output returned value
        // create instance of ManufactureControl class
        ManufactureControl instance = new ManufactureControl();
        
        // call function to run test
        double result;
        try {
            result = instance.calcShovelVolume(shovelLength, shovelWidth, shovelDepth);        
            assertEquals(expResult, result, 0.0);

        } catch (ManufactureControlException ex) {
            Logger.getLogger(ManufactureControlTest.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        // compare expected return value with actual value returned
        
         /** Test case #2 **/
        this.console.println("/tTest case #2");
        
        // input values for test case 2
        shovelLength = -2.0;
        shovelWidth = 4.0;
        shovelDepth = 5.0;
        
        expResult = -1; // expected output returned value
        try {
            // call function to run test
            result = instance.calcShovelVolume(shovelLength, shovelWidth, shovelDepth);
            assertEquals(expResult, result, 0.0);
        } catch (ManufactureControlException ex) {
            Logger.getLogger(ManufactureControlTest.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        // compare expected return value with actual value returned
        
        
        /** Test case #3 **/
        this.console.println("/tTest case #3");
        
        // input values for test case 3
        shovelLength = 2;
        shovelWidth = -1;
        shovelDepth = 5;
        
        expResult = -1; // expected output returned value
        try {
            // call function to run test
            result = instance.calcShovelVolume(shovelLength, shovelWidth, shovelDepth);
            assertEquals(expResult, result, 0.0);

        } catch (ManufactureControlException ex) {
            Logger.getLogger(ManufactureControlTest.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        // compare expected return value with actual value returned
        
        /** Test case #4 **/
        this.console.println("/tTest case #4");
        
        // input values for test case 4
        shovelLength = 2;
        shovelWidth = 5;
        shovelDepth = -3;
        
        expResult = -1; // expected output returned value
        try {
            // call function to run test
            result = instance.calcShovelVolume(shovelLength, shovelWidth, shovelDepth);
            assertEquals(expResult, result, 0.0);

        } catch (ManufactureControlException ex) {
            Logger.getLogger(ManufactureControlTest.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        // compare expected return value with actual value returned
        
        /** Test case #5 **/
        this.console.println("/tTest case #5");
        
        // input values for test case 5
        shovelLength = 0;
        shovelWidth = 0;
        shovelDepth = 1;
        
        expResult = 0; // expected output returned value
        try {
            // call function to run test
            result = instance.calcShovelVolume(shovelLength, shovelWidth, shovelDepth);
                    assertEquals(expResult, result, 0.0);

        } catch (ManufactureControlException ex) {
            Logger.getLogger(ManufactureControlTest.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        // compare expected return value with actual value returned
        
        /** Test case #6 **/
        this.console.println("/tTest case #6");
        
        // input values for test case 6
        shovelLength = 1;
        shovelWidth = 0;
        shovelDepth = 0;
        
        expResult = 0; // expected output returned value
        try {
            // call function to run test
            result = instance.calcShovelVolume(shovelLength, shovelWidth, shovelDepth);
                    assertEquals(expResult, result, 0.0);

        } catch (ManufactureControlException ex) {
            Logger.getLogger(ManufactureControlTest.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        // compare expected return value with actual value returned
        
        /** Test case #7 **/
        this.console.println("/tTest case #7");
        
        // input values for test case 7
        shovelLength = 0;
        shovelWidth = 1;
        shovelDepth = 0;
        
        expResult = 0; // expected output returned value
        try {
            // call function to run test
            result = instance.calcShovelVolume(shovelLength, shovelWidth, shovelDepth);
                    assertEquals(expResult, result, 0.0);

        } catch (ManufactureControlException ex) {
            Logger.getLogger(ManufactureControlTest.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        // compare expected return value with actual value returned
        
        /** Test case #8 **/
        this.console.println("/tTest case #8");
        
        // input values for test case 8
        shovelLength = 10;
        shovelWidth = 10;
        shovelDepth = 10;
        
        expResult = 1000; // expected output returned value
        try {
            // call function to run test
            result = instance.calcShovelVolume(shovelLength, shovelWidth, shovelDepth);
                    assertEquals(expResult, result, 0.0);

        } catch (ManufactureControlException ex) {
            Logger.getLogger(ManufactureControlTest.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        // compare expected return value with actual value returned
                
    }

    /**
     * Test of calcShovelsFull method, of class ManufactureControl.
     */
    @Test
    public void testCalcShovelsFull() {
        this.console.println("calcShovelsFull");
        this.console.println("Test case #1");
        double shovelVolume = 20;
        double pitVolume = 80;
        ManufactureControl instance = new ManufactureControl();
        double expResult = 4;
        double result = instance.calcShovelsFull(shovelVolume, pitVolume);
        assertEquals(expResult, result, 0.0);
        
        this.console.println("Test case #2");
        shovelVolume = 20;
        pitVolume = -80;
        expResult = -1;
        result = instance.calcShovelsFull(shovelVolume, pitVolume);
        assertEquals(expResult, result, 0.0);
        
        this.console.println("Test case #3");
        shovelVolume = -1;
        pitVolume = 80;
        expResult = -1;
        result = instance.calcShovelsFull(shovelVolume, pitVolume);
        assertEquals(expResult, result, 0.0);
        
        this.console.println("Test case #4");
        shovelVolume = 0;
        pitVolume = 0;
        expResult = -1;
        result = instance.calcShovelsFull(shovelVolume, pitVolume);
        assertEquals(expResult, result, 0.0);
        
        this.console.println("Test case #5");
        shovelVolume = 100;
        pitVolume = 1000;
        expResult = 10;
        result = instance.calcShovelsFull(shovelVolume, pitVolume);
        assertEquals(expResult, result, 0.0);
                
    }

    /**
     * Test of calcTreeHeight method, of class ManufactureControl.
     */
    @Test
    public void testCalcTreeHeight() {
        this.console.println("calcTreeHeight");
        this.console.println("Test case #1");
        double treeDistance = 2.0;
        double treeAngle = 4.0;
        ManufactureControl instance = new ManufactureControl();
        double expResult = 2.3156425646991554;
        double result = instance.calcTreeHeight(treeDistance, treeAngle);
        assertEquals(expResult, result, 0.0);
        
        this.console.println("calcTreeHeight");
        this.console.println("Test case #2");
        treeDistance = -2.0;
        treeAngle = 4.0;
        expResult = -1.0;
        result = instance.calcTreeHeight(treeDistance, treeAngle);
        assertEquals(expResult, result, 0.0);
        
        this.console.println("calcTreeHeight");
        this.console.println("Test case #3");
        treeDistance = 45.0;
        treeAngle = -2.0;
        expResult = -1.0;
        result = instance.calcTreeHeight(treeDistance, treeAngle);
        assertEquals(expResult, result, 0.0);
        
        this.console.println("calcTreeHeight");
        this.console.println("Test case #4");
        treeDistance = 1.0;
        treeAngle = 0.0;
        expResult = -1.0;
        result = instance.calcTreeHeight(treeDistance, treeAngle);
        assertEquals(expResult, result, 0.0);
        
        this.console.println("calcTreeHeight");
        this.console.println("Test case #5");
        treeDistance = 0.0;
        treeAngle = 1.0;
        expResult = -1.0;
        result = instance.calcTreeHeight(treeDistance, treeAngle);
        assertEquals(expResult, result, 0.0);
        
        this.console.println("calcTreeHeight");
        this.console.println("Test case #6");
        treeDistance = 5000.0;
        treeAngle = 179.0;
        expResult = -354.4984817273124;
        result = instance.calcTreeHeight(treeDistance, treeAngle);
        assertEquals(expResult, result, 0.0);
        
    }
    
}
