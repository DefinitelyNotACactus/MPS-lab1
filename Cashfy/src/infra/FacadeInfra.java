package infra;

import business.model.User;
import util.InfraException;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

/** Classe que implementa fachada para infraestrutura
 * Padrâo de projeto: Facade
 */
public class FacadeInfra {

    public Map<String, User> loadUsers() throws InfraException {
        return UserPersistence.getInstance().loadUsers();
    }

    public void saveUsers(Map<String, User> users) throws InfraException {
        UserPersistence.getInstance().saveUsers(users);
    }
}
