package core;

import java.awt.*;

public class Case extends Sprite{

    protected int lin;
    protected int col;
    protected int type;

    // Define my Case
    public Case(int lin, int col, int type) {
        super(lin*10, col*10, 10, 10, type==0? Color.white : Color.black);

        this.lin = lin;
        this.col = col;
        this.type = type;

    }

}
