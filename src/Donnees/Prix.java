package Donnees;

import java.text.DecimalFormat;

/**
 * Classe qui définit le prix
 */
class Prix implements Comparaison {
    private double prix;

    /**
     *Constructeur par défaut qui initialise l'objet prix
     * @param prix
     */
    Prix(double prix) {
        this.prix = prix;
    }

    /**
     * Getter qui renvoie le prix
     * @return prix
     */
    double getPrix() {
        return this.prix;
    }

    /**
     * Setter qui permet de modifier le prix
     * @param prix
     */
    void setPrix(double prix) {
        this.prix = prix;
    }

    /**
     * Fonction qui permet de savoir si le prix est bien dans le format voulu
     */
    @Override
    public void EstDansIntervalle() {
        DecimalFormat df = new DecimalFormat("##.##");
        String stringBonPrix = df.format(this.prix);
        double bonPrix = Double.parseDouble(stringBonPrix);
        if (bonPrix != this.prix || this.prix < 0) {
            throw new IllegalArgumentException();
        }
    }
}
