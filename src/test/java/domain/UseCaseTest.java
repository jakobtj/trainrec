package usecases;

import org.junit.Test;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Date;

public class UseCaseTest {
    @Test
    public void testExerciseEntryAdd() {
        ArrayList<ExerciseEntry> entries = new ArrayList();
        Date today = new Date();
        Exercise squat = new Exercise("Squat");
        ExerciseEntry squatEntry = new ExerciseEntry(squat, today);

        ExerciseEntryAdd adder = new ExerciseEntryAdd(entries);
        ExerciseEntryAdd.execute(squatEntry);

        assertTrue(entries.contains(squatEntry));
    }
}
