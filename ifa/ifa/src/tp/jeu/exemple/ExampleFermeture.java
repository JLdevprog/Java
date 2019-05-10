package tp.jeu.exemple;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class ExampleFermeture {

    protected ExampleFermeture() {

        JFrame fenetre = new JFrame("Ma deuxième fenêtre");
        JPanel ecran = (JPanel) fenetre.getContentPane();
        ecran.setPreferredSize(new Dimension(500, 500));
        fenetre.pack();
        fenetre.setResizable(false);
        fenetre.setVisible(true);

        //On ajoute un evenement permettant la feneture du processus
        //lors de la fermeture de la fenetre
        fenetre.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
    }

    public static void main(String[] args) {
        new ExampleFermeture();
    }
}