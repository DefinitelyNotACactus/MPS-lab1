package business.control.strategy;

import business.control.strategy.Validate;
import util.InvalidPasswordException;

/** Classe que implementa a validação de senha
 * Padrão de projeto: Strategy
 */
public class ValidatePassword implements Validate {

    public boolean validate(String input) throws InvalidPasswordException {
        if(input.length() < 8) {
            throw new InvalidPasswordException("Senha Invalida: Menor que o minimo de caracteres (8)");
        } else if(input.length() > 12) {
            throw new InvalidPasswordException("Senha Invalida: Maior que o maximo de caracteres (12)");
        } else if(!input.matches(".*\\d.*.*\\d.*")){
            throw new InvalidPasswordException("Senha Invalida: Contem menos de 2 numeros");
        } else if(!input.matches(".*[a-zA-Z].*")) {
            throw new InvalidPasswordException("Senha Invalida: Nao contem letras");
        }

        return true;
    }
}
