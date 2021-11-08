package Donnees;

public class Date {
    private Date date;

    public Date(Date date) {
        this.date = date;
    }

    public Date getDate() {
        return this.date;
    }

    public void setDate(Date date) {
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
