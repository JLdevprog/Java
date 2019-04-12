package tp.jeu.exemple;

import javax.swing.*;
import java.awt.*;

public class ExampleFenetre {

    protected ExampleFenetre() {

        // On créait une nouvelle fenêtre
        JFrame fenetre = new JFrame("Ma première fenêtre");

        // On récupère l'ecran de la fenetre
        JPanel ecran = (JPanel) fenetre.getContentPane();

        // On donne une taille à cet ecran
        ecran.setPreferredSize(new Dimension(500, 500));

        // On demande le raffraichissement de la position et des dimensions
        fenetre.pack();

        // On indique la fenetre comme n'étant pas redimensionnable
        fenetre.setResizable(false);

        // On indique la fenetre comme étant visible
        fenetre.setVisible(true);
    }

    public static void main(String[] args) {
        new ExampleFenetre();
    }
}