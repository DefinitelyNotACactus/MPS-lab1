package util;

public class ReportException extends Exception {
    public ReportException() {
        super("Erro ao manusear o relatório, consulte o SysAdmin!");
    }

    public ReportException(String message) {
        super(message);
    }
}
