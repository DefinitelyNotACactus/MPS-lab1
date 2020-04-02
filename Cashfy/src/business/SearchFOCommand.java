/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business;

import business.control.FinancialOptionControl;
import util.UnsuccessfulOperationException;

/**
 *
 * @author pablo
 */
public class SearchFOCommand implements Command{
    
    private final FinancialOptionControl FOControl;

    public SearchFOCommand(FinancialOptionControl FOControl) {
        this.FOControl = FOControl;
    }
    
    @Override
    public Object execute(String[] params ) throws UnsuccessfulOperationException{
        String id = params[0];
        return FOControl.list(id);
    }
    
}
