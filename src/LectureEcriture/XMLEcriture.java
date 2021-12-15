package LectureEcriture;

import javax.xml.stream.XMLOutputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

class XMLEcriture {

    private XMLStreamWriter fichierResultat;

    XMLEcriture(String chemin) throws FileNotFoundException, XMLStreamException {
        FileOutputStream fichier = new FileOutputStream(chemin + "Fournisseur.xml");
        XMLOutputFactory fichierParser = XMLOutputFactory.newInstance();
        fichierResultat = fichierParser.createXMLStreamWriter(fichier);
    }

    XMLEcriture(XMLStreamWriter fichier) {
        fichierResultat = fichier;
    }


}
