package Donnees;

import java.text.DecimalFormat;

class Prix implements Comparaison {
    private double prix;

    Prix(double prix) {
        this.prix = prix;
    }

    double getPrix() {
        return this.prix;
    }

    void setPrix(double prix) {
        this.prix = prix;
    }

    @Override
    public void EstDansIntervalle() {
        DecimalFormat df = new DecimalFormat("##.##");
        String stringBonPrix = df.format(this.prix);
        double bonPrix = Double.parseDouble(stringBonPrix);
        if (bonPrix != this.prix || this.prix < 0) {
            throw new IllegalArgumentException();
        }
    }
}
