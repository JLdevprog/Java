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
import java.util.ArrayList;

public class UI extends Canvas {

    boolean arreter = false;

    ArrayList<Sprite>listSpriteStatic = new ArrayList<>();
    ArrayList<HitSprite>listSpriteDynamic = new ArrayList<>();

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

        Sprite background = new Sprite (0,0,500,500, Color.white);
        this.listSpriteStatic.add(background);

        //this.sprite = new MoveSprite(5,5,50,50);
        HitSprite ball1 = new HitSprite(50,100,20,20, "ball.png");
        ball1.setMoveX(5);
        ball1.setMoveY(5);
        this.listSpriteDynamic.add(ball1);

        HitSprite ball2 = new HitSprite(50,100,20,20, "ball.png");
        ball2.setMoveX(2);
        ball2.setMoveY(5);
        this.listSpriteDynamic.add(ball2);

        HitSprite ball3 = new HitSprite(50,100,20,20, "ball.png");
        ball3.setMoveX(5);
        ball3.setMoveY(2);
        this.listSpriteDynamic.add(ball3);

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

        for (int i = 0; i < listSpriteStatic.size();i++){
            this.listSpriteStatic.get(i).draw(draw);
        }

        for (int i = 0; i < listSpriteDynamic.size();i++){
            this.listSpriteDynamic.get(i).move();
            this.listSpriteDynamic.get(i).draw(draw);
        }

        //Create Background
        //draw.setColor(Color.WHITE);
        //draw.fillRect(0,0,500,500);

        //this.sprite.move();

        /*
        if(this.sprite.move() == int 500){

        }
        else{

        }
        */

        //this.sprite.draw(draw);
        draw.dispose();
        strategy.show();

    }

    public static void main(String[] args) {
        new UI();
    }
}