package infra;

import business.model.User;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import util.InfraException;

public class UserPersistence {
    
    private File file;
    
    public UserPersistence(String filename) {
        file = new File(filename);
    }
    
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
            Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, null, ex);
            throw new InfraException("Erro ao carregar a base de dados, tente novamente mais tarde!");
        }
    }
    
    public void saveUsers(Map<String, User> users) throws InfraException {
        try {
            FileOutputStream out = new FileOutputStream(file);
            ObjectOutputStream objectStream = new ObjectOutputStream(out);
            objectStream.writeObject(users);
            objectStream.close();
            out.close();
        } catch(IOException ex) {
            Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, null, ex);
            throw new InfraException("Erro ao salvar na base de dados, tente novamente mais tarde!");
        }
    }
}
