package infra;

import business.model.User;

/** Classe que implementa a persistência de dados de usuário (i.e. leitura e escrita da base de dados do sistema)
 * Implementa o padrão de projeto Singleton
 */
public class UserPersistence extends Persistence<String, User> {
    
    private static UserPersistence instance = new UserPersistence();
    
    private UserPersistence() {
        super("/home/pablo/workspace/MPS-lab2/database/users.ser");
    }

    /** Padrão de projeto: Singleton
     * Garantir que exista apenas um objeto do tipo UserPersistence
     * @return A única instância de UserPersistence
     */
    public static synchronized UserPersistence getInstance() {
        return instance;
    }
}
