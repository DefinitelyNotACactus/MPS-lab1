package business.model;

import business.model.memento.FOCaretaker;
import business.model.memento.FOMemento;

/** Entidade que representa uma opção financeira
 * @author pablo
 */
public class FinancialOption {
    private final int id;
    private final String name;
    private int value;
    private FOCaretaker caretaker;

    public FinancialOption(int id, String name, int value) {
        this.id = id;
        this.name = name;
        this.value = value;

        caretaker = new FOCaretaker();
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getValue() {
        return value;
    }

    /** Atualiza o valor da opção **/
    public void updateValue(int value) {
        caretaker.addMemento(new FOMemento(this.value));
        this.value = value;
    }

    /** Desfaz a atualização de valor, utilizando o memento **/
    public void undoUpdate() {
        value = caretaker.getLatestMemento().getState();
    }
}
