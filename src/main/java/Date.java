package trainrec;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Date {
    private LocalDate date;
    private static DateTimeFormatter formatter 
        = DateTimeFormatter.ISO_LOCAL_DATE;

    public Date(LocalDate date) {
        this.date = date;
    }

    public static Date today() {
        return new Date(LocalDate.now());
    }

    public static Date fromString(String isoformatted) {
        return new Date(LocalDate.parse(isoformatted, formatter));
    }

    public String toString() {
        return date.format(formatter);
    }
}
