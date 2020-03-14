package business;

import util.ReportException;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/** Superclasse que implementa o template de um relatório
 * Implementa o padrão de projeto Template Method
 */
public abstract class ReportTemplate {

    private String name;

    public ReportTemplate(String name) {
        this.name = name;
    }

    /** Informa o formato do arquivo do relatório
     * @return Uma string informando o formato do arquivo
     */
    protected abstract String fileFormat();

    /** Formata os dados do relatório conforme o tipo de arquivo
     * @return Os dados formatados
     */
    protected abstract String formatData(String data);

    /* Gera um relatório */
    public final void generateReport(String data) throws ReportException {
        try {
            FileWriter fw = new FileWriter(name + fileFormat());
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write(formatData(data));
            bw.close();
        } catch (IOException ex) {
            Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, null, ex);
            throw new ReportException();
        }
    }
}
