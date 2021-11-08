package LectureEcriture;

import Donnees.Client;
import Donnees.ObjetModifiable;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import javax.xml.stream.events.XMLEvent;
import java.io.FileNotFoundException;
import java.util.Objects;

public class XMLLecteur extends IOGestion {

    private final XMLStreamReader fichierConsultable;

    public XMLLecteur(ObjetModifiable objetModifiable, String fichierNom) throws FileNotFoundException, XMLStreamException {
        super(objetModifiable, fichierNom);
        XMLInputFactory fichierParser = XMLInputFactory.newInstance();
        fichierConsultable = fichierParser.createXMLStreamReader(fichier);
    }

    public void LectureDonnee() throws XMLStreamException {
        int evenement;
        while (fichierConsultable.hasNext()) {
            evenement = fichierConsultable.next();
            if (evenement == XMLEvent.START_ELEMENT) {
                if (Objects.equals(fichierConsultable.getName().toString(), "Client")) {
                    Client client = creerClient(fichierConsultable);
                }
            }
        }
    }

    private Client creerClient(XMLStreamReader fichier) throws XMLStreamException {
        fichier.next();
        String idClient = fichier.getText();
        return new Client(Integer.parseInt(idClient));
    }
}
