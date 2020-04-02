/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business;

import util.UnsuccessfulOperationException;

/**
 *
 * @author pablo
 */
public interface Command {
    
    public Object execute(String[] params) throws UnsuccessfulOperationException;
}
