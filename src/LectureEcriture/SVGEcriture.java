package LectureEcriture;

/*
public class SVGEcriture implements IOGestion{
	
	private FileWriter fichier_ecrit;
	
	public SVGEcriture(File nom_fichier_cree,String nom_fichier_xml) throws IOException, XMLStreamException {
		super(nom_fichier_xml);
		this.fichier_ecrit = new FileWriter(nom_fichier_cree,true);
		FileInputStream fichier_lu = new FileInputStream(nom_fichier_xml);
        XMLInputFactory xmlInFact = XMLInputFactory.newInstance();
        XMLStreamReader lecteur = xmlInFact.createXMLStreamReader(fichier_lu);
        
        lecteur.nextTag(); //On regarde le client associer
        lecteur.nextTag(); //On regarde la planche du fournisseur qui est découpé
		
		String writer= "<?xml version='1.0' encoding='utf-8'?>\n";
		writer= writer +"<svg xmlns='http://www.w3.org/2000/svg' version='1.1' width='' height=''>\n";
		writer=writer+"<line x1='"+lecteur.getAttributeValue(0)+"' y1='"+lecteur.getAttributeValue(1)+"' ";
		lecteur.nextTag(); //On regarde le second point pour avoir le segment découpé
		writer=writer+"x2='"+lecteur.getAttributeValue(0)+"' y2='"+lecteur.getAttributeValue(1)+"' style='stroke:;stroke-width:3' />\n";
		writer=writer+"\n";
		writer=writer+"</svg>";
		this.fichier_ecrit.write(writer);
		
	}

	@Override
	public ObjetModifiable lecture(Fabrique f) throws XMLStreamException, ParseException {
		return null;
	}
}
*/
