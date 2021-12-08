package Donnees;

import java.text.ParseException;
import java.util.List;

class Panneau extends Bois {

    Panneau(int id, int nombre, Prix prix, Date date, Dimension dimension, int idFournisseur) {
        super(id, nombre, prix, date, dimension, idFournisseur);
    }

    Panneau(List<String> donneesPanneau, int idClient) throws ParseException {
        super(donneesPanneau, idClient);
    }
}
