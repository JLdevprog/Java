package tp.jeu.core;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;

public class ExampleImageS extends JPanel{

    protected ExampleImageS() {

        JFrame fenetre = new JFrame("Exemple Avatar");
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
        BufferedImage imageSource;

        URL url = this.getClass().getClassLoader().getResource("body.png");

        try {
            imageSource = ImageIO.read(url);

            int typeImage = imageSource.getType() == 0? BufferedImage.TYPE_INT_ARGB : imageSource.getType();

            BufferedImage imageRedimensionne = new BufferedImage(50, 50, typeImage);

            g.drawImage(imageSource, 0, 0, 50, 50, null);
            g.dispose();

            GraphicsConfiguration gc = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice().getDefaultConfiguration();
            BufferedImage image = gc.createCompatibleImage(50, 50, Transparency.BITMASK);

            image.getGraphics().drawImage(imageRedimensionne,0,0,null);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new ExampleImageS();
    }
}