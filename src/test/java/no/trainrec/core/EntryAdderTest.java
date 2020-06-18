package no.trainrec.core;

import org.junit.Before;
import org.junit.Test;
import org.junit.Assert;
import org.mockito.Mockito;
import org.mockito.ArgumentCaptor;

import java.time.format.DateTimeFormatter;
import java.time.LocalDate;


public class EntryAdderTest {
    private TrainingRecord mockedRec;
    private ArgumentCaptor<ExerciseEntry> captor;
    private EntryAdder adder;

    @Before
    public void setUp() {
        // Mock TrainingRecord (repo) with captor for checking
        // that passed entry is as expected
        mockedRec = Mockito.mock(TrainingRecord.class);
        captor = ArgumentCaptor.forClass(ExerciseEntry.class);
        adder = new EntryAdder(mockedRec);
    }

    @Test
    public void testAddEntry() {
        String inputName = "Squat";
        adder.addEntry(inputName);
        Mockito.verify(mockedRec).addEntry(captor.capture());
        ExerciseEntry passedEntry = captor.getValue();

        String today = LocalDate.now().format(DateTimeFormatter.ISO_LOCAL_DATE);
        Assert.assertEquals(today, passedEntry.getDate());
        Assert.assertEquals(inputName, passedEntry.getExercise());
    }
}
