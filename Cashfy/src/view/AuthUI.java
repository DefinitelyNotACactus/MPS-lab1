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

    public AuthUI(int width, int height) {
        initFrame(width, height);
        try {
            facade = FacadeBusiness.getInstance();
            frame.add(new LoginRegUI(frame, facade));
        } catch (InfraException ex) {
            frame.getContentPane().add(new JLabel(ex.getMessage()));
        }
    }

    private void initFrame(int width, int height) {
        frame = new JFrame();
        frame.setSize(new Dimension(width, height));
        frame.setLayout(new GridLayout(0, 1));
        frame.setVisible(true);
        frame.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent evt) {
                dispose();
            }
        });
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
