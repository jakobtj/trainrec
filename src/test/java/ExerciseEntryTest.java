package trainrec;

import org.junit.Test;
import org.junit.Assert;

import java.time.LocalDate;

public class ExerciseEntryTest {
    @Test
    public void testCompareExerciseEntries() {
        ExerciseEntry first = new ExerciseEntry(
                LocalDate.of(2020, 1, 1), new Exercise("Squat")
                );
        ExerciseEntry second = new ExerciseEntry(
                LocalDate.of(2020, 1, 1), new Exercise("Squat")
                );
        ExerciseEntry third = new ExerciseEntry(
                LocalDate.of(2021, 12, 31), new Exercise("Squat")
                );
        ExerciseEntry fourth = new ExerciseEntry(
                LocalDate.of(2020, 1, 1), new Exercise("Bench press")
                );

        Assert.assertEquals(second, first);
        Assert.assertNotEquals(third, first);
        Assert.assertNotEquals(fourth, first);
    }
}
