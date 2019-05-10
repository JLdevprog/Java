package tp.jeu.exemple;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.image.BufferStrategy;

public class ExampleBoucle extends Canvas {

    boolean arreter = false;
    BufferStrategy strategy;

    protected ExampleBoucle() {

        JFrame fenetre = new JFrame("Exemple boucle");
        JPanel ecran = (JPanel) fenetre.getContentPane();
        ecran.setPreferredSize(new Dimension(500, 500));
        setBounds(0,0,500,500);
        ecran.add(this);
        fenetre.pack();
        fenetre.setResizable(false);
        fenetre.setVisible(true);
        fenetre.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });

        //Indique que le raffraichissement de l'ecran doit être fait manuellement.
        createBufferStrategy(2);
        setIgnoreRepaint(true);
        strategy = this.getBufferStrategy();

        boucle();
    }

    public void boucle() {

        while (!arreter) {

            dessiner();
            //Pause de 10 milliseconde pour ne pas raffraichir inutillement
            try { Thread.sleep(10); } catch (Exception e) {}
        }
    }

    public void dessiner() {

        Graphics dessin = strategy.getDrawGraphics();
        dessin.setColor(Color.CYAN);
        dessin.fillRect(
                (int)(Math.random() * 500),
                (int)(Math.random() * 500),
                10,10);
        dessin.dispose();// termine le dessin
        strategy.show();// demande de raffrachir l'ecran
    }

    public static void main(String[] args) {
        new ExampleBoucle();
    }
}