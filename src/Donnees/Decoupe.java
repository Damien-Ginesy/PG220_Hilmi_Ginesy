package Donnees;

import java.util.ArrayList;

/**
 * Classe qui définit une découpe d'un panneau
 */
class Decoupe {
    private final int clientId;
    private final int fournisseurId;
    private final int plancheId;
    private final int panneauId;
    private final int plancheNb;
    private final int panneauNb;
    private final double posx;
    private final double posy;

    /**
     * Constructeur qui génère une découpe
     * @param clientId le client
     * @param fournisseurId le fournisseur
     * @param plancheId
     * @param panneauId
     * @param plancheNb
     * @param panneauNb
     * @param posx position x sur le panneau de la découpe
     * @param posy position y sur le panneau de la découpe
     */
    Decoupe(int clientId, int fournisseurId,int plancheId, int panneauId, int plancheNb, int panneauNb, double posx, double posy) {
        this.clientId = clientId;
        this.fournisseurId = fournisseurId;
        this.plancheId = plancheId;
        this.panneauId = panneauId;
        this.plancheNb = plancheNb;
        this.panneauNb = panneauNb;
        this.posx = posx;
        this.posy = posy;
    }

    /**
     * Fonction qui retourne la position x de la découpe
     * @return posx position des abscisses de la découpe du panneau
     */
    double getPosx() {
        return posx;
    }
    /**
     * Fonction qui retourne la position y de la découpe
     * @return posx position des ordonnées de la découpe du panneau
     */
    double getPosy() {
        return posy;
    }

    int getClientId() {
        return clientId;
    }

    int getFournisseurId() {
        return fournisseurId;
    }

    ArrayList<String> ecritureFormat(){
        ArrayList<String> listeDonnee = new ArrayList<>();
        listeDonnee.add(String.valueOf(clientId));
        listeDonnee.add(String.valueOf(plancheId));
        listeDonnee.add(String.valueOf(plancheNb));
        listeDonnee.add(String.valueOf(fournisseurId));
        listeDonnee.add(String.valueOf(panneauId));
        listeDonnee.add(String.valueOf(panneauNb));
        listeDonnee.add(String.valueOf(posx));
        listeDonnee.add(String.valueOf(posy));
        return listeDonnee;
    }
}
