package src.Donnees;

public class Bois {
    int id;
    int nombre;
    Prix prix;
    Date date;
    Dimension dimension;

    Bois(int id, int nombre, Prix prix, Date date, Dimension dimension) {
        this.id = id;
        this.nombre = nombre;
        this.prix = prix;
        this.date = date;
        this.dimension = dimension;
    }

    int getId() {
        return this.id;
    }

    int getNombre() {
        return this.nombre;
    }

    void setId(int id) {
        this.id = id;
    }

    void setNombre(int nombre) {
        this.nombre = nombre;
    }
}
