package business.control;

import business.model.User;

/** Classe que implementa o adaptor da interface de AccountStatusAPI para a interface AccountStatus
 * Implementa o padrão de projeto Adapter e Singleton
 */
public class AccountStatusAdapter extends AccountStatusAPI implements AccountStatus {
    private static AccountStatus instance = new AccountStatusAdapter();

    private AccountStatusAdapter() {
    }

    public boolean isActive(User user) {
        return isAccountActive(user, false);
    }

    /** Padrão de projeto: Singleton
     * Garantir que exista apenas um objeto do tipo AccountStatus
     * @return A única instância de AccountStatus
     */
    public static AccountStatus getInstance() {
        return instance;
    }
}
