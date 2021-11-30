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

class XMLLecteur implements IOGestion {

    private final XMLStreamReader fichierConsultable;

    XMLLecteur(String fichierNom) throws FileNotFoundException, XMLStreamException {
        FileInputStream fichier = new FileInputStream(fichierNom);
        XMLInputFactory fichierParser = XMLInputFactory.newInstance();
        fichierConsultable = fichierParser.createXMLStreamReader(fichier);
    }

    public ArrayList<String> lectureDonnee() throws XMLStreamException, ParseException {
        int evenement;
        while (fichierConsultable.hasNext()) {
            evenement = fichierConsultable.next();
            if (evenement == XMLEvent.START_ELEMENT &&
                    fichierConsultable.getLocalName().equals("client")) {
                return creerClient();
            }
        }
        return null;
    }

    private ArrayList<String> creerClient() throws XMLStreamException, ParseException {
        ArrayList<String> donnees = new ArrayList();
        String idClientTexte = fichierConsultable.getAttributeValue(null, "id");
        ArrayList<String> data = creerPlanche();
        donnees.add(idClientTexte);
        donnees.addAll(data);
        return donnees;
    }

    private ArrayList<String> creerPlanche() throws XMLStreamException, ParseException {
        ArrayList<String> donnees = new ArrayList();
        while (fichierConsultable.hasNext()) {
            int evenement = fichierConsultable.next();
            if (evenement == XMLEvent.END_ELEMENT && fichierConsultable.getLocalName().equals("client")) {
                break;
            }
            if (evenement == XMLEvent.START_ELEMENT &&
                    fichierConsultable.getLocalName().equals(("planche"))) {

                String idPlancheTexte = fichierConsultable.getAttributeValue(null,
                        "id");
                String nombreTexte = fichierConsultable.getAttributeValue(null,
                        "nombre");
                String prixTexte = fichierConsultable.getAttributeValue(null,
                        "prix");
                String dateTexte = fichierConsultable.getAttributeValue(null, "date");

                donnees.add(idPlancheTexte);
                donnees.add(nombreTexte);
                donnees.add(prixTexte);
                donnees.add(dateTexte);
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
