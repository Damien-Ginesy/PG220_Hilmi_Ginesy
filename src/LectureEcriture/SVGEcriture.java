package LectureEcriture;

import Donnees.*;
import java.io.*;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import javax.xml.stream.events.XMLEvent;
import java.io.FileNotFoundException;
import java.text.ParseException;

import java.io.FileWriter;

public class SVGEcriture extends IOGestion{
	
	protected ObjetModifiable objetModifiable;
	private FileWriter fichier_ecrit;
	private FileInputStream fichier_lu = null;
	
	
	public SVGEcriture(ObjetModifiable objetModifiable,String nom_fichier_cree,String nom_fichier_xml) {
		this.fichier_ecrit = new FileWriter(nom_fichier_cree);
		this.fichier_lu = new FileInputStream(nom_fichier_xml);
        XMLInputFactory xmlInFact = XMLInputFactory.newInstance();
        XMLStreamReader lecteur = xmlInFact.createXMLStreamReader(this.fichier_lu);
        
        lecteur.nextTag(); //On regarde le client associer
        lecteur.nextTag(); //On regarde la planche du fournisseur qui est découpé
        
		this.objetModifiable = objetModifiable;
		final String writer;
		writer= writer + "<?xml version='1.0' encoding='utf-8'?>\n";
		writer= writer +"<svg xmlns='http://www.w3.org/2000/svg' version='1.1' width='' height=''>\n";
		writer=writer+"<line x1='"+lecteur.getAttributeValue(0)+"' y1='"+lecteur.getAttributeValue(1)+"' ";
		lecteur.nextTag(); //On regarde le second point pour avoir le segment découpé
		writer=writer+"x2='"+lecteur.getAttributeValue(0)+"' y2='"+lecteur.getAttributeValue(1)+"' style='stroke:;stroke-width:3' />\n";
		writer=writer+"\n";
		writer=writer+"</svg>";
		this.fichier_ecrit.write(writer);
		
	}
}
