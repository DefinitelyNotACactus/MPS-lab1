package view;

import javax.swing.*;

public class DirectorUI {
    private BuilderUI builder;

    public DirectorUI(BuilderUI builder) {
        this.builder = builder;
    }

    public void buildUI() {
        builder.buildComponents();
        builder.buildLayout();
        builder.buildActions();
    }

    public JPanel getProduct() {
        return builder.getProduct();
    }
}
