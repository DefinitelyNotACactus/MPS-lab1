package business.control;

import java.util.HashMap;
import business.model.User;
import infra.UserPersistence;
import java.util.Map;
import util.InfraException;
import util.InvalidAddException;
import util.InvalidPasswordException;
import util.InvalidUsernameException;

public class UserControl {
    
    private UserPersistence persistence;
    private Map<String,User> users;

    public UserControl() throws InfraException {
        persistence = new UserPersistence();
        users = persistence.loadUsers();
    }

    public UserControl(HashMap<String, User> users) {
        this.users = users;
    }
    
    private boolean validateLogin(String login) throws InvalidUsernameException {
        if(login.isEmpty()) {
            throw new InvalidUsernameException("Nome de Usuario Invalido: Vazio");
        } else if(login.length() > 20) {
            throw new InvalidUsernameException("Nome de Usuario Invalido: Tamanho maximo excedido");
        } else if(login.matches(".*\\d.*")){
            throw new InvalidUsernameException("Nome de Usuario Invalido: Contem numero");
        }
        
        return true;
    }
    
     private boolean validatePassword(String password) throws InvalidPasswordException {
        if(password.length() < 8) {
            throw new InvalidPasswordException("Senha Invalida: Menor que o minimo de caracteres (8)");
        } else if(password.length() > 12) {
            throw new InvalidPasswordException("Senha Invalida: Maior que o maximo de caracteres (12)");
        } else if(!password.matches(".*\\d.*.*\\d.*")){
            throw new InvalidPasswordException("Senha Invalida: Contem menos de 2 numeros");
        } else if(!password.matches(".*[a-zA-Z].*")) {
            throw new InvalidPasswordException("Senha Invalida: Nao contem letras");   
        }
        
        return true;
    }
     
    public void add(String[] params) throws InvalidUsernameException, InvalidPasswordException, InvalidAddException {
        if(params.length % 2 != 0) {
            throw new InvalidAddException("Foram informados menos parametros do que o necessario: " + params.length);
        }
        for(int i = 0; i < params.length; i +=2) {
            if(validateLogin(params[i]) && validatePassword(params[i+1])){
                users.put(params[i], new User(params[i],params[i+1]));
            }
        }
    }
    
    public void listAll() {
        // TODO
    }
    
    public void list(String login) {
        // TODO
    }
    
    public void del(String login) throws InvalidUsernameException {
        if(users.containsKey(login)) {
            users.remove(login);
        } else {
            throw new InvalidUsernameException("Login do usuario informado nao existe!");
        }
    }
}
