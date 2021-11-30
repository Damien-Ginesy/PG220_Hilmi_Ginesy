package LectureEcriture;

import Donnees.Fabrique;
import Donnees.ObjetModifiable;

import javax.xml.stream.XMLStreamException;
import java.text.ParseException;

public interface IOGestion {
    ObjetModifiable lecture(Fabrique f) throws XMLStreamException, ParseException;
}
