package business;

/** Subclasse que implementa os métodos abstratos de ReportTemplate
 * Implementa o padrão de projeto Template Method
 */
public class ReportHtml extends ReportTemplate {

    public ReportHtml(String name) {
        super(name);
    }

    @Override
    protected String fileFormat() {
        return ".html";
    }

    @Override
    protected String formatData(String data) {
        return "<html>" + data + "</html>";
    }
}
