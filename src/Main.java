import Donnees.ObjetModifiable;
import LectureEcriture.XMLLecteur;

import javax.xml.stream.XMLStreamException;
import java.io.FileNotFoundException;
import java.text.ParseException;
import java.util.List;

public class Main {
    public static void main(String[] args) throws XMLStreamException, FileNotFoundException, ParseException {
        XMLLecteur lecteur = new XMLLecteur("clients.xml");
        lecteur.LectureDonnee();
        List<ObjetModifiable> donnees = lecteur.getListeDonnees();
        System.out.println("Coucou\n");
    }
}
