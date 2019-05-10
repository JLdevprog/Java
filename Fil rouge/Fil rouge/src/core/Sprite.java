package core;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;

public class Sprite {

    protected float x;
    protected float y;
    protected int largeur;
    protected int hauteur;
    protected String image = null;
    protected Color couleur = null;

    public Sprite(float x, float y, int largeur, int hauteur, String image) {
        this.x = x;
        this.y = y;
        this.largeur = largeur;
        this.hauteur = hauteur;
        this.image = image;
    }

    public Sprite(float x, float y, int largeur, int hauteur, Color couleur) {
        this.x = x;
        this.y = y;
        this.largeur = largeur;
        this.hauteur = hauteur;
        this.couleur = couleur;
    }

    public float getX() {
        return x;
    }

    public void setX(float x) {
        this.x = x;
    }

    public float getY() {
        return y;
    }

    public void setY(float y) {
        this.y = y;
    }

    public int getLargeur() {
        return largeur;
    }

    public void setLargeur(int largeur) {
        this.largeur = largeur;
    }

    public int getHauteur() {
        return hauteur;
    }

    public void setHauteur(int hauteur) {
        this.hauteur = hauteur;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Color getCouleur() {
        return couleur;
    }

    public void setCouleur(Color couleur) {
        this.couleur = couleur;
    }
    
    public Point getCentre(){
        return new Point((int)x + largeur/2 , (int)y + hauteur / 2);
    }
    
    public float getX1(){
        return this.x;
    }
    
    public float getX2(){
        return this.x + this.largeur;
    }
    
    public float getY1(){
        return y;
    }
    
    public float getY2(){
        return y + this.hauteur;
    }

    public void dessiner(Graphics dessin) {

        if(image != null) {

            BufferedImage imageSource;

            //Attention ne pas oublier de modifier le fichier .iml !!!
            URL url = this.getClass().getClassLoader().getResource(image);

            try {
                imageSource = ImageIO.read(url);

                int typeImage = imageSource.getType() == 0 ? BufferedImage.TYPE_INT_ARGB : imageSource.getType();

                BufferedImage imageRedimensionne = new BufferedImage(50, 50, typeImage);

                dessin.drawImage(imageSource, (int)x, (int)y, largeur, hauteur, null);

                GraphicsConfiguration gc = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice().getDefaultConfiguration();
                BufferedImage image = gc.createCompatibleImage(50, 50, Transparency.BITMASK);

                image.getGraphics().drawImage(imageRedimensionne, 0, 0, null);
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            dessin.setColor(couleur);
            dessin.fillRect((int)x,(int)y,largeur,hauteur);
        }
    }
}
