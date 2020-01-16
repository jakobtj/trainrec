package trainrec;

import java.time.format.DateTimeFormatter;
import java.time.LocalDate;

public class EntryDate {
    private LocalDate date;
    private static DateTimeFormatter formatter 
        = DateTimeFormatter.ISO_LOCAL_DATE;

    public EntryDate(LocalDate date) {
        this.date = date;
    }

    public static EntryDate today() {
        return new EntryDate(LocalDate.now());
    }

    public static EntryDate fromString(String isoformatted) {
        return new EntryDate(LocalDate.parse(isoformatted, formatter));
    }

    public String toString() {
        return date.format(formatter);
    }
}
