package src.Donnees;

import java.text.ParseException;
import java.text.DecimalFormat;

public class Prix {
    private double prix;

    public Prix(double prix) {
        this.prix = prix;
    }

    public double getPrix() {
        return this.prix;
    }

    public void setPrix(double prix) {
        this.prix = prix;
    }

    public static int estDansIntervalle(Prix price){

        DecimalFormat df = new DecimalFormat("##.##");
        String stringBonPrix=df.format(price.prix);
        double bonPrix = Double.parseDouble(stringBonPrix);
        if(bonPrix==price.prix && price.prix>0){
            return 0;
        }
        return 1;
    }
}
