/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.desertEscape.view;

import desert.escape.DesertEscape;
import java.io.PrintWriter;

/**
 *
 * @author tallroids
 */
public class ErrorView {
    
    private static final PrintWriter errorFile = DesertEscape.getOutFile();
    private static final PrintWriter logFile = DesertEscape.getLogFile();
    
    public static void display(String className, String errorMessage) {
        
        errorFile.println(
        "----------------------------------------"
        + "\n- ERROR -\n" + errorMessage
        + "\n----------------------------------------");
        
        // log error
        logFile.println(className + " - " + errorMessage);
    }
}
