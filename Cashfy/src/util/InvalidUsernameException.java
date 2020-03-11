package util;

public class InvalidUsernameException extends Exception{

    public InvalidUsernameException() {
        super("Erro durante uma operacao com o login (nome de usuario)");
    }
    
    public InvalidUsernameException(String string) {
        super(string);
    }
}
