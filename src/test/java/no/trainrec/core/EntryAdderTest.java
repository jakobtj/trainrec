package no.trainrec.core;

import no.trainrec.core.domain.ExerciseEntry;
import no.trainrec.core.data.TrainingRecord;
import no.trainrec.core.use_case.EntryAdder;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import org.mockito.Mockito;
import org.mockito.ArgumentCaptor;

import java.time.format.DateTimeFormatter;
import java.time.LocalDate;


public class EntryAdderTest {
    private TrainingRecord mockedRec;
    private ArgumentCaptor<ExerciseEntry> captor;
    private EntryAdder adder;

    @BeforeEach
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

        Assertions.assertEquals(today, passedEntry.getDate());
        Assertions.assertEquals(inputName, passedEntry.getExercise());
    }

    @Test
    public void testAddEntryAfterSetDate() {
        String inputDate = "1999-12-31";
        adder.setActiveDate(inputDate);

        String inputName = "Bench press";
        adder.addEntry(inputName);

        Mockito.verify(mockedRec).addEntry(captor.capture());
        ExerciseEntry passedEntry = captor.getValue();

        Assertions.assertEquals(inputDate, passedEntry.getDate());
        Assertions.assertEquals(inputName, passedEntry.getExercise());
    }

    @Test
    public void testSetErroneousDateThrowsException() {
        String notADate = "??";
        Throwable exception = Assertions.assertThrows(
            IllegalArgumentException.class,
            () -> {
                adder.setActiveDate(notADate);
        });
        String expectedMessage = "Date string must have YYYY-MM-DD format";
        String actualMessage = exception.getMessage();

        Assertions.assertTrue(actualMessage.contains(expectedMessage));
    }
}
