package business.model.memento;

import business.model.FinancialOption;

/** Classe Memento de uma opção financeira
 * Implementa o padrão de projeto Memento
 */
public class FOMemento {
    private final double state; // O estado será o valor da opção financeira, pois ela varia com a tempo

    public FOMemento(double state) {
        this.state = state;
    }

    public double getState() {
        return state;
    }
}
