package de.pheru.util.logitech.exceptions;

/**
 *
 * @author Philipp Bruckner
 */
public class NoKeyboardConnectedException extends Exception{
    
    public NoKeyboardConnectedException(){
    }
    
    public NoKeyboardConnectedException(String msg){
        super(msg);
    }
}
