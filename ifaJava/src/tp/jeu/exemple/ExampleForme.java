package tp.jeu.exemple;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.image.BufferStrategy;

public class ExampleForme extends JPanel{

    protected ExampleForme() {

        JFrame fenetre = new JFrame("Exemple forme");
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
    }

    public void paint(Graphics g) {
        g.setColor(Color.CYAN);
        g.fillRect(0,0,200,200);
    }

    public static void main(String[] args) {
        new ExampleForme();
    }
}