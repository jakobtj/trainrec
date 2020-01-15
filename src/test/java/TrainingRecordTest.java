package trainrec;

import org.junit.Test;
import org.junit.Assert;
import org.mockito.Mockito;

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
        Date mockedDate = Mockito.mock(Date.class);
        Mockito.when(mockedDate.asString()).thenReturn("2020-10-01");

        TrainingRecord rec = new TrainingRecord();
        rec.setDate(mockedDate);
        rec.addEntry("Squat");

        List<ExerciseEntry> entries = rec.listEntries();
        String exercise = entries.get(0).getExercise();
        String date = entries.get(0).getDate();

        Assert.assertEquals(1, entries.size());
        Assert.assertEquals("Squat", exercise);
        Assert.assertEquals("2020-10-01", date);
    }

    @Test
    public void testMultipleEntriesAreReturnedChronologically() {
        String longAgo = "1900-31-05";
        String recently = "2020-10-01";
        String inbetween = "1950-15-12";
        List<String> dates = Arrays.asList(recently, longAgo, inbetween);

        TrainingRecord rec = new TrainingRecord();
        for (String date : dates) {
            Date mockdate = Mockito.mock(Date.class);
            Mockito.when(mockdate.asString()).thenReturn(date);
            rec.setDate(mockdate);
            rec.addEntry("Squat");
        }

        List<ExerciseEntry> entries = rec.listEntries();

        Assert.assertEquals(3, entries.size());
        Assert.assertEquals(longAgo, entries.get(0).getDate());
        Assert.assertEquals(inbetween, entries.get(1).getDate());
        Assert.assertEquals(recently, entries.get(2).getDate());
    }
}
