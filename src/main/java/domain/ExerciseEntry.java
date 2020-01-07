package domain;

import java.util.Date;

public class ExerciseEntry {
    private Date date;
    private Exercise exercise;

    public ExerciseEntry(Date date, Exercise exercise) {
        this.date = date;
        this.exercise = exercise;
    }
}
