package infra;

import business.model.FinancialOption;

/** Classe que implementa a persistência de dados de opções financeiras (i.e. leitura e escrita da base de dados do sistema)
 * Implementa o padrão de projeto Singleton
 */
public class OptionPersistence extends Persistence<String, FinancialOption> {

    private static OptionPersistence instance = new OptionPersistence();

    private OptionPersistence() {
        super("./database/options.ser");
    }

    /** Padrão de projeto: Singleton
     * Garantir que exista apenas um objeto do tipo OptionPersistence
     * @return A única instância de OptionPersistence
     */
    public static synchronized OptionPersistence getInstance() {
        return instance;
    }

}
