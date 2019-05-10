package core;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.image.BufferStrategy;
import java.util.ArrayList;

public abstract class UI extends Canvas implements KeyListener {

    protected boolean arreter = false;
    protected BufferStrategy strategy;
    protected Sprite background;
    protected ArrayList<SpriteDynamique> listeSpriteDynamique = new ArrayList<>();
    protected int largeur;
    protected int hauteur;
    protected int frameParSeconde = 60;
    
    public UI(int largeur, int hauteur, String titre) {

        this.largeur = largeur;
        this.hauteur = hauteur;

        JFrame fenetre = new JFrame(titre);
        JPanel ecran = (JPanel) fenetre.getContentPane();
        ecran.setPreferredSize(new Dimension(largeur, hauteur));
        setBounds(0,0,largeur,hauteur);
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
        fenetre.addKeyListener (this);

        //Indique que le raffraichissement de l'ecran doit être fait manuellement.
        createBufferStrategy(2);
        setIgnoreRepaint(true);
        strategy = getBufferStrategy();

        background = new Sprite(0,0,largeur,hauteur,Color.WHITE);

        Color randomColor = new Color(
                (float) Math.random(),
                (float) Math.random(),
                (float) Math.random());
    }

    public void boucle() {
    
        long milisecondeDepuisLeDebutDeAnimaton = System.currentTimeMillis();

        while (!arreter) {
    
            int milisecondeDepuisLaDerniereFrame = (int)(System.currentTimeMillis() - milisecondeDepuisLeDebutDeAnimaton);
            milisecondeDepuisLeDebutDeAnimaton = System.currentTimeMillis();
            
            Graphics dessin = strategy.getDrawGraphics();

            dessiner(dessin, milisecondeDepuisLaDerniereFrame);

            dessin.dispose();// termine le dessin
            strategy.show();// demande de raffrachir l'ecran
            //Pause de 10 milliseconde pour ne pas raffraichir inutillement
            try { Thread.sleep(1000 / frameParSeconde); } catch (Exception e) {}
        }
    }

    //Méthode à surcharger;
    public void dessiner(Graphics dessin, int milisecondeDepuisLaDerniereFrame) {
        //Ne rien changer ici, la classe qui héritera de "UI"
        //devra posséder une méthode "dessiner" qui contiendra le code à
        //éxecuter à chaque boucle. (Voir "CasseBrique.java" pour exemple)
    
        this.background.dessiner(dessin);
    
        for(int i = 0; i < listeSpriteDynamique.size(); i++) {
            listeSpriteDynamique.get(i).deplacer(milisecondeDepuisLaDerniereFrame);
        }
    }
    
    //Méthode à surcharger;
    @Override
    public void keyTyped(KeyEvent e) {
    }
    
    //Méthode à surcharger;
    @Override
    public void keyPressed(KeyEvent e) {
        //Ne rien changer ici, la classe qui héritera de "UI"
        //devra posséder une méthode "keyPressed" qui contiendra le code à
        //éxecuter à chaque fois qu'une touche est pressée. (Voir "CasseBrique.java" pour exemple)
    }
    
    //Méthode à surcharger;
    @Override
    public void keyReleased(KeyEvent e) {
        //Ne rien changer ici, la classe keyReleased héritera de "UI"
        //devra posséder une méthode "keyTyped" qui contiendra le code à
        //éxecuter à chaque fois qu'une touche est relachée. (Voir "CasseBrique.java" pour exemple)
    }

}