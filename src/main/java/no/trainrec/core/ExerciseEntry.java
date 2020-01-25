package no.trainrec.core;

import java.util.Comparator;

public class ExerciseEntry {
    private String date;
    private String exercise;

    public ExerciseEntry(String date, String exercise) {
        this.date = date;
        this.exercise = exercise;
    }

    public String getDate() {
        return date;
    }

    public String getExercise() {
        return exercise;
    }

	public static Comparator<ExerciseEntry> sortByDate = 
        new Comparator<ExerciseEntry>() {
            @Override
		    public int compare(ExerciseEntry lhs, ExerciseEntry rhs) {
                return lhs.date.compareTo(rhs.date);
            }
	};
}
