package usecases;

import org.junit.Test;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Date;

import domain.ExerciseEntry;
import domain.Exercise;
import usecases.ExerciseEntryAdd;

public class UseCaseTest {
    @Test
    public void testExerciseEntryAdd() {
        ArrayList<ExerciseEntry> entries = new ArrayList<ExerciseEntry>();
        Date today = new Date();
        Exercise squat = new Exercise("Squat");
        ExerciseEntry squatEntry = new ExerciseEntry(today, squat);

        ExerciseEntryAdd adder = new ExerciseEntryAdd(entries);
        adder.execute(squatEntry);

        assertTrue(entries.contains(squatEntry));
    }
}
