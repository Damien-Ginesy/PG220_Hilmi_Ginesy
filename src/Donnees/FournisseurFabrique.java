package Donnees;

import java.util.ArrayList;

class FournisseurFabrique implements Fabrique {

    @Override
    public ObjetModifiable generer(ArrayList<String> donnees) {
        return new Fournisseur(Integer.parseInt(donnees.get(0)));
    }
}
