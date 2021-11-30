package Donnees;

import java.text.ParseException;
import java.util.List;

class Planche extends Bois {

    Planche(int id, int nombre, Prix prix, Date date, Dimension dimension, int idClient) {
        super(id, nombre, prix, date, dimension, idClient);
    }

    Planche(List<String> donneesPlanche, int idClient) throws ParseException {
        super(donneesPlanche, idClient);
    }
}
