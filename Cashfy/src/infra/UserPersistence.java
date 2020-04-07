package infra;

import business.model.User;

/** Classe que implementa a persistência de dados de usuário (i.e. leitura e escrita da base de dados do sistema)
 * Implementa o padrão de projeto Singleton
 */
public class UserPersistence extends Persistence<String, User> {
    
    private static UserPersistence instance;
    
    private UserPersistence() {
        super("./database/users.ser");
    }

    /** Padrão de projeto: Singleton
     * Garantir que exista apenas um objeto do tipo UserPersistence
     * @return A única instância de UserPersistence
     */
    public static synchronized UserPersistence getInstance() {
        if(instance == null) {
        	synchronized (UserPersistence.class) {
				if(instance == null) {
					instance = new UserPersistence();
				}
			}
        }
        return instance;
    }
}
