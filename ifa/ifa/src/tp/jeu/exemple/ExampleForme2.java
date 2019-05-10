package tp.jeu.exemple;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class ExampleForme2 extends JPanel{

    public void paint(Graphics g) {
        g.setColor(Color.CYAN);
        g.fillRect(0,0,200,200);
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.getContentPane().add(new ExampleForme2());

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(200,200);
        frame.setVisible(true);
    }
}