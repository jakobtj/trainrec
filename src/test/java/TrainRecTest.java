package trainrec;

import org.junit.Test;
import org.junit.Assert;

import java.time.LocalDate;

public class TrainRecTest {
    @Test
    public void testCompareExercises() {
        Exercise first = new Exercise("Squat");
        Exercise second = new Exercise("Squat");
        Exercise third = new Exercise("Bench press");

        Assert.assertEquals(second, first);
        Assert.assertNotEquals(third, first);
    }

    @Test
    public void testCreateEmptyTrainingRecord() {
        TrainingRecord rec = new TrainingRecord();
        Assert.assertEquals(0, rec.getExerciseCount());
    }

    @Test
    public void testAddExerciseToTrainingRecord() {
        TrainingRecord rec = new TrainingRecord();
        Exercise squat = new Exercise("Squat");
        LocalDate today = LocalDate.now();
        ExerciseEntry squatEntry = new ExerciseEntry(today, squat);

        rec.add(squatEntry);

        Assert.assertTrue(rec.contains(squatEntry));
        Assert.assertEquals(1, rec.getExerciseCount());
    }
}
