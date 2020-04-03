package business;

import business.control.FinancialOptionControl;
import business.control.NewsControl;
import business.control.UserControl;
import java.util.Map;
import java.util.HashMap;

import business.control.command.*;
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
    private Map<String, Command> foCommands;

    public FacadeBusiness() throws InfraException {
        this.uc = new UserControl();
        this.nc = new NewsControl();
        this.fc = new FinancialOptionControl();
        
        foCommands = new HashMap<>();
        foCommands.put("add", new AddFOCommand(fc));
        foCommands.put("search", new SearchFOCommand(fc));
        foCommands.put("update", new UpdateFOCommand(fc));
        foCommands.put("undo", new UndoFOUpdateCommand(fc));
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
    
    public Object executeFOOperation(String op, String[] params) throws UnsuccessfulOperationException {
        Command c = foCommands.get(op);
        return c.execute(params);
    }
}   
