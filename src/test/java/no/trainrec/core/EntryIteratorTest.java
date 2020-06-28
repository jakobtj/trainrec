package no.trainrec.core;

import org.junit.Before;
import org.junit.Test;
import org.junit.Assert;
import org.mockito.Mockito;

import java.util.List;
import java.util.Arrays;
import java.util.Iterator;

public class EntryIteratorTest {
    private TrainingRecord beforeRecord;

    @Before
    public void setUp() {
        ExerciseEntry longAgo = new ExerciseEntry("1900-05-31", "Squat");
        ExerciseEntry recently = new ExerciseEntry("2020-10-01", "Deadlift");
        List<ExerciseEntry> entries = Arrays.asList(longAgo, recently);
        beforeRecord = Mockito.mock(TrainingRecord.class);
        Mockito.when(beforeRecord.listEntries()).thenReturn(entries);
    }

    @Test
    public void testIterateOverAllEntries() {
        EntryIterator it = new EntryIterator(beforeRecord);
        ExerciseEntry first = it.next();
        Assert.assertEquals("Squat", first.getExercise());
        Assert.assertEquals("1900-05-31", first.getDate());

        ExerciseEntry second = it.next();
        Assert.assertEquals("Deadlift", second.getExercise());
        Assert.assertEquals("2020-10-01", second.getDate());
    }
}
