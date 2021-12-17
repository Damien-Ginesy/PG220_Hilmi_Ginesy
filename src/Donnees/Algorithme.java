package Donnees;

import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import java.io.FileNotFoundException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static LectureEcriture.IOGestion.lecture;

class Algorithme {

    private final List<Client> listeClient;
    private final List<Fournisseur> listeFournisseur;

    Algorithme(String fileName) throws XMLStreamException, FileNotFoundException, ParseException {
        ClientFabrique clientFabrique = new ClientFabrique();
        FournisseurFabrique fournisseurFabrique = new FournisseurFabrique();
        listeClient = genererListe(fileName + "/clients.xml", clientFabrique).stream().map(e -> (Client) e).
                collect(Collectors.toList());
        listeFournisseur = genererListe(fileName + "/fournisseurs.xml", fournisseurFabrique).stream().
                map(e -> (Fournisseur) e).collect(Collectors.toList());
        algorithmeSimple();
    }

    public static void main(String[] args) throws XMLStreamException, FileNotFoundException, ParseException {
        new Algorithme("Etape 2");
    }

    private ArrayList<Interlocuteurs> genererListe(String filename, Fabrique f)
            throws XMLStreamException, FileNotFoundException, ParseException {

        Interlocuteurs interlocuteurs;
        XMLStreamReader fichierConsultable;
        List<Object> recupDonnees;
        ArrayList<Interlocuteurs> liste = new ArrayList<>();

        recupDonnees = lecture(f, filename, null);
        interlocuteurs = (Interlocuteurs) recupDonnees.get(0);
        fichierConsultable = (XMLStreamReader) recupDonnees.get(1);

        while (interlocuteurs != null) {
            interlocuteurs.addBoisListe(verifDonnees(interlocuteurs.getBoisListe()));
            liste.add(interlocuteurs);
            recupDonnees = lecture(f, null, fichierConsultable);
            interlocuteurs = (Interlocuteurs) recupDonnees.get(0);
            fichierConsultable = (XMLStreamReader) recupDonnees.get(1);
        }
        return liste;
    }

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

    private ArrayList<Bois> creerListeBois(List<Interlocuteurs> listeInterlocuteur){
        ArrayList<Bois> totalBoisListe = new ArrayList<>();
        listeInterlocuteur.forEach(interlocuteurs -> totalBoisListe.addAll(interlocuteurs.getBoisListe()));
        return totalBoisListe;
    }

    private void algorithmeSimple() {

        ArrayList<Planche> totalPlancheListe = creerListeBois(listeClient.stream().map(
                client -> (Interlocuteurs) client).collect(Collectors.toList())).stream().map(
                        bois -> (Planche) bois).collect(Collectors.toCollection(ArrayList::new));

        ArrayList<Panneau> totalPanneauListe = creerListeBois(listeFournisseur.stream().map(
                fournisseur -> (Interlocuteurs) fournisseur).collect(Collectors.toList())).stream().map(
                        bois -> (Panneau) bois).collect(Collectors.toCollection(ArrayList::new));

        for(Bois planche : totalPlancheListe ){
            ArrayList<Panneau> panneauPossible = new ArrayList<>(totalPanneauListe);
            panneauPossible.removeIf(panneau-> panneau.getDate().getDate().before(planche.getDate().getDate()));
        }

           /* for (Bois panneau : fournisseurBois){
                java.util.Date date = planche.getDate().getDate();
            }
               for (Bois planche : boisListe) {
                    java.util.Date date = planche.getDate().getDate();
                    if (date)
                }*/


        }


    }