package business.control;

import business.model.User;

/** Define a interface requerida para a checagem do status da conta do usuário
 * Implementa o padrão de projeto Adapter
 */
public interface AccountStatus {
    boolean isActive(User user);
}
