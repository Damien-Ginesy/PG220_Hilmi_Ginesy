package LectureEcriture;

import Donnees.Fabrique;
import Donnees.ObjetModifiable;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import javax.xml.stream.events.XMLEvent;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.text.ParseException;
import java.util.ArrayList;

public class XMLLecteur implements IOGestion {

    private final XMLStreamReader fichierConsultable;

    public XMLLecteur(String fichierNom) throws FileNotFoundException, XMLStreamException {
        FileInputStream fichier = new FileInputStream(fichierNom);
        XMLInputFactory fichierParser = XMLInputFactory.newInstance();
        fichierConsultable = fichierParser.createXMLStreamReader(fichier);
    }

    public ArrayList<String> lectureDonnee() throws XMLStreamException, ParseException {
        int evenement;
        while (fichierConsultable.hasNext()) {
            evenement = fichierConsultable.next();
            if (evenement == XMLEvent.START_ELEMENT &&
                    (fichierConsultable.getLocalName().equals("client")
                            || fichierConsultable.getLocalName().equals("fournisseur"))) {
                return creerInterlocuteur();
            }
        }
        return null;
    }

    private ArrayList<String> creerInterlocuteur() throws XMLStreamException, ParseException {
        ArrayList<String> donnees = new ArrayList();
        String idTexte = fichierConsultable.getAttributeValue(null, "id");
        ArrayList<String> data = creerBois();
        donnees.add(idTexte);
        donnees.addAll(data);
        return donnees;
    }

    private ArrayList<String> creerBois() throws XMLStreamException, ParseException {
        ArrayList<String> donnees = new ArrayList();
        while (fichierConsultable.hasNext()) {
            int evenement = fichierConsultable.next();
            if (evenement == XMLEvent.END_ELEMENT && (fichierConsultable.getLocalName().equals("client")
                    || fichierConsultable.getLocalName().equals("fournisseur"))) {
                break;
            }
            if (evenement == XMLEvent.START_ELEMENT &&
                    (fichierConsultable.getLocalName().equals("planche")
                    || fichierConsultable.getLocalName().equals("panneau"))) {

                String idBoisTexte = fichierConsultable.getAttributeValue(null,
                        "id");
                String nombreTexte = fichierConsultable.getAttributeValue(null,
                        "nombre");
                String prixTexte = fichierConsultable.getAttributeValue(null,
                        "prix");
                String dateTexte = fichierConsultable.getAttributeValue(null, "date");

                donnees.add(idBoisTexte);
                donnees.add(nombreTexte);
                donnees.add(prixTexte);
                donnees.add(dateTexte);
            }
            if(evenement == XMLEvent.START_ELEMENT && fichierConsultable.getLocalName().equals("dim")){
                String longueur = fichierConsultable.getAttributeValue(null, "L");
                String largeur = fichierConsultable.getAttributeValue(null, "l");
                donnees.add(longueur);
                donnees.add(largeur);
            }
        }
        return donnees;
    }

    @Override
    public ObjetModifiable lecture(Fabrique f) throws XMLStreamException, ParseException {
        ArrayList<String> donnees = lectureDonnee();
        return f.generer(donnees);
    }
}
