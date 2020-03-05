package util;

public class InvalidPasswordException extends Exception {
    
    public InvalidPasswordException() {
        super("Erro durante uma operacao com a senha.");
    }
    
    public InvalidPasswordException(String string) {
        super(string);
    }
}
