package tp.jeu.exemple;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class ExampleTouche extends JPanel implements KeyListener {

    protected ExampleTouche() {

        JFrame fenetre = new JFrame("Exemple touche");
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

        //On ecoute les touches de cet ecran
        fenetre.addKeyListener (this);
    }

    @Override
    public void keyTyped(KeyEvent e) {
        System.out.println(e);
    }

    @Override
    public void keyPressed(KeyEvent e) {

        System.out.println(e);
        if(e.getKeyCode() == KeyEvent.VK_LEFT){
            System.out.println("Touche gauche appuyée");
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        System.out.println(e);
        if(e.getKeyCode() == KeyEvent.VK_S){
            System.out.println("Touche S relachée");
        }
    }

    public static void main(String[] args) {
        new ExampleTouche();
    }
}