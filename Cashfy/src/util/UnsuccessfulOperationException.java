/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

/**
 *
 * @author pablo
 */
public class UnsuccessfulOperationException extends Exception{
    
    public  UnsuccessfulOperationException() {
        super("Erro durante uma operacao.");
    }
    
    public  UnsuccessfulOperationException(String string) {
        super(string);
    }
}
