package LectureEcriture;

import javax.xml.stream.XMLOutputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.ArrayList;

class XMLEcriture {

    private XMLStreamWriter fichierResultat;

    XMLEcriture(String chemin) throws FileNotFoundException, XMLStreamException {
        FileOutputStream fichier = new FileOutputStream(chemin);
        XMLOutputFactory fichierParser = XMLOutputFactory.newInstance();
        fichierResultat = fichierParser.createXMLStreamWriter(fichier,"UTF-8");
    }

    void ecritureFichier(ArrayList<ArrayList<String>> listeDonnee) throws XMLStreamException {
        fichierResultat.writeStartDocument("UTF-8","1.0");
        fichierResultat.writeCharacters("\n");
        for(ArrayList<String> decoupe : listeDonnee){
            fichierResultat.writeStartElement("Decoupe");
            fichierResultat.writeCharacters("\n\t");
                fichierResultat.writeStartElement("client");
                fichierResultat.writeAttribute("id",decoupe.get(0));
                fichierResultat.writeAttribute("planche",decoupe.get(1)+"."+decoupe.get(2));
                fichierResultat.writeEndElement();
                fichierResultat.writeCharacters("\n\t");

                fichierResultat.writeStartElement("fournisseur");
                fichierResultat.writeAttribute("id",decoupe.get(3));
                fichierResultat.writeAttribute("panneau",decoupe.get(4)+"."+decoupe.get(5));
                fichierResultat.writeEndElement();
                fichierResultat.writeCharacters("\n\t");

                fichierResultat.writeStartElement("position");
                fichierResultat.writeAttribute("x",decoupe.get(6));
                fichierResultat.writeAttribute("y",decoupe.get(7));
                fichierResultat.writeEndElement();
                fichierResultat.writeCharacters("\n");

            fichierResultat.writeEndElement();
            fichierResultat.writeCharacters("\n");
            fichierResultat.writeCharacters("\n");
        }
        fichierResultat.writeEndDocument();
        fichierResultat.flush();
        fichierResultat.close();
    }
}
