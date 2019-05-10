package core;

import java.awt.*;
import java.awt.event.KeyEvent;

public class Zeldo extends UI{

    protected SpriteDynamique player;

    public Zeldo(){

        // Super = New UI object
        super (500, 500, "Area");

        player = new SpriteDynamique (250, 250, 50 , 50, Color.red);

        boucle();
    }

    @Override
    public void dessiner(Graphics dessin, int milisecondeDepuisLaDerniereFrame) {

        super.dessiner(dessin, milisecondeDepuisLaDerniereFrame);
        player.dessiner(dessin);
    }
    @Override
    public void keyPressed(KeyEvent e) {
        if(e.getKeyCode() == KeyEvent.VK_LEFT){
            player.setX(player.getX() - 50);
            player.setCouleur(Color.yellow);
        }
        else if(e.getKeyCode() == KeyEvent.VK_RIGHT){
            player.setX(player.getX() + 50);
            player.setCouleur(Color.green);
        }
        else if(e.getKeyCode() == KeyEvent.VK_UP){
            player.setY(player.getY() - 50);
            player.setCouleur(Color.blue);
        }
        else if(e.getKeyCode() == KeyEvent.VK_DOWN){
            player.setY(player.getY() + 50);
            player.setCouleur(Color.red);
        }
    }


    public static void main(String[] args) {

        new Zeldo();

        new Grid();

    }
}
