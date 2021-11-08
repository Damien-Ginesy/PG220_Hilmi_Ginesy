package src.Donnees;

public class Prix extends Comparaison{
    double prix;

    Prix(double prix){
        this.prix=prix;
    }

    double getPrix(){return this.prix;}
    void setPrix(double prix)  { this.prix = prix;}

    int EstDansIntervalle(Object Price){
        Prix price=(Prix) Price;
        if(price<0){
            return 1;
        }
        return 0;
    }
}
