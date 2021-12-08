package Donnees;

import java.text.ParseException;
import java.util.ArrayList;

class ClientFabrique implements Fabrique {

    @Override
    public ObjetModifiable generer(ArrayList<String> donnees) throws ParseException {
        Client client = new Client(Integer.parseInt(donnees.get(0)));

        for (int i = 0; i < donnees.size()/6; i++) {
            Planche planche = new Planche(donnees.subList(6 * i + 1, donnees.size()), Integer.parseInt(donnees.get(0)));
            client.addBois(planche);
        }
        return client;
    }
}
