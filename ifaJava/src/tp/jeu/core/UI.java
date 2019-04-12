package tp.jeu.core;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;

public class UI extends Canvas {

    boolean arreter = false;
    MoveSprite sprite;
    BufferStrategy strategy;

    protected UI() {

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

        this.sprite = new MoveSprite(5,5,50,50);

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

        Graphics draw = strategy.getDrawGraphics();

        //Create Background
        draw.setColor(Color.WHITE);
        draw.fillRect(0,0,500,500);

        this.sprite.move();

        /*
        if(this.sprite.move() == int 500){

        }
        else{

        }
        */

        this.sprite.draw(draw);
        draw.dispose();
        strategy.show();

    }

    public static void main(String[] args) {
        new UI();
    }
}