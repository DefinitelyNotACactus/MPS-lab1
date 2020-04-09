package view;

import javax.swing.*;

public interface BuilderUI {
    void buildComponents();

    void buildLayout();

    void buildActions();

    JPanel getProduct();
}
