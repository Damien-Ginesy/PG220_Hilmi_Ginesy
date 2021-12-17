package Donnees;

import LectureEcriture.IOGestion;

import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import java.io.FileNotFoundException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static LectureEcriture.IOGestion.lecture;

/**
 * Classe principale du projet qui définit les algorithmes de découpes et réalise
 * le processus opérationnel du projet
 */
class Algorithme {

    private final List<Client> listeClient;
    private final List<Fournisseur> listeFournisseur;

    /**
     * Constructeur qui lance l'execution opérationnel du projet
     *
     * @param fileName nom de chemin vers le fichier XML à lire
     */
    Algorithme(String fileName) throws XMLStreamException, FileNotFoundException, ParseException {
        ClientFabrique clientFabrique = new ClientFabrique();
        FournisseurFabrique fournisseurFabrique = new FournisseurFabrique();
        listeClient = genererListe(fileName + "/clients.xml", clientFabrique).stream().map(e -> (Client) e).
                collect(Collectors.toList());
        listeFournisseur = genererListe(fileName + "/fournisseurs.xml", fournisseurFabrique).stream().
                map(e -> (Fournisseur) e).collect(Collectors.toList());
        algorithmeSimple();
    }

    /**
     * Point d'entrée dans le programme
     *
     * @param args arguments de la ligne de commande
     */
    public static void main(String[] args) throws XMLStreamException, FileNotFoundException, ParseException {
        new Algorithme("Etape 2");
    }

    /**
     * Fonction qui construit la liste des clients et des fournisseurs à partir des données
     * fourni par le XML
     *
     * @param filename nom du chemin vers le fichier XML à lire
     * @param f        factory à fournir en fonction du type d'Objet désirée en retour
     * @return ArrayList<Interlocuteurs>
     */
    private ArrayList<Interlocuteurs> genererListe(String filename, Fabrique f)
            throws XMLStreamException, FileNotFoundException, ParseException {

        ArrayList<Interlocuteurs> liste = new ArrayList<>();

        List<Object> recupDonnees = lecture(f, filename, null);
        Interlocuteurs interlocuteurs = (Interlocuteurs) recupDonnees.get(0);
        XMLStreamReader fichierConsultable = (XMLStreamReader) recupDonnees.get(1);

        while (interlocuteurs != null) {
            interlocuteurs.addBoisListe(verifDonnees(interlocuteurs.getBoisListe()));
            liste.add(interlocuteurs);
            recupDonnees = lecture(f, null, fichierConsultable);
            interlocuteurs = (Interlocuteurs) recupDonnees.get(0);
            fichierConsultable = (XMLStreamReader) recupDonnees.get(1);
        }
        return liste;
    }

    /**
     * Fonction qui vérifie que les planches ou panneaux répondent bien aux contraintes spécifiées
     *
     * @param boisListe liste de planches ou panneaux
     * @return ArrayList<Bois>
     */
    private ArrayList<Bois> verifDonnees(ArrayList<Bois> boisListe) throws ParseException {
        ArrayList<Bois> boisSupp = new ArrayList<>();
        for (Bois bois : boisListe) {
            try {
                bois.getDimension().EstDansIntervalle();
                bois.getPrix().EstDansIntervalle();
                bois.getDate().EstDansIntervalle();
            } catch (IllegalArgumentException e) {
                boisSupp.add(bois);
            }
        }
        if (boisSupp.size() > 0) {
            boisListe.removeAll(boisSupp);
        }
        return boisListe;
    }

    /**
     * @param listeInterlocuteur liste de clients ou de fournisseurs
     * @return ArrayList<Bois>
     */
    private ArrayList<Bois> creerListeBois(List<Interlocuteurs> listeInterlocuteur) {
        ArrayList<Bois> totalBoisListe = new ArrayList<>();
        listeInterlocuteur.forEach(interlocuteurs -> totalBoisListe.addAll(interlocuteurs.getBoisListe()));
        return totalBoisListe;
    }

    private void algorithmeSimple() throws XMLStreamException, FileNotFoundException {

        ArrayList<Planche> totalPlancheListe = creerListeBois(listeClient.stream().map(
                client -> (Interlocuteurs) client).collect(Collectors.toList())).stream().map(
                bois -> (Planche) bois).collect(Collectors.toCollection(ArrayList::new));

        ArrayList<Panneau> totalPanneauListe = creerListeBois(listeFournisseur.stream().map(
                fournisseur -> (Interlocuteurs) fournisseur).collect(Collectors.toList())).stream().map(
                bois -> (Panneau) bois).collect(Collectors.toCollection(ArrayList::new));

        ArrayList<Decoupe> totalListeDecoupe = new ArrayList<>();

        for (Planche planche : totalPlancheListe) {
            ArrayList<Panneau> panneauPossible = new ArrayList<>(totalPanneauListe);
            panneauPossible.removeIf(panneau -> panneau.getDate().getDate().before(
                    planche.getDate().getDate()));
            panneauPossible.removeIf(panneau -> panneau.getDimension().inferieur(planche.getDimension()));
            totalListeDecoupe.addAll(decoupePanneau(panneauPossible, planche));
        }
        IOGestion.ecriture(ecritureFormateur(totalListeDecoupe));
    }

    private ArrayList<ArrayList<String>> ecritureFormateur(ArrayList<Decoupe> decoupePanneau) {
        ArrayList<ArrayList<String>> liste = new ArrayList<>();
        decoupePanneau.stream().forEach(decoupe -> liste.add(decoupe.ecritureFormat()));
        return liste;
    }

    private ArrayList<Decoupe> decoupePanneau(ArrayList<Panneau> listePanneau, Planche planche) {
        ArrayList<Decoupe> listeDecoupe = new ArrayList<>();
        int nbPlanche = 1;
        for (Panneau panneau : listePanneau) {
            int nbPanneau = 1;
            while (nbPanneau < panneau.getNombre()) {
                listeDecoupe.add(new Decoupe(planche.getIdProprietaire(), panneau.getIdProprietaire(), planche.getId(), panneau.getId(),
                        nbPlanche, nbPanneau, planche.getDimension().getLargeur(), planche.getDimension().getLongueur()));
                nbPanneau++;
                nbPlanche++;
                if (nbPlanche == planche.getNombre()) {
                    return listeDecoupe;
                }
            }
        }
        return listeDecoupe;
    }
}