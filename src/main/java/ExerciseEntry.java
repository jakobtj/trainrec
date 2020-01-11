package trainrec;

import java.util.Comparator;
import java.time.LocalDate;

class ExerciseEntry {
    private LocalDate date;
    private Exercise exercise;

    public ExerciseEntry(LocalDate date, Exercise exercise) {
        this.date = date;
        this.exercise = exercise;
    }

    public LocalDate getDate() {
        return date;
    }

    public Exercise getExercise() {
        return exercise;
    }

    @Override
    public boolean equals(Object object) {
        ExerciseEntry other = (ExerciseEntry) object;
        return date.equals(other.date) && exercise.equals(other.exercise);
    }

	public static Comparator<ExerciseEntry> sortByDate = 
        new Comparator<ExerciseEntry>() {
            @Override
		    public int compare(ExerciseEntry lhs, ExerciseEntry rhs) {
                return lhs.date.compareTo(rhs.date);
            }
	};
}
