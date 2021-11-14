package LectureEcriture;

import Donnees.ObjetModifiable;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

abstract public class IOGestion {
    protected ObjetModifiable objetModifiable;
    protected FileInputStream fichier;

    IOGestion(String fichierNom) throws FileNotFoundException {
        this.fichier = new FileInputStream(fichierNom);
    }

    IOGestion(ObjetModifiable objetModifiable,String fichierNom) throws FileNotFoundException {
        this.objetModifiable = objetModifiable;
        this.fichier = new FileInputStream(fichierNom);
    }
}
