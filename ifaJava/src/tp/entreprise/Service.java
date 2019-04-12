package tp.entreprise;

import java.util.ArrayList;

public class Service {
    private String nom;
    private ArrayList listSalarie = new ArrayList();

    public Service(String nom) {
        this.nom = nom;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public ArrayList getListSalarie() {
        return listSalarie;
    }

    public void setListSalarie(ArrayList listSalarie) {
        this.listSalarie = listSalarie;
    }


}
