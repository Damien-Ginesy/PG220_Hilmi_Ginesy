package Donnees;

class Dimension implements Comparaison {
    private double longueur;
    private double largeur;

    Dimension(double longueur, double largeur) {
        this.longueur = longueur;
        this.largeur = largeur;
    }

    double getLongueur() {
        return this.longueur;
    }

    void setLongueur(double longueur) {
        this.longueur = longueur;
    }

    double getLargeur() {
        return this.largeur;
    }

    void setLargeur(double largeur) {
        this.largeur = largeur;
    }

    public void EstDansIntervalle() {
        if (this.longueur <= this.largeur || this.largeur < 0 || this.longueur < 0) {
            throw new IllegalArgumentException();
        }
    }
}
