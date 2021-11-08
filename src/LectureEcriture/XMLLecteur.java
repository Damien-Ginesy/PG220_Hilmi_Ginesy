package LectureEcriture;

import Donnees.ObjetModifiable;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import javax.xml.stream.events.XMLEvent;
import java.io.FileNotFoundException;

public class XMLLecteur extends IOGestion {

    XMLStreamReader fichierConsultable;

    public XMLLecteur(ObjetModifiable objetModifiable, String fichierNom) throws FileNotFoundException, XMLStreamException {
        super(objetModifiable, fichierNom);
        XMLInputFactory fichierParser = XMLInputFactory.newInstance();
        fichierConsultable = fichierParser.createXMLStreamReader(fichier);
    }

    public void LectureDonnee() throws XMLStreamException {
        int evenement;
        while(fichierConsultable.hasNext()) {
            evenement = fichierConsultable.next();
            switch (evenement) {
                case XMLEvent.START_ELEMENT:
                    System.out.println(fichierConsultable.getName());
                    break;
            }
        }
    }
}
