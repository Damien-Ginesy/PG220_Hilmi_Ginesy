package Donnees;

import java.text.ParseException;
import java.util.ArrayList;

/**
 * Interface qui permet de fabriquer des Objets de type ObjetsModifiable c'est à dire des
 * clients et des fournisseurs.
 */
public interface Fabrique {
    /**
     * Fonction qui génère l'ObjetModifiable à partir des données brutes
     * @param donnees tableau des données recuperer sur le fichier xml lu.
     * @return ObjetModifiable
     * @throws ParseException
     */
    ObjetModifiable generer(ArrayList<String> donnees) throws ParseException;
}
