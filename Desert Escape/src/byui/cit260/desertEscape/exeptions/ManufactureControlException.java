/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.desertEscape.exeptions;

/**
 *
 * @author daltonsolo
 */
public class ManufactureControlException extends Exception {

    public ManufactureControlException() {
    }

    public ManufactureControlException(String message) {
        super(message);
    }

    public ManufactureControlException(String message, Throwable cause) {
        super(message, cause);
    }

    public ManufactureControlException(Throwable cause) {
        super(cause);
    }

    public ManufactureControlException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
    
}
