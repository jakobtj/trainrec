package no.trainrec.core;

import java.lang.IllegalArgumentException;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.LocalDate;

public class EntryAdder {
    TrainingRecord rec;
    String activeDate;

    public EntryAdder(TrainingRecord rec) {
        this.rec = rec;
        activeDate = LocalDate.now().format(
                DateTimeFormatter.ISO_LOCAL_DATE
                );
    }

    public void addEntry(String exerciseName) {
        ExerciseEntry entry = new ExerciseEntry(activeDate, exerciseName);
        rec.addEntry(entry);
    }

    public void setActiveDate(String date) {
        try {
            // Parse string with local date to check that format is correct
            LocalDate.parse(date, DateTimeFormatter.ISO_LOCAL_DATE);
        } catch (DateTimeParseException ex) {
            throw new IllegalArgumentException(
                    "Date string must have YYYY-MM-DD format"
                    );
        }
        activeDate = date;
    }
}
