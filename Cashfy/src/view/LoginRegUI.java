/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import business.FacadeBusiness;
import java.awt.event.ActionEvent;
import java.util.HashMap;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import util.InvalidAddException;
import util.InvalidPasswordException;
import util.InvalidUsernameException;

/**
 *
 * @author pablo
 */
public class LoginRegUI extends JPanel implements Prototype{
    private FacadeBusiness facade;     
    private JFrame frame;
    
    private JTextField loginField;
    private JPasswordField passwordField;
    private HashMap<String,JTextField> addtionalFields;
    
    private JLabel auxLabel;

    public LoginRegUI(JFrame frame,FacadeBusiness facade) {
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.frame = frame;
        this.facade = facade;
        initBaseComponents();
        addLoginComponents();
    }
    
    private void initBaseComponents() {
        loginField = new JTextField();
        passwordField = new JPasswordField();

        auxLabel = new JLabel("");

        this.add(new JLabel("Cashfy"));

        this.add(new JLabel("Login"));
        this.add(loginField);

        this.add(new JLabel("Senha"));
        this.add(passwordField);  
    }
    
    private void addLoginComponents() {
        this.add(auxLabel);
        
        JButton btAuth = new JButton("Autenticar");
        btAuth.addActionListener(this::btAuthActionPerformed);

        JButton btRegister = new JButton("Registrar-se");
        btRegister.addActionListener(this::btRegisterActionPerformed);
        
        this.add(btAuth);
        this.add(btRegister);
    }
   
    private void addRegComponents() {
        addtionalFields = new HashMap<>();
        
        JTextField cpfField = new JTextField();
        JTextField emailField = new JTextField();
        JTextField accountField = new JTextField();
        
        addtionalFields.put("cpf", emailField);
        addtionalFields.put("email", emailField);
        addtionalFields.put("account", emailField);
        
        this.add(new JLabel("cpf"));
        this.add(cpfField);

        this.add(new JLabel("email"));
        this.add(emailField);

        this.add(new JLabel("account"));
        this.add(accountField); 
        
        this.add(auxLabel);
        
        JButton btAuth = new JButton("Finish");
        btAuth.addActionListener(this::btFinishActionPerformed);
    }
    private void btAuthActionPerformed(ActionEvent evt) {
        try {
            auxLabel.setText(facade.listUser(loginField.getText()));
        } catch (InvalidUsernameException ex) {
            auxLabel.setText(ex.getMessage());
        }
    }
    
    private void btRegisterActionPerformed(ActionEvent evt) {
        System.out.println("asdassds");
        LoginRegUI reg = (LoginRegUI) clone();
        reg.addRegComponents();
        this.frame.removeAll();
        this.frame.add(reg);
        this.frame.revalidate();
        System.out.println("asdas");
    }
    
    private void btFinishActionPerformed(ActionEvent evt) {
        try {
            //TODO
            //use the other fields in registration
            facade.addUser(loginField.getText(), new String(passwordField.getPassword()));
            auxLabel.setText("Adicionado!");
        } catch (InvalidPasswordException | InvalidUsernameException | InvalidAddException ex) {
            auxLabel.setText(ex.getMessage());
        }
    }
    
    

    @Override
    public Prototype clone() {
        LoginRegUI clone = new LoginRegUI(this.frame, this.facade);
        return clone;
    }
}
