package business.control.command;

import business.control.FinancialOptionControl;
import util.InfraException;
import util.UnsuccessfulOperationException;

/** Classe que implementa o comando concreto de salvar opções financeiras
 * Implementa o padrão de projeto Command
 */
public class SaveFOCommand implements Command {
    private final FinancialOptionControl FOControl;

    public SaveFOCommand(FinancialOptionControl FOControl) {
        this.FOControl = FOControl;
    }

    @Override
    public Object execute(String[] params) throws InfraException {
        FOControl.save();
        return null;
    }
}
