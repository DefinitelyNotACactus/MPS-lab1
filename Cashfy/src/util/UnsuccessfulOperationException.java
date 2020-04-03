package util;

/**
 *
 * @author pablo
 */
public class UnsuccessfulOperationException extends Exception{
    
    public  UnsuccessfulOperationException() {
        super("Erro durante uma operacao.");
    }
    
    public  UnsuccessfulOperationException(String string) {
        super(string);
    }
}
