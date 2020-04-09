package view;

import business.FacadeBusiness;
import util.InfraException;
import util.UnsuccessfulOperationException;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Main extends JFrame {
    private Main() {
        setSize(new Dimension(400, 400));
        setVisible(true);
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent evt) {
                dispose();
            }
        });
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            Main frame = new Main();
            DirectorUI director = new DirectorUI(new AuthUIBuilder());
            director.buildUI();
            frame.getContentPane().add(director.getProduct());
        });
    }

    public void dispose() {
        try {
            FacadeBusiness facade = FacadeBusiness.getInstance();
            facade.saveUsers();
            facade.saveNews();
            facade.executeFOOperation("save", null);
        } catch (UnsuccessfulOperationException | InfraException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage());
        } finally {
            System.exit(0);
        }
    }
}
