package core;

import java.awt.*;

public class Case extends Sprite{

    protected Sprite Case;

    // Getter & Setter Case
    public Sprite getCase() {
        return Case;
    }
    public void setCase(Sprite aCase) {
        Case = aCase;
    }

    // Define my Case
    public Case(int lin, int col, int type) {
        super(lin*10, col*10, 10, 10, type==0? Color.white : Color.black);

    }

}
