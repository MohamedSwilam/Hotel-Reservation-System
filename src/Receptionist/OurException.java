/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Receptionist;

/**
 *
 * @author moham
 */
public class OurException extends Exception {

    /**
     * Creates a new instance of <code>OurException</code> without detail
     * message.
     */
    public OurException() {
    }
    /**
     * Constructs an instance of <code>OurException</code> with the specified
     * detail message.
     *
     * @param msg the detail message.
     */
    public OurException(String msg) {
        super(msg);
    }
}
