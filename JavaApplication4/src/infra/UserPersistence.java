/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package infra;

import business.model.User;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import util.InfraException;

/**
 *
 * @author aluno
 */
public class UserPersistence {
    
    private File file;
    
    public UserPersistence() {
        file = new File("users.txt");
    }
    
    public Map<String, User> loadUsers() throws InfraException {
        try {
            FileInputStream in = new FileInputStream(file);
            ObjectInputStream objectStream = new ObjectInputStream(in);
            Map<String, User> users = (HashMap) objectStream.readObject();
            objectStream.close();
            in.close();
            
            return users;
        } catch(ClassNotFoundException | IOException ex) {
            throw new InfraException("Erro durante a leitura do banco de dados. Contate o SysAdmin!");
            // LOGAR
        }
    }
    
    public void saveUsers(Map<String, User> users) throws IOException {
        FileOutputStream out = new FileOutputStream(file);
        ObjectOutputStream objectStream = new ObjectOutputStream(out);
        objectStream.writeObject(users);
        objectStream.close();
        out.close();
    }
}
