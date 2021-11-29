package Donnees;

class ClientFabrique implements Fabrique {

    @Override
    public ObjetModifiable generer(String[] donnees) {
        return new Client(Integer.parseInt(donnees[0]));
    }
}
