package Donnees;

import java.text.ParseException;
import java.util.ArrayList;

/**
 * Classe qui définit la Fabrique de l'objet client dans le cadre du design du pattern factory
 * @see Fabrique
 */
class ClientFabrique implements Fabrique {

    @Override
    public ObjetModifiable generer(ArrayList<String> donnees) throws ParseException {

        if (donnees == null) {
            return null;
        }

        Client client = new Client(Integer.parseInt(donnees.get(0)));

        for (int i = 0; i < donnees.size() / 6; i++) {
            Planche planche = new Planche(donnees.subList(6 * i + 1, donnees.size()), Integer.parseInt(donnees.get(0)));
            client.addBois(planche);
        }
        return client;
    }
}
