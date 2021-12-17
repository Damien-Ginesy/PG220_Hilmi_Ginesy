package Donnees;

import java.text.ParseException;
import java.util.List;

/**
 * Classe qui définit un Panneau
 * @see Bois
 */
class Panneau extends Bois {

    /**
     * Constructeur qui génère un objet panneau
     * @param id identifiant du panneau
     * @param nombre nombre de panneaux
     * @param prix prix d'un panneau
     * @param date date maximale de livraison de panneaux
     * @param dimension dimension des panneaux
     * @param idFournisseur identifiant du fournisseur
     */
    Panneau(int id, int nombre, Prix prix, Date date, Dimension dimension, int idFournisseur) {
        super(id, nombre, prix, date, dimension, idFournisseur);
    }

    /**
     * Fonction qui créer un objet panneau à partir d'une liste d'arguments
     * @param donneesPanneau données sur les panneaux
     * @param idClient identification du client
     * @throws ParseException
     */
    Panneau(List<String> donneesPanneau, int idClient) throws ParseException {
        super(donneesPanneau, idClient);
    }
}
