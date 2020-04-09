package view;

import business.FacadeBusiness;
import util.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

/** Classe concreta que constroí a UI para autenticação (login) do sistema
 * Implementa o padrão de projeto Builder
 */
public class AuthUIBuilder extends JPanel implements BuilderUI {
    private JTextField loginField;
    private JPasswordField passwordField;

    private JLabel auxLabel;

    private JButton btAuth;
    private JButton btRegister;

    @Override
    public void buildComponents() {
        loginField = new JTextField();
        passwordField = new JPasswordField();
        auxLabel = new JLabel("");
        btAuth = new JButton("Autenticar");
        btRegister = new JButton("Registrar-se");
    }

    @Override
    public void buildLayout() {
        setLayout(new GridLayout(0, 1));
        add(new JLabel("Cashfy"));
        add(new JLabel("Login"));
        add(loginField);
        add(new JLabel("Senha"));
        add(passwordField);
        add(auxLabel);
        add(btAuth);
        add(btRegister);
    }

    @Override
    public void buildActions() {
        btAuth.addActionListener(this::btAuthActionPerformed);
        btRegister.addActionListener(this::btRegisterActionPerformed);
    }

    @Override
    public JPanel getProduct() {
        return this;
    }

    private void btAuthActionPerformed(ActionEvent evt) {
        try {
            auxLabel.setText(FacadeBusiness.getInstance().listUser(loginField.getText()));
        } catch (InfraException | InvalidUsernameException ex) {
            auxLabel.setText(ex.getMessage());
        }
    }

    private void btRegisterActionPerformed(ActionEvent evt) {
        DirectorUI director = new DirectorUI(new RegisterUIBuilder());
        director.buildUI();

        getParent().add(director.getProduct());
        getParent().revalidate();
        getParent().remove(this);
    }
}
