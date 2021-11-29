package Donnees;

import java.util.ArrayList;

class Bois extends ObjetModifiable {
    private int id;
    private int idProprietaire;
    private int nombre;
    private Prix prix;
    private Date date;
    private Dimension dimension;

    Bois(int id, int nombre, Prix prix, Date date, Dimension dimension,int idProprietaire){
        this.id = id;
        this.nombre = nombre;
        this.prix = prix;
        this.date = date;
        this.dimension = dimension;
        this.idProprietaire = idProprietaire;
    }

    int getId() {
        return this.id;
    }

    void setId(int id) {
        this.id = id;
    }

    int getNombre() {
        return this.nombre;
    }

    void setNombre(int nombre) {
        this.nombre = nombre;
    }

    int getIdProprietaire() {
        return idProprietaire;
    }

    void setIdProprietaire(int idProprietaire) {
        this.idProprietaire = idProprietaire;
    }
}
