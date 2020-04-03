package business.control.command;

import business.control.FinancialOptionControl;
import util.InvalidAddException;
import util.UnsuccessfulOperationException;

/** Classe que implementa o comando concreto de adicionar uma nova opção financeira
 * Implementa o padrão de projeto Command
 */
public class AddFOCommand implements Command {

    private final FinancialOptionControl FOControl;

    public AddFOCommand(FinancialOptionControl FOControl) {
        this.FOControl = FOControl;
    }
    
    @Override
    public Object execute(String[] params ) throws UnsuccessfulOperationException {
        try {
            FOControl.add(params);
        } catch (InvalidAddException ex) {
            throw new UnsuccessfulOperationException("Numero de parametros invalidos para Adicao de usuario(s).");
        }
        return null;
    }
    
}
