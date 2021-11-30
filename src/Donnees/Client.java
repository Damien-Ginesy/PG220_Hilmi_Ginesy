package Donnees;

import java.util.ArrayList;

class Client implements ObjetModifiable {
    private final int id;
    private final ArrayList<Planche> planchesListe = new ArrayList();

    Client(int id) {
        this.id = id;
    }

    int getId() {
        return id;
    }

    void addPlanche(Planche planche) {
        planchesListe.add(planche);
    }

    ArrayList getPlanchesListe() {
        return planchesListe;
    }
}
