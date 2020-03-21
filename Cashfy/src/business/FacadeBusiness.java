package business;

import business.control.NewsControl;
import business.control.UserControl;
import util.InvalidAddException;
import util.InvalidPasswordException;
import util.InvalidUsernameException;
import util.InfraException;

/** Fachada para os serviços de NewsControl e UserControl em Business
 * Implementa o padrão de projeto Facade
 */
public class FacadeBusiness {

    private UserControl uc;
    private NewsControl nc;

    public FacadeBusiness() throws InfraException {
        this.uc = new UserControl();
        this.nc = new NewsControl();
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
}
