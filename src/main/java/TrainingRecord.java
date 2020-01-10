package trainrec;

import java.util.ArrayList;
import java.time.LocalDate;

public class TrainingRecord {
    private ArrayList<ExerciseEntry> entries;
    private LocalDate date;

    public TrainingRecord() {
        entries = new ArrayList();
        date = LocalDate.now();
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate newDate) {
        date = newDate;
    }

    public void addEntry(String exerciseName) {
        Exercise exercise = new Exercise(exerciseName);
        ExerciseEntry entry = new ExerciseEntry(date, exercise);
        entries.add(entry);
    }

    public boolean contains(ExerciseEntry entry) {
        return entries.contains(entry);
    }

    public int getEntryCount() {
        return entries.size();
    }

}
