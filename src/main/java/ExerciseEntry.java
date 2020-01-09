package trainrec;

import java.time.LocalDate;

public class ExerciseEntry {
    private LocalDate date;
    private Exercise exercise;

    public ExerciseEntry(LocalDate date, Exercise exercise) {
        this.date = date;
        this.exercise = exercise;
    }
}
