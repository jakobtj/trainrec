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

    @Test
    public void testCSVConverterFromString() {
        String inString = "2020.01.10;Squat";
        ExerciseEntry converted = CSVConverter.fromString(inString);
        ExerciseEntry comparison = new ExerciseEntry(
                LocalDate.of(2020, 1, 10), new Exercise("Squat")
                );
        Assert.assertEquals(comparison, converted);
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
