package business.control;

import util.InvalidPasswordException;
import util.InvalidUsernameException;

/** Interface com as estratégias de validação do input do usuário
 * Padrão de projeto: Strategy
 */
public interface Validate {
    boolean validate(String input) throws InvalidUsernameException, InvalidPasswordException;
}
