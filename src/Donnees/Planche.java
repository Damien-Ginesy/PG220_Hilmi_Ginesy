package Donnees;

import java.text.ParseException;
import java.util.List;

/**
 * Classe qui définit une planche
 */
class Planche extends Bois {

    /**
     * Constructeur par défaut qui initialise avec les paramètres nécessaires
     * @param id id de la planche
     * @param nombre nombre de planches
     * @param prix prix de la planche
     * @param date date maximale de livraison
     * @param dimension dimension de la planche
     * @param idClient identifiant du client
     */
    Planche(int id, int nombre, Prix prix, Date date, Dimension dimension, int idClient) {
        super(id, nombre, prix, date, dimension, idClient);
    }

    /**
     * Fonction qui créer une planche à partir d'une liste d'arguments
     * @param donneesPlanche données sur les planches
     * @param idClient identification du client
     * @throws ParseException
     */
    Planche(List<String> donneesPlanche, int idClient) throws ParseException {
        super(donneesPlanche, idClient);
    }
}
