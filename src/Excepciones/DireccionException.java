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
public class DireccionException extends Exception {

    /**
     * Creates a new instance of <code>DireccionException</code> without detail
     * message.
     */
    public DireccionException() {
    }

    /**
     * Constructs an instance of <code>DireccionException</code> with the
     * specified detail message.
     *
     * @param msg the detail message.
     */
    public DireccionException(String msg) {
        super(msg);
    }
}
