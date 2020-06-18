package no.trainrec.core;

import org.junit.Test;
import org.junit.Assert;
import org.mockito.Mockito;
import org.mockito.ArgumentCaptor;

import java.time.format.DateTimeFormatter;
import java.time.LocalDate;


public class EntryAdderTest {
    @Test
    public void testAddEntry() {
        // Mock TrainingRecord (repo) with captor for checking
        // that passed entry is as expected
        TrainingRecord mockedRec = Mockito.mock(TrainingRecord.class);
        ArgumentCaptor<ExerciseEntry> argument = 
            ArgumentCaptor.forClass(ExerciseEntry.class);
        EntryAdder adder = new EntryAdder(mockedRec);
        String inputName = "Squat";

        adder.addEntry(inputName);
        Mockito.verify(mockedRec).addEntry(argument.capture());
        ExerciseEntry passedEntry = argument.getValue();

        String today = LocalDate.now().format(DateTimeFormatter.ISO_LOCAL_DATE);
        Assert.assertEquals(today, passedEntry.getDate());
        Assert.assertEquals(inputName, passedEntry.getExercise());
    }
}
