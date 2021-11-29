package Donnees;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.text.DateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

class Date {
    private java.util.Date date;

    public Date(java.util.Date date) {
        this.date = date;
    }

    public java.util.Date getDate() {
        return this.date;
    }

    public void setDate(java.util.Date date) {
        this.date = date;
    }

    public static int estDansIntervalle(String date) throws ParseException {
        try {
            DateFormat df = new SimpleDateFormat("dd.mm.aa");
            df.setLenient(false);
            df.parse(date);
        }
        catch (ParseException e) {
            return 1;
        }
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd.mm.aa");
        String aujourdhui= dtf.format(LocalDateTime.now());

        SimpleDateFormat sdf = new SimpleDateFormat("dd.mm.aa");

        if (sdf.parse(date).compareTo(sdf.parse(aujourdhui)) > 0) {
            //verifier que la date est dans le futur
            return 0;
        }
        return 1;
    }
}
