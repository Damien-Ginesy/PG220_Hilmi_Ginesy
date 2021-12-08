package Donnees;

import java.util.ArrayList;

 abstract class Interlocuteurs implements ObjetModifiable {
    private final int id;
    private final ArrayList<Bois> boisListe = new ArrayList();

    Interlocuteurs(int id) {
        this.id = id;
    }

    int getId() {
        return id;
    }

    void addBois(Bois bois) {
        boisListe.add(bois);
    }

    ArrayList getBoisListe() {
        return boisListe;
    }
}
