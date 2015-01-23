package de.eru.pherutech.exceptions;

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
