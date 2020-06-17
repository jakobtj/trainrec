package no.trainrec.core;

import java.lang.IllegalArgumentException;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
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
        try {
            return new EntryDate(LocalDate.parse(isoformatted, formatter));
        } catch (DateTimeParseException ex) {
            throw new IllegalArgumentException(
                    "Date string must have YYYY-MM-DD format"
                    );
        }
    }

    public String toString() {
        return date.format(formatter);
    }
}
