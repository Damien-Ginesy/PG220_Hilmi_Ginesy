package src.Donnees;

public class Dimension {
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
}
