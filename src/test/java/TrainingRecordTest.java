package trainrec;

import org.junit.Test;
import org.junit.Assert;

import java.util.List;
import java.util.Arrays;

public class TrainingRecordTest {
    @Test
    public void testNewRecordHasZeroEntries() {
        TrainingRecord rec = new TrainingRecord();
        List entries = rec.listEntries();

        Assert.assertEquals(0, entries.size());
    }

    @Test
    public void testAddEntry() {
        String inputDate = "2020-10-01";
        String inputExercise = "Squat";

        TrainingRecord rec = new TrainingRecord();
        EntryDate date = EntryDate.fromString(inputDate);
        rec.setActiveDate(date);
        rec.addEntry(inputExercise);

        List<ExerciseEntry> entries = rec.listEntries();
        String outputExercise = entries.get(0).getExercise();
        String outputDate = entries.get(0).getDate();

        Assert.assertEquals(1, entries.size());
        Assert.assertEquals(inputExercise, outputExercise);
        Assert.assertEquals(inputDate, outputDate);
    }

    @Test
    public void testMultipleEntriesAreReturnedChronologically() {
        String longAgo = "1900-05-31";
        String recently = "2020-10-01";
        String inbetween = "1950-12-15";
        List<String> dates = Arrays.asList(recently, longAgo, inbetween);

        TrainingRecord rec = new TrainingRecord();
        for (String date : dates) {
            EntryDate inputDate = EntryDate.fromString(date);
            rec.setActiveDate(inputDate);
            rec.addEntry("Squat");
        }

        List<ExerciseEntry> entries = rec.listEntries();

        Assert.assertEquals(3, entries.size());
        Assert.assertEquals(longAgo, entries.get(0).getDate());
        Assert.assertEquals(inbetween, entries.get(1).getDate());
        Assert.assertEquals(recently, entries.get(2).getDate());
    }
}
