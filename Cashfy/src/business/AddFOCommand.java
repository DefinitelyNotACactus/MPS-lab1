/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business;

import business.control.FinancialOptionControl;
import java.util.logging.Level;
import java.util.logging.Logger;
import util.InvalidAddException;
import util.UnsuccessfulOperationException;

/**
 *
 * @author pablo
 */
public class AddFOCommand implements Command {

    private final FinancialOptionControl FOControl;

    public AddFOCommand(FinancialOptionControl FOControl) {
        this.FOControl = FOControl;
    }
    
    @Override
    public Object execute(String[] params ) throws UnsuccessfulOperationException{
        try {
            FOControl.add(params);
        } catch (InvalidAddException ex) {
            throw new UnsuccessfulOperationException("Numero de parametros invalidos para Adicao de usuario(s).");
        }
        return null;
    }
    
}
