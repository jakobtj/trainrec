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

    @Test
    public void testSortEntries() {
        // Sorts by date. Most recent entry comes first.
        LocalDate longAgo = LocalDate.of(1900, 1, 1);
        LocalDate moreRecent = LocalDate.of(1950, 1, 1);
        Exercise squat = new Exercise("Squat");

        ExerciseEntry longAgoSquat = new ExerciseEntry(longAgo, squat);
        ExerciseEntry moreRecentSquat = new ExerciseEntry(moreRecent, squat);

        TrainingRecord rec = new TrainingRecord();
        rec.setDate(moreRecent);
        rec.addEntry("Squat");
        rec.setDate(longAgo);
        rec.addEntry("Squat");

        // Assert that entries are in added order before sorting
        Assert.assertEquals(moreRecentSquat, rec.getEntries().get(0));
        Assert.assertEquals(longAgoSquat, rec.getEntries().get(1));

        rec.sort();

        Assert.assertEquals(longAgoSquat, rec.getEntries().get(0));
        Assert.assertEquals(moreRecentSquat, rec.getEntries().get(1));
    }
}
