package business.control;

import util.InvalidUsernameException;

/** Classe que implementa a validação de login
 * Padrão de projeto: Strategy
 */
public class ValidateLogin implements Validate {

    public boolean validate(String input) throws InvalidUsernameException {
        if(input.isEmpty()) {
            throw new InvalidUsernameException("Nome de Usuario Invalido: Vazio");
        } else if(input.length() > 20) {
            throw new InvalidUsernameException("Nome de Usuario Invalido: Tamanho maximo excedido");
        } else if(input.matches(".*\\d.*")){
            throw new InvalidUsernameException("Nome de Usuario Invalido: Contem numero");
        }

        return true;
    }
}
