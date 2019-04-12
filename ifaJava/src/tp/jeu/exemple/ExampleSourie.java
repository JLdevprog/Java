package tp.jeu.exemple;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ExampleSourie extends JPanel implements MouseListener {

    protected ExampleSourie() {

        JFrame fenetre = new JFrame("Exemple sourie");
        JPanel ecran = (JPanel) fenetre.getContentPane();
        ecran.setPreferredSize(new Dimension(500, 500));
        ecran.add(this);
        fenetre.pack();
        fenetre.setResizable(false);
        fenetre.setVisible(true);
        fenetre.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
        fenetre.requestFocus();

        //On ecoute les evenements sourie de cet ecran
        addMouseListener(this);
    }


    public void mouseClicked(MouseEvent e) {
        System.out.println(e);
    }

    public void mousePressed(MouseEvent e) {}
    public void mouseReleased(MouseEvent e) {}
    public void mouseEntered(MouseEvent e) {}
    public void mouseExited(MouseEvent e) {}


    public static void main(String[] args) {
        new ExampleSourie();
    }
}