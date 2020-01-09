package trainrec;

import org.junit.Test;
import static org.junit.Assert.assertTrue;

import java.time.LocalDate;
import java.util.ArrayList;

public class UseCaseTest {
    @Test
    public void testExerciseEntryAdd() {
        ArrayList<ExerciseEntry> entries = new ArrayList<ExerciseEntry>();
        LocalDate today = LocalDate.now();
        Exercise squat = new Exercise("Squat");
        ExerciseEntry squatEntry = new ExerciseEntry(today, squat);

        ExerciseEntryAdd adder = new ExerciseEntryAdd(entries);
        adder.execute(squatEntry);

        assertTrue(entries.contains(squatEntry));
    }
}
