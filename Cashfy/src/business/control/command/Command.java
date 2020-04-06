package business.control.command;

import util.InfraException;
import util.UnsuccessfulOperationException;

/** Interface de Comando
 * Implementa o padrão de projeto Command
 */
public interface Command {
    Object execute(String[] params) throws UnsuccessfulOperationException, InfraException;
}
