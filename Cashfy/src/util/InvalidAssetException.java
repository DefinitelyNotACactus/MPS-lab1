package util;

public class InvalidAssetException extends Exception {
    public InvalidAssetException() {
        super("Erro ao manusear um bem financeiro.");
    }

    public InvalidAssetException(String message) {
        super(message);
    }
}
