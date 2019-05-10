package tp.jeu.exemple;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class ExampleText extends JPanel{

    protected ExampleText() {

        JFrame fenetre = new JFrame("Exemple text");
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
        g.setColor(Color.RED);
        g.drawString("Mon premier text !",50,100);
    }

    public static void main(String[] args) {
        new ExampleText();
    }
}