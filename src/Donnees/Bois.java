package Donnees;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

abstract class Bois implements ObjetModifiable {
    private int id;
    private int idProprietaire;
    private int nombre;
    private final Prix prix;
    private final Date date;
    private final Dimension dimension;

    Bois(int id, int nombre, Prix prix, Date date, Dimension dimension, int idProprietaire) {
        this.id = id;
        this.nombre = nombre;
        this.prix = prix;
        this.date = date;
        this.dimension = dimension;
        this.idProprietaire = idProprietaire;
    }

    Bois(List<String> donneesPlanche, int idProprietaire) throws ParseException {

        int id = Integer.parseInt(donneesPlanche.get(0));
        int nombre = Integer.parseInt(donneesPlanche.get(1));
        double prixNombre = Double.parseDouble(donneesPlanche.get(2));
        Prix prix = new Prix(prixNombre);
        java.util.Date dateFormat = new SimpleDateFormat("jj.mm.aaaa").parse(donneesPlanche.get(3));
        Date date = new Date(dateFormat);
        double longueur = Double.parseDouble(donneesPlanche.get(4));
        double largeur = Double.parseDouble(donneesPlanche.get(5));
        Dimension dim = new Dimension(longueur, largeur);

        this.id = id;
        this.nombre = nombre;
        this.prix = prix;
        this.date = date;
        this.dimension = dim;
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
