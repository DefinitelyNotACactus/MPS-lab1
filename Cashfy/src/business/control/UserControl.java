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
        persistence = UserPersistence.getInstance();
        users = persistence.loadUsers();
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
