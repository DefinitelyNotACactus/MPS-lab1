package util;

public class InvalidAddException extends Exception {

    public InvalidAddException() {
        super("A insercao efetuada eh invalida, provavelmente por falta de dados");
    }
    
    public InvalidAddException(String message) {
        super(message);
    }
}
