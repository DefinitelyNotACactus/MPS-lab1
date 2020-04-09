package view;

import javax.swing.*;

/** Classe diretora para construção de UI
 * Implementa o padrão de projeto Builder
 */
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
