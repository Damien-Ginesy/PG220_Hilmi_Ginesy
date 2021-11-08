package src.Donnees;

public class Dimension extends Comparaison{
    double longueur;
    double largeur;

    Dimension(double longueur, double largeur) {
        this.longueur = longueur;
        this.largeur = largeur;
    }

    double getLongueur() {
        return this.longueur;
    }

    double getLargeur() {
        return this.largeur;
    }

    void setLongueur(double longueur) {
        this.longueur = longueur;
    }

    void setLargeur(double largeur) {
        this.largeur = largeur;
    }

    int EstDansIntervalle(Object Dimension){
        Dimension dim=(Dimension) Dimension;
        if(dim.largeur<0){
            return 1;
        }
        if(dim.longueur<0){
            return 1;
        }
        if(dim.longueur< dim.largeur){
            return 1;
        }
        return 0;
    }
}
