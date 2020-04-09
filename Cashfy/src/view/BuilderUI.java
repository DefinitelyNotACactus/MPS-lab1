package view;

import javax.swing.*;

/** Interface construtora para construção de UI
 * Implementa o padrão de projeto Builder
 */
public interface BuilderUI {
    void buildComponents();

    void buildLayout();

    void buildActions();

    JPanel getProduct();
}
