package business;

import business.control.FinancialOptionControl;
import business.control.NewsControl;
import business.control.UserControl;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import util.InvalidAddException;
import util.InvalidPasswordException;
import util.InvalidUsernameException;
import util.InfraException;
import util.UnsuccessfulOperationException;

/** Fachada para os serviços de NewsControl e UserControl em Business
 * Implementa o padrão de projeto Facade
 */
public class FacadeBusiness {

    private UserControl uc;
    private NewsControl nc;
    
    private FinancialOptionControl fc;
    private HashMap<String, Command> cmds;

    public FacadeBusiness() throws InfraException {
        this.uc = new UserControl();
        this.nc = new NewsControl();
        this.fc = new FinancialOptionControl();
        
        this.cmds = new HashMap<>();
        cmds.put("add", new AddFOCommand(fc));
        cmds.put("search", new SearchFOCommand(fc));
        cmds.put("update", new UpdateFOCommand(fc));
    }

    public void addUser(String[] params) throws InvalidUsernameException, InvalidPasswordException, InvalidAddException {
        uc.add(params);
    }

    public void listAllUsers() {
        uc.listAll();
    }

    public void listUser(String login) throws InvalidUsernameException {
        uc.list(login);
    }

    public void delUser(String login) throws InvalidUsernameException {
       uc.del(login);
    }

    public void addNews(String[] params) throws InvalidAddException {
        nc.add(params);
    }

    public void listAllNews() {
        nc.listAll();
    }

    public void listNews(String title) {
        nc.list(title);
    }
    
    public Object executeFOOperation(String op, String[] params) {
        Command c = cmds.get(op);
        try {
            return c.execute(params);
        } catch (UnsuccessfulOperationException ex) {
            //TODO
            Logger.getLogger(FacadeBusiness.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}   
