package core;

import java.awt.*;
import java.awt.geom.Line2D;
import java.util.ArrayList;

public class SpriteDynamique extends Sprite {

    protected int vitesseHorizontalParSeconde = 0;
    protected int vitesseVerticalParSeconde = 0;
    
    protected float xPrecedent = x; //xPrecedent contient la position horizontal avant le dernier appel de la méthode déplacer
    protected float yPrecedent = y; //yPrecedent contient la position vertical avant le dernier appel de la méthode déplacer
    
    protected Sprite spriteCollisionHaut = null;//le sprite en train de toucher ce sprite du coté haut
    protected Sprite spriteCollisionBas = null;//le sprite en train de toucher ce sprite du coté bas
    protected Sprite spriteCollisionDroite = null;//le sprite en train de toucher ce sprite du coté droit
    protected Sprite spriteCollisionGauche = null;//le sprite en train de toucher ce sprite du coté gauche
    
    public SpriteDynamique(float x, float y, int largeur, int hauteur, String image) {
        super(x, y, largeur, hauteur, image);
    }

    public SpriteDynamique(float x, float y, int largeur, int hauteur, Color couleur) {
        super(x, y, largeur, hauteur, couleur);
    }
    
    @Override
    public void setX(float x) {
        super.setX(x);
        xPrecedent = x;
    }
    
    @Override
    public void setY(float y) {
        super.setY(y);
        yPrecedent = y;
    }
    
    public int getVitesseHorizontalParSeconde() {
        return vitesseHorizontalParSeconde;
    }

    public void setVitesseHorizontalParSeconde(int vitesseHorizontalParSeconde) {
        this.vitesseHorizontalParSeconde = vitesseHorizontalParSeconde;
    }

    public int getVitesseVerticalParSeconde() {
        return vitesseVerticalParSeconde;
    }

    public void setVitesseVerticalParSeconde(int vitesseVerticalParSeconde) {
        this.vitesseVerticalParSeconde = vitesseVerticalParSeconde;
    }

    public void deplacer(int milisecondeDepuisLaDerniereFrame) {
    
        xPrecedent = x;
        yPrecedent = y;
        
        x += vitesseHorizontalParSeconde * (milisecondeDepuisLaDerniereFrame / 1000f);
        y += vitesseVerticalParSeconde * (milisecondeDepuisLaDerniereFrame / 1000f);
    }
    
    public float getxPrecedent() {
        return xPrecedent;
    }
    
    public void setxPrecedent(float xPrecedent) {
        this.xPrecedent = xPrecedent;
    }
    
    public float getyPrecedent() {
        return yPrecedent;
    }
    
    public void setyPrecedent(float yPrecedent) {
        this.yPrecedent = yPrecedent;
    }
    
    public Sprite getSpriteCollisionHaut() {
        return spriteCollisionHaut;
    }
    
    public void setSpriteCollisionHaut(Sprite spriteCollisionHaut) {
        this.spriteCollisionHaut = spriteCollisionHaut;
    }
    
    public Sprite getSpriteCollisionBas() {
        return spriteCollisionBas;
    }
    
    public void setSpriteCollisionBas(Sprite spriteCollisionBas) {
        this.spriteCollisionBas = spriteCollisionBas;
    }
    
    public Sprite getSpriteCollisionDroite() {
        return spriteCollisionDroite;
    }
    
    public void setSpriteCollisionDroite(Sprite spriteCollisionDroite) {
        this.spriteCollisionDroite = spriteCollisionDroite;
    }
    
    public Sprite getSpriteCollisionGauche() {
        return spriteCollisionGauche;
    }
    
    public void setSpriteCollisionGauche(Sprite spriteCollisionGauche) {
        this.spriteCollisionGauche = spriteCollisionGauche;
    }
    
    public void reinitialiseCollisions() {
        
        this.spriteCollisionBas = null;
        this.spriteCollisionHaut = null;
        this.spriteCollisionDroite = null;
        this.spriteCollisionGauche = null;
    }
    
    public boolean testCollision(ArrayList<SpriteDynamique> listSprite) {
        
        boolean collision = false;
        
        for(Sprite sprite : listSprite) {
            collision = collision || this.testCollision(sprite);
        }
        
        return collision;
    }
    
    public boolean testCollision(Sprite sprite) {
        
        //Si ce sprite se déplace de gauche à droite alors la ligne de direction part de la position x avant déplacement
        //jusqu'au bord gauche actuel
        float x1LigneDirectionSprite = vitesseHorizontalParSeconde > 0 ? xPrecedent : x + largeur;
        float x2LigneDirectionSprite = vitesseHorizontalParSeconde > 0 ? xPrecedent + largeur : x;
        float y1LigneDirectionSprite = vitesseVerticalParSeconde > 0 ? yPrecedent : y + hauteur;
        float y2LigneDirectionSprite = vitesseVerticalParSeconde > 0 ? yPrecedent + hauteur : y;
        
        Line2D ligneDirectionSprite = new Line2D.Float(
                x1LigneDirectionSprite,
                y1LigneDirectionSprite,
                x2LigneDirectionSprite,
                y2LigneDirectionSprite);
        
        Line2D ligneHautSprite = new Line2D.Float(sprite.getX1(), sprite.getY1(), sprite.getX2(), sprite.getY1());
        Line2D ligneBasSprite = new Line2D.Float(sprite.getX1(), sprite.getY2(), sprite.getX2(), sprite.getY2());
        Line2D ligneDroiteSprite = new Line2D.Float(sprite.getX2(), sprite.getY1(), sprite.getX2(), sprite.getY2());
        Line2D ligneGaucheSprite = new Line2D.Float(sprite.getX1(), sprite.getY1(), sprite.getX1(), sprite.getY2());
        
        if(ligneDirectionSprite.intersectsLine(ligneHautSprite)){
            this.spriteCollisionBas = sprite;
        }
        if(ligneDirectionSprite.intersectsLine(ligneBasSprite)){
            this.spriteCollisionHaut = sprite;
        }
        if(ligneDirectionSprite.intersectsLine(ligneDroiteSprite)){
            this.spriteCollisionGauche = sprite;
        }
        if(ligneDirectionSprite.intersectsLine(ligneGaucheSprite)){
            this.spriteCollisionDroite = sprite;
        }
        
        //Cas où le sprite va tellement vite qu'il a traversé verticalement
        // l'intégralité du deuxième sprite en un seul déplacement
        if(this.spriteCollisionBas == sprite && this.spriteCollisionHaut == sprite) {
            double distanceLigneHaut = ligneHautSprite.ptLineDist(x1LigneDirectionSprite,y1LigneDirectionSprite);
            double distanceLigneBas = ligneBasSprite.ptLineDist(x1LigneDirectionSprite,y1LigneDirectionSprite);
            
            if(distanceLigneHaut < distanceLigneBas) {
                spriteCollisionBas = null;
            } else {
                spriteCollisionHaut = null;
            }
        }
        
        //Cas où le sprite va tellement vite qu'il a traversé horizontalement
        // l'intégralité du deuxième sprite en un seul déplacement
        if(this.spriteCollisionGauche == sprite && this.spriteCollisionDroite == sprite) {
            double distanceLigneDroite = ligneDroiteSprite.ptLineDist(x1LigneDirectionSprite,y1LigneDirectionSprite);
            double distanceLigneGauche = ligneGaucheSprite.ptLineDist(x1LigneDirectionSprite,y1LigneDirectionSprite);
            
            if(distanceLigneDroite < distanceLigneGauche) {
                spriteCollisionGauche = null;
            } else {
                spriteCollisionDroite = null;
            }
        }
        
        return  sprite == this.spriteCollisionBas
                || sprite == this.spriteCollisionHaut
                || sprite == this.spriteCollisionDroite
                || sprite == this.spriteCollisionGauche;
    }
}
