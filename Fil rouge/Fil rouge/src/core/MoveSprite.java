package core;

import java.awt.*;

public class MoveSprite extends Sprite {

    protected int vitesseX = 0;
    protected int vitesseY = 0;

    public MoveSprite(int x, int y, int largeur, int hauteur, String image) {
        super(x, y, largeur, hauteur, image);
    }

    public MoveSprite(int x, int y, int largeur, int hauteur, Color couleur) {
        super(x, y, largeur, hauteur, couleur);
    }

    public int getVitesseX() {
        return vitesseX;
    }

    public void setVitesseX(int vitesseX) {
        this.vitesseX = vitesseX;
    }

    public int getVitesseY() {
        return vitesseY;
    }

    public void setVitesseY(int vitesseY) {
        this.vitesseY = vitesseY;
    }

    public void deplacer() {
        x += vitesseX;
        y += vitesseY;
    }


}
