package Donnees;

import java.util.ArrayList;

/**
 * Classe abstraite pour les clients et les fournisseurs
 * @see Client
 * @see Fournisseur
 */
abstract class Interlocuteurs implements ObjetModifiable {
    private final int id;
    private ArrayList<Bois> boisListe = new ArrayList<>();

    /**
     * Constructeur qui génère un interlocuteur à partir de son id
     * @param id identifiant de l'interlocuteur
     */
    Interlocuteurs(int id) {
        this.id = id;
    }

    /**
     * Getter pour l'identifiant de l'interlocuteur
     * @return id
     */
    int getId() {
        return id;
    }

    /**
     * Fonction qui permet d'ajouter du Bois à une liste de Bois
     * @param bois
     */
    void addBois(Bois bois) {
        boisListe.add(bois);
    }

    /**
     * Fonction qui permet d'ajouter listeBois à Interlocuteur
     * @param listeBois liste de Bois
     */
    void addBoisListe(ArrayList<Bois> listeBois) {
        boisListe = listeBois;
    }

    /**
     * Fonction qui permet de récupérer la liste de bois
     * @return boisListe
     */
    ArrayList<Bois> getBoisListe() {
        return boisListe;
    }
}
