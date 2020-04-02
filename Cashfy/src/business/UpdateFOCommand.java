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
public class UpdateFOCommand implements Command{

    private final FinancialOptionControl FOControl;

    public UpdateFOCommand(FinancialOptionControl FOControl) {
        this.FOControl = FOControl;
    }
    
    @Override
    public Object execute(String[] params ) throws UnsuccessfulOperationException{
        String id = params[0];
        int value = Integer.parseInt(params[1]);
        FOControl.update(id,value);
        return null;
    }
    
}
