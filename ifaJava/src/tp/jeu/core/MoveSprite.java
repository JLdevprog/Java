package tp.jeu.core;

public class MoveSprite extends Sprite {
    protected int moveX =2;
    protected int moveY = 1;

    public MoveSprite(int x, int y, int width, int length) {
        super(x, y, width, length);
    }
    public void move(){
        this.x+=moveX;
        this.y+=moveY;
        //this.setMoveY(this.getMoveY()+1);
    }
    public void changeWay(int moveX,int moveY){
        this.moveX = moveX;
        this.moveY = moveY;
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
