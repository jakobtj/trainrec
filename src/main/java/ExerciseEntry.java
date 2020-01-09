package trainrec;

import java.time.LocalDate;

class ExerciseEntry {
    private LocalDate date;
    private Exercise exercise;

    public ExerciseEntry(LocalDate date, Exercise exercise) {
        this.date = date;
        this.exercise = exercise;
    }

    @Override
    public boolean equals(Object object) {
        ExerciseEntry other = (ExerciseEntry) object;
        return date.equals(other.date) && exercise.equals(other.exercise);
    }
}
