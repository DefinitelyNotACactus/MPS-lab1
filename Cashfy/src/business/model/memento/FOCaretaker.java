package business.model.memento;

import java.util.ArrayList;
import java.util.List;

/** Classe que implementa o zelador dos estados de uma opção financeira
 * Implementa o padrão de projeto Memento
 */
public class FOCaretaker {
    private List<FOMemento> mementoList;

    public FOCaretaker() {
        mementoList = new ArrayList<>();
    }

    public void addMemento(FOMemento memento) {
        mementoList.add(memento);
    }

    public FOMemento getLatestMemento() {
        if(mementoList.isEmpty()) {
            return null;
        }
        return mementoList.remove(mementoList.size() - 1); // Remove o último memento e o retorna
    }
}
