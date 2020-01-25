package no.trainrec.core;

import org.junit.Before;
import org.junit.Test;
import org.junit.Assert;
import org.mockito.Mockito;

import java.util.List;
import java.util.Arrays;

public class TrainingRecordTest {
    private TrainingRecord beforeRecord;
    private StorageInterface db;
    private String longAgo = "1900-05-31";
    private String recently = "2020-10-01";
    private String inbetween = "1950-12-15";

    @Before
    public void setUp() {
        beforeRecord = new TrainingRecord();

        db = Mockito.mock(StorageInterface.class);
        beforeRecord.setStorage(db);

        List<String> dates = Arrays.asList(recently, longAgo, inbetween);
        for (String date : dates) {
            EntryDate inputDate = EntryDate.fromString(date);
            beforeRecord.setActiveDate(inputDate);
            beforeRecord.addEntry("Squat");
        }
    }

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
        
        List<ExerciseEntry> entries = beforeRecord.listEntries();

        Assert.assertEquals(3, entries.size());
        Assert.assertEquals(longAgo, entries.get(0).getDate());
        Assert.assertEquals(inbetween, entries.get(1).getDate());
        Assert.assertEquals(recently, entries.get(2).getDate());
    }

    @Test
    public void testSaveCallsStorageImplementation() {
        beforeRecord.save();

        Mockito.verify(db).save(beforeRecord);
    }

    @Test
    public void testLoad() {
        Mockito.when(db.load()).thenReturn(beforeRecord);
        TrainingRecord rec = TrainingRecord.load(db);

        Assert.assertEquals(beforeRecord, rec);
    }
}
