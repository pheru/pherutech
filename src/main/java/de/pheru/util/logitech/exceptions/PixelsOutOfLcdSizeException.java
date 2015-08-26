package de.pheru.util.logitech.exceptions;

/**
 *
 * @author Philipp Bruckner
 */
public class PixelsOutOfLcdSizeException extends Exception{
    
    public PixelsOutOfLcdSizeException(){
    }
    
    public PixelsOutOfLcdSizeException(String msg){
        super(msg);
    }
}
