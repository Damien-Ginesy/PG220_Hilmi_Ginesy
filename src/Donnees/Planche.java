package Donnees;

class Planche extends Bois {

    Planche(int id, int nombre, Prix prix, Date date, Dimension dimension,int idClient) {
        super(id, nombre, prix, date, dimension,idClient);
    }

    Planche(int id, int nombre, Prix prix, Date date ,int idClient) {
        super(id, nombre, prix, date, null, idClient);
    }
}
