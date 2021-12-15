package Donnees;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

class Date implements Comparaison {
    private java.util.Date date;

    Date(java.util.Date date) {
        this.date = date;
    }

    java.util.Date getDate() {
        return this.date;
    }

    void setDate(java.util.Date date) {
        this.date = date;
    }

    @Override
    public void EstDansIntervalle() throws ParseException {

        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd.MM.yy");
        String aujourdhui = dtf.format(LocalDateTime.now());

        SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yy");

        if (this.date.compareTo(sdf.parse(aujourdhui)) <= 0) {
            //verifier que la date est dans le futur
            throw new IllegalArgumentException();
        }
    }
}
