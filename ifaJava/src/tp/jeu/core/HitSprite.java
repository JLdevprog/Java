package tp.jeu.core;

import java.awt.*;

public class HitSprite extends MoveSprite{


    public HitSprite(int x, int y, int width, int length, String image) {
        super(x, y, width, length, image);
    }

    public HitSprite(int x, int y, int width, int length, Color color) {
        super(x, y, width, length, color);
    }

    public boolean collider(int x, int y){

        return false;

//        this.x = this.x+this.width;
//
//        this.y = this.y+this.length;

//        if(this.x>=500-width || this.x<=0){
//        }
//        if(this.y>=500-length || this.y<=0){
//        }
    }

    public void draw(){
        
    }

}
