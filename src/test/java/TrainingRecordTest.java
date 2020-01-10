package trainrec;

import org.junit.Test;
import org.junit.Assert;

import java.time.LocalDate;

public class TrainingRecordTest {
    @Test
    public void testCreateNew() {
        TrainingRecord rec = new TrainingRecord();

        Assert.assertEquals(0, rec.getEntryCount());
        Assert.assertEquals(LocalDate.now(), rec.getDate());
    }

    @Test
    public void testAddExerciseEntry() {
        TrainingRecord rec = new TrainingRecord();
        rec.addEntry("Squat");
        Exercise squat = new Exercise("Squat");
        ExerciseEntry squatEntry = new ExerciseEntry(LocalDate.now(), squat);

        Assert.assertEquals(1, rec.getEntryCount());
        Assert.assertTrue(rec.contains(squatEntry));
    }

    @Test
    public void testSetDate() {
        TrainingRecord rec = new TrainingRecord();
        LocalDate newDate = LocalDate.of(2021, 12, 31);
        Exercise squat = new Exercise("Squat");
        ExerciseEntry squatEntry = new ExerciseEntry(newDate, squat);

        rec.setDate(newDate);
        rec.addEntry("Squat");

        Assert.assertTrue(rec.contains(squatEntry));
    }
}
