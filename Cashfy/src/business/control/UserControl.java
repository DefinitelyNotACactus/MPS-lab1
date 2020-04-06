package business.control;

import java.util.HashMap;
import business.model.User;
import infra.PersistenceFactory;

import java.util.Map;
import util.InfraException;
import util.InvalidAddException;
import util.InvalidPasswordException;
import util.InvalidUsernameException;

public class UserControl {

    private Map<String,User> users;

    public UserControl() throws InfraException {
        users = new PersistenceFactory().getPersistence("User").load();
    }

    public UserControl(HashMap<String, User> users) {
        this.users = users;
    }
     
    public void add(String[] params) throws InvalidUsernameException, InvalidPasswordException, InvalidAddException {
        if(params.length % 2 != 0) {
            throw new InvalidAddException("Foram informados menos parametros do que o necessario: " + params.length);
        }
        for(int i = 0; i < params.length; i += 2) {
            if(new ValidateLogin().validate(params[i]) && new ValidatePassword().validate(params[i+1])){
                users.put(params[i], new User(params[i],params[i+1]));
            }
        }
    }
    
    public void listAll() {
        // TODO
    }

    /** Procura por um usuário na base de dados utilizando o login deste, listando as informações caso existam.
     * @param login O login do usuário a ser procurado
     * @return Uma string informando se o usuário existe e informações sobre este usuário
     * @throws InvalidUsernameException Caso o login informado não exista
     */
    public String list(String login) throws InvalidUsernameException {
        AccountStatus as = AccountStatusAdapter.getInstance();

        if(users.containsKey(login)) {
            User target = users.get(login);
            return "Usuário " + target.getLogin() + " existe e está " + (as.isActive(target) ? "ativo" : "inativo");
        } else {
            throw new InvalidUsernameException("Login do usuário informado não existe!");
        }
    }

    public void del(String login) throws InvalidUsernameException {
        if(users.containsKey(login)) {
            users.remove(login);
        } else {
            throw new InvalidUsernameException("Login do usuário informado não existe!");
        }
    }

    public void save() throws InfraException {
        new PersistenceFactory().getPersistence("User").save(users);
    }
}
