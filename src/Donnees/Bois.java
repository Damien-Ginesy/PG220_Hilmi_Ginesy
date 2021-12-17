package Donnees;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


/**
 * Classe abstraite qui gère la définition des objets de type Planche et Panneau
 * @see Planche
 * @see Panneau
 */
abstract class Bois implements ObjetModifiable {
    private final Prix prix;
    private final Date date;
    private final Dimension dimension;
    private final int id;
    private final int idProprietaire;
    private int nombre;

    /**
     * Constructeur par défault qui crée un Objet Bois en lui passant les arguments nécessaires
     * @param id défini l'id de la planche ou du panneau
     * @param nombre nombre de planche ou panneau qui répond a des critères spécifiques
     * @param prix prix des planches ou panneaux
     * @param date date de livraison ou délai client pour les planches ou panneaux
     * @param dimension dimensions(Lxl) des planches ou panneaux
     * @param idProprietaire id du client ou founisseur qui possède les planches ou panneaux
     */
    Bois(int id, int nombre, Prix prix, Date date, Dimension dimension, int idProprietaire) {
        this.id = id;
        this.nombre = nombre;
        this.prix = prix;
        this.date = date;
        this.dimension = dimension;
        this.idProprietaire = idProprietaire;
    }

    /**
     * Second constructeur qui s'initialise à l'aide de tableau de chaine de caractères
     * @param donneesPlanche tableau de chaines de caractère qui founit les arguments au constructeur
     * @param idProprietaire id du client ou founisseur qui possède les planches ou panneaux
     * @throws ParseException Vérifie si il est possible de convertir la date au format attendu
     */
    Bois(List<String> donneesPlanche, int idProprietaire) throws ParseException {

        int id = Integer.parseInt(donneesPlanche.get(0));
        int nombre = Integer.parseInt(donneesPlanche.get(1));
        double prixNombre = Double.parseDouble(donneesPlanche.get(2));
        Prix prix = new Prix(prixNombre);
        java.util.Date dateFormat = new SimpleDateFormat("dd.MM.yy").parse(donneesPlanche.get(3));
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

    /**
     * Getter pour le prix
     * @return Prix
     */
    public Prix getPrix() {
        return prix;
    }

    /**
     * Getter pour la date
     * @return Date
     */
    public Date getDate() {
        return date;
    }

    /**
     * Getter pour la dimension
     * @return Dimension
     */
    public Dimension getDimension() {
        return dimension;
    }

    /**
     * Getter pour l'id de la planche ou du panneau
     * @return Id
     */
    int getId() {
        return this.id;
    }

    /**
     * Getter pour le nombre de planches ou de panneaux
     * @return nombre
     */
    int getNombre() {
        return this.nombre;
    }


    /**
     * Getter qui renvoi l'id du fournisseur ou du client
     * @return idProprietaire
     */
    int getIdProprietaire() {
        return idProprietaire;
    }

    /**
     * Setter pour récuperer le nombre de planches ou de panneaux
     * @param nombre nombre de planches ou de panneaux
     */
    void setNombre(int nombre) {
        this.nombre = nombre;
    }
}
