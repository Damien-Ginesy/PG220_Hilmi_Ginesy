package Donnees;

import java.text.ParseException;
import java.util.ArrayList;

class FournisseurFabrique implements Fabrique {

    @Override
    public ObjetModifiable generer(ArrayList<String> donnees) throws ParseException {

        Fournisseur fournisseur = new Fournisseur(Integer.parseInt(donnees.get(0)));
        for (int i = 0; i < donnees.size()/6; i++) {
            Panneau panneau = new Panneau(donnees.subList(6 * i + 1, donnees.size()), Integer.parseInt(donnees.get(0)));
            fournisseur.addBois(panneau);
        }
        return fournisseur;
    }
}
