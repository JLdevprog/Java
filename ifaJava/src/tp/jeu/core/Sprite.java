package tp.jeu.core;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;

public class Sprite {
    protected int x = 0;
    protected int y = 0;
    protected int width = 0;
    protected int length = 0;
    protected Color color = null;
    protected String image = null;

    public Sprite(int x, int y, int width, int length, String image) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.length = length;
        this.image = image;
    }

    public Sprite(int x, int y, int width, int length, Color color) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.length = length;
        this.color = color;
    }

    public void draw(Graphics graphics){

        if(image!=null){
            BufferedImage imageSource;

            URL url = this.getClass().getClassLoader().getResource(this.image);

            try {
                imageSource = ImageIO.read(url);

                int typeImage = imageSource.getType() == 0? BufferedImage.TYPE_INT_ARGB : imageSource.getType();

                BufferedImage imageRedimensionne = new BufferedImage(width, length, typeImage);

                graphics.drawImage(imageSource, getX(), getY(), width, length, null);
                //graphics.dispose();

                GraphicsConfiguration gc = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice().getDefaultConfiguration();
                BufferedImage image = gc.createCompatibleImage(width, length, Transparency.BITMASK);

                image.getGraphics().drawImage(imageRedimensionne,x,y,null);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        else {
            graphics.setColor(this.color);
            graphics.fillRect(  this.x,
                    this.y,
                    this.width,
                    this.length);
        }


    }


    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }
}
