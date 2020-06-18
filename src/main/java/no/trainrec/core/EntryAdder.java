package no.trainrec.core;

import java.time.format.DateTimeFormatter;
import java.time.LocalDate;

public class EntryAdder {
    TrainingRecord rec;
    String activeDate;

    public EntryAdder(TrainingRecord rec) {
        this.rec = rec;
        this.activeDate = LocalDate.now().format(
                DateTimeFormatter.ISO_LOCAL_DATE
                );
    }

    public void addEntry(String exerciseName) {
        ExerciseEntry entry = new ExerciseEntry(activeDate, exerciseName);
        rec.addEntry(entry);
    }
}
