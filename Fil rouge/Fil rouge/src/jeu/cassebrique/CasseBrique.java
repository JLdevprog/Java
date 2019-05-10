package jeu.cassebrique;

import core.SpriteDynamique;
import core.UI;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

public class CasseBrique extends UI {

    protected SpriteDynamique paddle;
    protected SpriteDynamique balle;
    protected SpriteDynamique murHaut;
    protected SpriteDynamique murBas;
    protected SpriteDynamique murDroite;
    protected SpriteDynamique murGauche;
    
    //liste contenant tous les sprites sur lesquels la balle pourra rebondire
    protected ArrayList<SpriteDynamique> listeSpriteRebond = new ArrayList<>();
    
    public CasseBrique() {

        super(500,500, "Casse brique");

        balle = new SpriteDynamique(100, 100, 10, 10, Color.red);
        
        balle.setVitesseHorizontalParSeconde((int) (Math.random() * 150 + 100));
        balle.setVitesseVerticalParSeconde((int) (Math.random() * 150 + 100));
        
        listeSpriteDynamique.add(balle);

        paddle = new SpriteDynamique(largeur / 2 - balle.getLargeur() / 2, hauteur - 50, 100, 10, Color.BLUE);
    
        listeSpriteDynamique.add(paddle);
        listeSpriteRebond.add(paddle);
    
        murHaut = new SpriteDynamique(0, 0, largeur, 10, Color.green);
        murBas = new SpriteDynamique(0, hauteur - 10, largeur, 10, Color.green);
        murDroite = new SpriteDynamique(largeur - 10, 0, largeur, hauteur, Color.green);
        murGauche = new SpriteDynamique(0, 0, 10, hauteur, Color.green);
    
        listeSpriteDynamique.add(murHaut);
        listeSpriteDynamique.add(murBas);
        listeSpriteDynamique.add(murDroite);
        listeSpriteDynamique.add(murGauche);
    
        listeSpriteRebond.add(murHaut);
        listeSpriteRebond.add(murBas);
        listeSpriteRebond.add(murDroite);
        listeSpriteRebond.add(murGauche);

        boucle();
    }

    @Override
    public void dessiner(Graphics dessin, int milisecondeDepuisLaDerniereFrame) {
        
        super.dessiner(dessin,milisecondeDepuisLaDerniereFrame);
        
        if(balle.getSpriteCollisionDroite() != null) {
            //On déplace la balle à 5 pixel du mur pour éviter de la coincer
            balle.setX(balle.getSpriteCollisionDroite().getX() - balle.getLargeur() - 5);
            //on inverse la vitesse horizontal de la balle
            balle.setVitesseHorizontalParSeconde(balle.getVitesseHorizontalParSeconde() * -1);
        }
    
        if(balle.getSpriteCollisionGauche() != null) {
            //On déplace la balle à 5 pixel du mur pour éviter de la coincer
            balle.setX(balle.getSpriteCollisionGauche().getX2() + 5);
            //on inverse la vitesse horizontal de la balle
            balle.setVitesseHorizontalParSeconde(balle.getVitesseHorizontalParSeconde() * -1);
        }
        
        if(balle.getSpriteCollisionHaut() != null) {
            //on inverse la vitesse verticale de la balle
            balle.setVitesseVerticalParSeconde(balle.getVitesseVerticalParSeconde() * -1);
            //On déplace la balle à 5 pixel du mur pour éviter de la coincer
            balle.setY(balle.getSpriteCollisionHaut().getY2() + 5);
        }
    
        if(balle.getSpriteCollisionBas() != null) {
            //on inverse la vitesse verticale de la balle
            balle.setVitesseVerticalParSeconde(balle.getVitesseVerticalParSeconde() * -1);
            //On déplace la balle à 5 pixel du mur pour éviter de la coincer
            balle.setY(balle.getSpriteCollisionBas().getY() - balle.getHauteur() - 5);
        }
    
        //TODO replace paddle par contains.listeRebondSpecial
        if(balle.getSpriteCollisionBas() == paddle) {
            
            //donne la distance horizontale entre le centre de la balle et le centre du sprite (paddle par exemple)
            float distanceCentre = balle.getCentre().x - paddle.getCentre().x;
            
            //donne un nombre entre -1 et 1 :
            //      -1 si la balle a tapé l'extrémité gauche du sprite
            //      1 si la balle a tapé l'extrémité droite du sprite
            //      0 si la balle a tapé le centre du sprite
            //      0.5 si la balle a tapé au 3/4 du sprite etc ....
            float ratioDistanceLargeurPaddle = distanceCentre / (paddle.getLargeur() / 2);
            
            //on multiplie ce ratio par 250 (qui sera la vitesse maximum si la balle a tapé à droite du sprite)
            // et on affecte le résultat à la vitesse horizontal
            balle.setVitesseHorizontalParSeconde((int)(250 * ratioDistanceLargeurPaddle));
        }
    
        for(int i = 0; i < listeSpriteDynamique.size(); i++){
            listeSpriteDynamique.get(i).dessiner(dessin);
        }
        
        testCollisions();
    }
    
    private void testCollisions() {
        
        //on remet à null tous les sprites en collision avec la balle
        balle.reinitialiseCollisions();
        //on test la collision de tous les sprites de la liste "listeSpriteRebond"
        balle.testCollision(listeSpriteRebond);
        
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if(e.getKeyCode() == KeyEvent.VK_LEFT){
            paddle.setX(paddle.getX() - 5);
        } else if(e.getKeyCode() == KeyEvent.VK_RIGHT){
            paddle.setX(paddle.getX() + 5);
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }

    public static void main(String[] args) {
        new CasseBrique();
    }
}
