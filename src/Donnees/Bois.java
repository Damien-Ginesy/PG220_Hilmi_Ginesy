package Donnees;

public class Bois implements ObjetModifiable {
    private int id;
    private int idProprietaire;
    private int nombre;
    private Prix prix;
    private Date date;
    private Dimension dimension;

    public Bois(int id, int nombre, Prix prix, Date date, Dimension dimension,int idProprietaire){
        this.id = id;
        this.nombre = nombre;
        this.prix = prix;
        this.date = date;
        this.dimension = dimension;
        this.idProprietaire = idProprietaire;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getNombre() {
        return this.nombre;
    }

    public void setNombre(int nombre) {
        this.nombre = nombre;
    }

    public int getIdProprietaire() {
        return idProprietaire;
    }

    public void setIdProprietaire(int idProprietaire) {
        this.idProprietaire = idProprietaire;
    }
}
