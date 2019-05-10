package core;

import java.awt.*;

public class Zeldo extends UI{

    protected SpriteDynamique player;

    public Zeldo(){

        // Super = New UI object
        super (500, 500, "Area");

        player = new SpriteDynamique (250, 250, 10 , 10, Color.red);
    }

}
