/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business.control;

import java.util.HashMap;
import business.model.User;
import infra.UserPersistence;
import java.util.Map;
import java.util.Map.Entry;
import util.InfraException;
import util.InvalidAddException;
import util.InvalidPasswordException;
import util.InvalidUsernameException;

/**
 *
 * @author aluno
 */
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
        if(login.equals("")) {
            throw new InvalidUsernameException("Nome de Usuario Invalido: Vazio");
        }   
        else if(login.length() > 20) {
            throw new InvalidUsernameException("Nome de Usuario Invalido: Tamanho maximo excedido");
        }
        else if(login.matches(".*\\d.*")){
            throw new InvalidUsernameException("Nome de Usuario Invalido: Contem numero");
        }
        
        return true;
    }
    
     private boolean validatePass(String pass) throws InvalidPasswordException {
        if(pass.length() < 8) {
            throw new InvalidPasswordException("Senha Invalida: Menor que o minimo de caracteres (8)");
        }   
        else if(pass.length() > 12) {
            throw new InvalidPasswordException("Senha Invalida: Maior que o maximo de caracteres (12)");
        }
        else if(!pass.matches("(\\w|\\d)*\\d(\\w|\\d)*\\d(\\w|\\d)*")){ // TODO: FIX REGEX
            throw new InvalidPasswordException("Senha Invalida: Contem menos de 2 numeros");
        }
        
        return true;
    }
     
    public void add(String[] params) throws InvalidUsernameException, InvalidPasswordException, InvalidAddException {
        String password = null, login = null;
        if(params.length % 2 != 0) {
            throw new InvalidAddException("Foram informados menos parametros do que o necessario: " + params.length);
        }
        for(int i = 0; i < params.length; i +=2) {
            if(validateLogin(params[i]) && validatePass(params[i+1])){
                users.put(login, new User(params[i],params[i+1]));
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
