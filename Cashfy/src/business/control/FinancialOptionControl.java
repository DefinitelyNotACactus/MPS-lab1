/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business.control;

import business.model.FinancialOption;
import business.model.User;
import infra.PersistenceFactory;
import java.util.HashMap;
import java.util.Map;
import util.InfraException;
import util.InvalidAddException;

/**
 *
 * @author pablo
 */
public class FinancialOptionControl {
    
    private Map<String,FinancialOption> options;

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
            options.put(params[i], new FinancialOption(Integer.parseInt(params[i]),params[i+1],Integer.parseInt(params[i+2])));
        }
    }
    
    public void listAll() {
        // TODO
    }
    
    public String list(String id)  {
        if(options.containsKey(id)) {
            FinancialOption target = options.get(id);
            return "Opcao financeira " + id + ":\n"
                    + " Nome - " + target.getName()
                    + " Valor - " + target.getValue();
        } else {
            return "nao encontrado";
        }
    }
    
    public void update(String id, int value)  {
        if(options.containsKey(id)) {
            FinancialOption target = options.get(id);
            target.setValue(value);
        } else {
            //TODO
        }
    }
}
