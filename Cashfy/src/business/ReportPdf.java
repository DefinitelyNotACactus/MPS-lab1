package business;

/** Subclasse que implementa os métodos abstratos de ReportTemplate
 * Implementa o padrão de projeto Template Method
 */
public class ReportPdf extends ReportTemplate {

    public ReportPdf(String name) {
        super(name);
    }

    @Override
    protected String fileFormat() {
        return ".pdf";
    }

    @Override
    protected String formatData(String data) {
        return "Início PDF\n" + data + "Fim PDF"; // Não é um PDF de verdade!
    }
}
