package view;

import javax.swing.*;

public class ProductUI extends JPanel {
    private JPanel header;
    private JPanel content;
    private JPanel actions;

    public JPanel getHeader() {
        return header;
    }

    public void setHeader(JPanel header) {
        this.header = header;
    }

    public JPanel getContent() {
        return content;
    }

    public void setContent(JPanel content) {
        this.content = content;
    }

    public JPanel getActions() {
        return actions;
    }

    public void setActions(JPanel actions) {
        this.actions = actions;
    }
}
