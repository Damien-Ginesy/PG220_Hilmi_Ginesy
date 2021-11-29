package Donnees;

class FournisseurFabrique implements Fabrique {

    @Override
    public ObjetModifiable generer(String[] donnees) {
        return new Fournisseur(Integer.parseInt(donnees[0]));
    }
}
