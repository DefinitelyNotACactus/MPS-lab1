package business;

import business.control.UserControl;
import util.InvalidAddException;
import util.InvalidPasswordException;
import util.InvalidUsernameException;
import util.InfraException;

public class FacadeBusiness {

    UserControl uc;

    public FacadeBusiness() throws InfraException {
        this.uc = new UserControl();
    }

    public void add(String[] params) throws InvalidUsernameException, InvalidPasswordException, InvalidAddException {
        uc.add(params);
    }

    public void listAll() {
        uc.listAll();
    }

    public void list(String login) {
        uc.list(login);
    }

    public void del(String login) throws InvalidUsernameException {
       uc.del(login);
    }
}
