package view;

import business.control.UserControl;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.logging.Level;
import java.util.logging.Logger;
import util.InfraException;
import util.InvalidAddException;
import util.InvalidPasswordException;
import util.InvalidUsernameException;

public class UserForm {
    
    private UserControl uc;
    
    public UserForm() {
        try {
            uc = new UserControl();
        } catch (InfraException ex) {
            System.out.println(ex.getMessage());
            System.exit(-1);
        }
    }
    
    public void formMainLoop() {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Cadastro de usuario");
        while(true) {
            String[] params = new String[2];
            System.out.println("Insira o nome:");
            try {
                params[0] = br.readLine();
                System.out.println("Digite uma senha: ");
                params[1] = br.readLine();
                uc.add(params);
                System.out.println("Usuario cadastrado!");
            } catch(IOException ex) {
                System.out.println("Erro inesperado durante a leitura da entrada!");
                Logger.getLogger(UserForm.class.getName()).log(Level.SEVERE, null, ex);
            } catch (InvalidUsernameException | InvalidPasswordException | InvalidAddException ex ) {
                System.out.println("O seguinte erro ocorreu:\n" + ex.getMessage());
                Logger.getLogger(UserForm.class.getName()).log(Level.SEVERE, null, ex);
            }
            System.out.println("Deseja cadastrar outro usuario? Pressione S para continuar, qualquer outra coisa para nao.");
            try {
                if(!br.readLine().equals("S")) {
                    break;
                }
            } catch(IOException ex) {
                System.out.println("Erro inesperado durante a leitura da entrada!");
                Logger.getLogger(UserForm.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    } 
}


    
