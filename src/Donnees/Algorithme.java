package Donnees;

import LectureEcriture.IOGestion;
import LectureEcriture.XMLLecteur;

import javax.xml.stream.XMLStreamException;
import java.io.FileNotFoundException;
import java.text.ParseException;

class Algorithme {

    Algorithme(String fileName) throws XMLStreamException, FileNotFoundException, ParseException {
        ClientFabrique clientFabrique = new ClientFabrique();
        FournisseurFabrique fournisseurFabrique = new FournisseurFabrique();
        IOGestion io = new XMLLecteur(fileName+"/clients.xml");
        IOGestion io2 = new XMLLecteur(fileName+"/fournisseurs.xml");
        Client client = (Client) io.lecture(clientFabrique);
        Fournisseur fournisseur = (Fournisseur) io2.lecture(fournisseurFabrique);
    }

    public static void main(String[] args) throws XMLStreamException, FileNotFoundException, ParseException {
        new Algorithme("Etape 2");
    }
}