package business.control.command;

import business.control.FinancialOptionControl;
import util.UnsuccessfulOperationException;

/** Classe que implementa o comando concreto de atualizar uma opção financeira
 *  Implementa o padrão de projeto Command
 */
public class UpdateFOCommand implements Command {

    private final FinancialOptionControl FOControl;

    public UpdateFOCommand(FinancialOptionControl FOControl) {
        this.FOControl = FOControl;
    }
    
    @Override
    public Object execute(String[] params) throws UnsuccessfulOperationException {
        String id = params[0];
        double value = Double.parseDouble(params[1]);
        FOControl.update(id, value);
        return null;
    }
    
}
