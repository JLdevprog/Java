package core;

import java.awt.*;
import java.util.ArrayList;

public class Grid {
    protected ArrayList<Case> area = new ArrayList<>();

    public Grid(ArrayList<Case> area) {

        this.area = area;

    }

    public Grid() {
        this.area = area;

        for (int i = 0; i <=10; i++){

            for (int j = 0; j <=10; j++){

                new Case( i , j ,0);
            }
        }
    }
}
