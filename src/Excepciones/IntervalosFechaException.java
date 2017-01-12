/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Excepciones;

/**
 *
 * @author Esteban Pastelín
 */
public class IntervalosFechaException extends Exception {

    /**
     * Creates a new instance of <code>IntervalosFechaException</code> without
     * detail message.
     */
    public IntervalosFechaException() {
    }

    /**
     * Constructs an instance of <code>IntervalosFechaException</code> with the
     * specified detail message.
     *
     * @param msg the detail message.
     */
    public IntervalosFechaException(String msg) {
        super(msg);
    }
}
