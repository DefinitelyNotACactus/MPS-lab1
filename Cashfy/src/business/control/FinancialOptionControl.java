package business.control;

import java.util.HashMap;
import java.util.Map;
import business.model.FinancialOption;
import infra.PersistenceFactory;
import util.InfraException;
import util.InvalidAddException;
import util.UnsuccessfulOperationException;

/**
 *
 * @author pablo
 */
public class FinancialOptionControl {
    
    private Map<String, FinancialOption> options;

    @SuppressWarnings("unchecked")
	public FinancialOptionControl() throws InfraException {
        options = new PersistenceFactory().getPersistence("Options").load();
    }

    public FinancialOptionControl(HashMap<String, FinancialOption> options) {
        this.options = options;
    }
     
    public void add(String[] params) throws InvalidAddException {
        if(params.length % 3 != 0) {
            throw new InvalidAddException("Foram informados menos parametros do que o necessario: " + params.length);
        }
        for(int i = 0; i < params.length; i += 3) {
            options.put(params[i], new FinancialOption(Integer.parseInt(params[i]), params[i+1], Double.parseDouble(params[i+2])));
        }
    }
    
    public void listAll() {
       // TODO
    }
    
    public String list(String id)  {
        if(options.containsKey(id)) {
            FinancialOption target = options.get(id);
            return "Opcao financeira " + target.getId() + ":\n"
                    + " Nome - " + target.getName()
                    + " Valor - " + target.getValue();
        }

        return "não encontrado";
    }
    
    public void update(String id, double value) throws UnsuccessfulOperationException {
        if(options.containsKey(id)) {
            FinancialOption target = options.get(id);
            target.updateValue(value);
        } else {
            throw new UnsuccessfulOperationException("Tentativa de atualizar opção financeira que não existe: " + id);
        }
    }

    public void undoUpdate(String id) throws UnsuccessfulOperationException {
        if(options.containsKey(id)) {
            FinancialOption target = options.get(id);
            target.undoUpdate();
        } else {
            throw new UnsuccessfulOperationException("Tentativa de atualizar opção financeira que não existe: " + id);
        }
    }

    @SuppressWarnings("unchecked")
	public void save() throws InfraException {
        new PersistenceFactory().getPersistence("Options").save(options);
    }
}
