package Donnees;

/**
 * Classe qui gère la dimension longueur et largeur des planches ou panneaux
 */
class Dimension implements Comparaison {
    private double longueur;
    private double largeur;

    /**
     * Constructeur par défault qui initialise l'objet dimension à l'aide des paramètres longueur
     * et largeur
     *
     * @param longueur longueur de la planche ou du panneau
     * @param largeur  largeur de la planche ou du panneau
     */
    Dimension(double longueur, double largeur) {
        this.longueur = longueur;
        this.largeur = largeur;
    }

    /**
     * Fonction qui permet de savoir si les dimensions de l'objet sont inférieures à celle passé
     * en paramètres
     *
     * @param dimension dimension de l'objet à comparer à notre objet
     * @return boolean
     */
    boolean inferieur(Dimension dimension) {
        return this.longueur <= dimension.longueur && this.largeur <= dimension.largeur;
    }

    /**
     * Getter qui renvoi la longueur de l'objet
     * @return longueur
     */
    double getLongueur() {
        return this.longueur;
    }

    /**
     * Setter qui défini la longueur de l'objet
     * @param longueur longueur de l'objet
     */
    void setLongueur(double longueur) {
        this.longueur = longueur;
    }

    /**
     * Getter qui renvoi la largur de l'objet
     * @return largeur
     */
    double getLargeur() {
        return this.largeur;
    }

    /**
     * Setter qui définit la largeur de l'objet
     * @param largeur largeur de l'objet
     */
    void setLargeur(double largeur) {
        this.largeur = largeur;
    }

    /**
     * Fonction qui s'assure que la longueur et la largeur répondent bien aux contraintes spécifiées
     */
    public void EstDansIntervalle() {
        if (this.longueur < 0 || this.longueur <= this.largeur || this.largeur < 0) {
            throw new IllegalArgumentException();
        }
    }
}
