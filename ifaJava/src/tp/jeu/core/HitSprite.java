package tp.jeu.core;

import java.awt.*;
import java.awt.image.BufferStrategy;

public class HitSprite extends MoveSprite{


    public HitSprite(int x, int y, int width, int length, String image) {
        super(x, y, width, length, image);
    }

    public HitSprite(int x, int y, int width, int length, Color color) {
        super(x, y, width, length, color);
    }

    public boolean collider(Sprite s) {
        //Collider 1
        int bx1 = x;
        int bx2 = x + width;
        int by1 = y;
        int by2 = y + length;
        //Collider 2
        int px1 = s.x;
        int px2 = s.x + s.width;
        int py1 = s.y;
        int py2 = s.y + s.length;
        ;

        if (((bx1 > px1 && bx1 < px2) || (bx2 > px1 && bx2 < px2))
                && ((py1 > by1 && py1 < by2) || (py2 > by1 && py2 < by2))) {
//
//            int center1 = x + (width/2);
//            int center2 = x + (s.width/2);
//
//            setMoveX(this.moveX * -center1);
//            setMoveY(this.moveY* -center2);

            return true;
        }
        else
        return false;
    }
}
