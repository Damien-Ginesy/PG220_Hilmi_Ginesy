package src.Donnees;

public class Date {
    Date date;

    Date(Date date) {
        this.date = date;
    }

    Date getDate() {
        return this.date;
    }

    void setDate(Date date) {
        this.date = date;
    }

    int EstDansIntervalle(Object date){
        SimpleDateFormat format = new SimpleDateFormat("JJ/MM/AA");
        format.setLenient(false);
        try
        {
            Date d = (Date) date;

        }
        // Date invalide
        catch (ParseException e)
        {
            System.out.println(date+" est une date invalide");
            return 1;
        }
        return 0;
    }
}
