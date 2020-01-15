package trainrec;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Date {
    private LocalDate date;
    private DateTimeFormatter formatter;

    public Date(LocalDate date) {
        this.date = date;
        formatter = DateTimeFormatter.ISO_LOCAL_DATE;
    }

    public static Date today() {
        return new Date(LocalDate.now());
    }

    public String toString() {
        return date.format(formatter);
    }
}
