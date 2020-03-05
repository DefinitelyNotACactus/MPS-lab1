package util;

public class InfraException extends Exception {

    public InfraException() {
        super("Erro na aplicacao, consulte o SysAdmin");
    }
    
    public InfraException(String message) {
        super(message);
    }
    
}
