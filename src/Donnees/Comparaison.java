package Donnees;

import java.text.ParseException;

/**
 * Interface qui permet de comparer des objets
 */
public interface Comparaison {
    /**
     * Fonction qui permet de savoir si un objet répond au critère spécifié
     * @throws ParseException
     */
    void EstDansIntervalle() throws ParseException;
}
