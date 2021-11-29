package Donnees;

public class Dimension {
    private double longueur;
    private double largeur;

    public Dimension(double longueur, double largeur) {
        this.longueur = longueur;
        this.largeur = largeur;
    }

    public double getLongueur() {
        return this.longueur;
    }

    public void setLongueur(double longueur) {
        this.longueur = longueur;
    }

    public double getLargeur() {
        return this.largeur;
    }

    public void setLargeur(double largeur) {
        this.largeur = largeur;
    }

    public static int EstDansIntervalle(Dimension dim){
        if(dim.largeur> dim.largeur && dim.largeur>0 && dim.longueur>0){
            return 0;
        }
        return 1;
    }
}
