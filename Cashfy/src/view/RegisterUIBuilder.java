package view;

import business.FacadeBusiness;
import util.InfraException;
import util.InvalidAddException;
import util.InvalidPasswordException;
import util.InvalidUsernameException;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

/** Classe concreta que constroí a UI para registro de usuários do sistema
 * Implementa o padrão de projeto Builder
 */
public class RegisterUIBuilder extends JPanel implements BuilderUI {
    private JTextField loginField;
    private JPasswordField passwordField;

    private JLabel auxLabel;

    private JButton btRegister;
    private JButton btReturn;

    @Override
    public void buildComponents() {
        loginField = new JTextField();
        passwordField = new JPasswordField();
        auxLabel = new JLabel("");
        btRegister = new JButton("Registrar-se");
        btReturn = new JButton("Retornar");
    }

    @Override
    public void buildLayout() {
        setLayout(new GridLayout(0, 1));
        add(new JLabel("Crie sua conta"));
        add(new JLabel("Login"));
        add(loginField);
        add(new JLabel("Senha"));
        add(passwordField);
        add(auxLabel);
        add(btRegister);
        add(btReturn);
    }

    @Override
    public void buildActions() {
        btRegister.addActionListener(this::btRegisterActionPerformed);
        btReturn.addActionListener(this::btReturnActionPerformed);
    }

    @Override
    public JPanel getProduct() {
        return this;
    }

    private void btRegisterActionPerformed(ActionEvent evt) {
        try {
            FacadeBusiness.getInstance().addUser(loginField.getText(), new String(passwordField.getPassword()));
            auxLabel.setText("Usuário registrado!");
        } catch (InfraException | InvalidAddException | InvalidUsernameException | InvalidPasswordException ex) {
            auxLabel.setText(ex.getMessage());
        }
    }

    private void btReturnActionPerformed(ActionEvent evt) {
        DirectorUI director = new DirectorUI(new AuthUIBuilder());
        director.buildUI();

        getParent().add(director.getProduct());
        getParent().revalidate();
        getParent().remove(this);
    }
}
