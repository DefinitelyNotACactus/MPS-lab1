package business.control.command;

import business.control.FinancialOptionControl;

/** Classe que implementa o comando concreto de pesquisa por opção financeira
 * Implementa o padrão de projeto Command
 */
public class SearchFOCommand implements Command {
    
    private final FinancialOptionControl FOControl;

    public SearchFOCommand(FinancialOptionControl FOControl) {
        this.FOControl = FOControl;
    }
    
    @Override
    public Object execute(String[] params ) {
        String id = params[0];
        return FOControl.list(id);
    }
    
}
