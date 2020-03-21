package business.control;

import business.model.User;

/* Classe para checar se a conta do usuário está ativa ou não */
public class AccountStatusAPI {

    public boolean isAccountActive(User user, boolean activate) {
        if(activate) {
            activateAccount();
        }

        return getActivityStatus(user);
    }

    private void activateAccount() {
        // Atualizar atividade
    }

    private boolean getActivityStatus(User user) {
        return true;
    }
}
