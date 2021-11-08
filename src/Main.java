import Donnees.Client;
import Donnees.ObjetModifiable;
import LectureEcriture.XMLLecteur;

import javax.xml.stream.XMLStreamException;
import java.io.FileNotFoundException;

public class Main {
    public static void main(String[] args) throws XMLStreamException, FileNotFoundException {
        ObjetModifiable objet = new Client();
        XMLLecteur lecteur = new XMLLecteur(objet,"clients.xml");
        lecteur.LectureDonnee();
    }
}
