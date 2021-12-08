package Donnees;

import java.text.ParseException;
import java.util.ArrayList;

public interface Fabrique{
    ObjetModifiable generer(ArrayList<String> donnees) throws ParseException;
}
