package infra;

import business.model.Asset;

/** Classe que implementa a persistência de dados de carteira e aplicações (i.e. leitura e escrita da base de dados do sistema)
 * Implementa o padrão de projeto Singleton
 */
public class WalletPersistence extends Persistence<String, Asset> {

    private static WalletPersistence instance;

    private WalletPersistence() {
        super("./database/wallets.ser");
    }

    /** Padrão de projeto: Singleton
     * Garantir que exista apenas um objeto do tipo UserPersistence
     * @return A única instância de UserPersistence
     */
    public static synchronized WalletPersistence getInstance() {
        if(instance == null) {
            synchronized (UserPersistence.class) {
                if(instance == null) {
                    instance = new WalletPersistence();
                }
            }
        }
        return instance;
    }
}
