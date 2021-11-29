package src.Donnees;

public class Planche extends Bois {

    public Planche(int id, int nombre, Prix prix, Date date, Dimension dimension,int idClient) {
        super(id, nombre, prix, date, dimension,idClient);
    }

    public Planche(int id, int nombre, Prix prix, Date date ,int idClient) {
        super(id, nombre, prix, date, null, idClient);
    }
}
