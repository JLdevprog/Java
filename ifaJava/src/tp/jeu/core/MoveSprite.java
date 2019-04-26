package tp.jeu.core;

import java.awt.*;

public class MoveSprite extends Sprite {
    protected int moveX =10;
    protected int moveY = 5;

    public MoveSprite(int x, int y, int width, int length, String image) {
        super(x, y, width, length, image);
    }

    public MoveSprite(int x, int y, int width, int length, Color color) {
        super(x, y, width, length, color);
    }

    public void move(){
        this.x+=moveX;
        this.y+=moveY;

        if(x>=500-width || x<=0){
            setMoveX(this.moveX * -1);
        }

        if(y>=500-length || y<=0){
            setMoveY(this.moveY * -1);
        }

        //this.setMoveY(this.getMoveY()+1);
    }
    public void changeWay(int moveX,int moveY){
        /* If touch the side =/ mean heigh 1 = 1 but width 1 = -1
        if touch top or bottom meab height 1 = -1 or opposite
         */
    }

    public int getMoveX() {
        return moveX;
    }

    public void setMoveX(int moveX) {
        this.moveX = moveX;
    }

    public int getMoveY() {
        return moveY;
    }

    public void setMoveY(int moveY) {
        this.moveY = moveY;
    }
}
