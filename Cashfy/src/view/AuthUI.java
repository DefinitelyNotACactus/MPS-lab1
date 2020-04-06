package view;

import business.FacadeBusiness;
import util.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class AuthUI {
    private FacadeBusiness facade;

    private JFrame frame;

    private JTextField loginField;
    private JPasswordField passwordField;

    private JLabel auxLabel;

    private JButton btAuth;
    private JButton btRegister;

    public AuthUI(int width, int height) {
        frame = new JFrame();
        frame.setSize(new Dimension(width, height));
        frame.setLayout(new GridLayout(0, 1));
        frame.setVisible(true);
        frame.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent evt) {
                dispose();
            }
        });

        try {
            facade = new FacadeBusiness();
            initComponents();
        } catch (InfraException ex) {
            frame.getContentPane().add(new JLabel(ex.getMessage()));
        }
    }

    private void initComponents() {
        loginField = new JTextField();
        passwordField = new JPasswordField();

        auxLabel = new JLabel("");

        btAuth = new JButton("Autenticar");
        btAuth.addActionListener(this::btAuthActionPerformed);

        btRegister = new JButton("Registrar-se");
        btRegister.addActionListener(this::btRegisterActionPerformed);

        frame.getContentPane().add(new JLabel("Cashfy"));

        frame.getContentPane().add(new JLabel("Login"));
        frame.getContentPane().add(loginField);

        frame.getContentPane().add(new JLabel("Senha"));
        frame.getContentPane().add(passwordField);

        frame.getContentPane().add(auxLabel);

        frame.getContentPane().add(btAuth);
        frame.getContentPane().add(btRegister);
    }

    private void btAuthActionPerformed(ActionEvent evt) {
        try {
            auxLabel.setText(facade.listUser(loginField.getText()));
        } catch (InvalidUsernameException ex) {
            auxLabel.setText(ex.getMessage());
        }
    }

    private void btRegisterActionPerformed(ActionEvent evt) {
        try {
            facade.addUser(loginField.getText(), new String(passwordField.getPassword()));
            auxLabel.setText("Adicionado!");
        } catch (InvalidPasswordException | InvalidUsernameException | InvalidAddException ex) {
            auxLabel.setText(ex.getMessage());
        }
    }

    private void dispose() {
        try {
            facade.saveUsers();
            facade.saveNews();
            facade.executeFOOperation("save", null);
        } catch (UnsuccessfulOperationException | InfraException ex) {
            JOptionPane.showMessageDialog(frame, ex.getMessage());
        } finally {
            System.exit(0);
        }
    }
}
