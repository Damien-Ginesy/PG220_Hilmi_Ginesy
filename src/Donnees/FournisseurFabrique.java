package Donnees;

import java.text.ParseException;
import java.util.ArrayList;

/**
 * Classe qui définit la Fabrique de l'objet fournisseur dans le cadre du design du pattern factory
 * @see Fabrique
 */
class FournisseurFabrique implements Fabrique {

    @Override
    public ObjetModifiable generer(ArrayList<String> donnees) throws ParseException {

        if (donnees == null) {
            return null;
        }

        Fournisseur fournisseur = new Fournisseur(Integer.parseInt(donnees.get(0)));
        for (int i = 0; i < donnees.size() / 6; i++) {
            Panneau panneau = new Panneau(donnees.subList(6 * i + 1, donnees.size()), Integer.parseInt(donnees.get(0)));
            fournisseur.addBois(panneau);
        }
        return fournisseur;
    }
}
