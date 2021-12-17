package Donnees;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Classe qui définit la date de livraison des panneaux
 * @see Client
 * @see Fournisseur
 */
class Date implements Comparaison {
    private java.util.Date date;
    /**
     * Constructeur par défault qui crée un Objet Date
     * @param date la date de livraison des panneaux
     */
    Date(java.util.Date date) {
        this.date = date;
    }
    /**
     * Getter pour la date
     * @return Date
     */
    java.util.Date getDate() {
        return this.date;
    }
    /**
     * Setter pour la date
     */
    void setDate(java.util.Date date) {
        this.date = date;
    }

    /**
     * Fonction qui vérifie que la date est valide
     * @throws ParseException vérifie que la date peut être mis au format voulu
     */
    @Override
    public void EstDansIntervalle() throws ParseException {

        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd.MM.yy");
        String aujourdhui = dtf.format(LocalDateTime.now());

        SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yy");

        if (this.date.compareTo(sdf.parse(aujourdhui)) <= 0) {
            //verifier que la date est dans le futur
            throw new IllegalArgumentException();
        }
    }
}
