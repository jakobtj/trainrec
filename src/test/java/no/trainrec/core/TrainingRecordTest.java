package no.trainrec.core;

import no.trainrec.core.data.TrainingRecord;
import no.trainrec.core.domain.ExerciseEntry;
import no.trainrec.core.data.StorageInterface;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import org.mockito.Mockito;
import org.mockito.ArgumentMatchers;

import java.util.List;

public class TrainingRecordTest {
    private StorageInterface db;

    @BeforeEach
    public void setUp() {
        db = Mockito.mock(StorageInterface.class);
    }

    @Test
    public void testSaveCallsStorageImplementation() {
        TrainingRecord rec = new TrainingRecord(db);
        rec.save();

        Mockito.verify(db).save(ArgumentMatchers.<ExerciseEntry>anyList());
    }

    @Test
    public void testLoad() {
        List listMock = Mockito.mock(List.class);
        Mockito.when(db.load()).thenReturn(listMock);

        TrainingRecord rec = new TrainingRecord(db);

        Assertions.assertEquals(listMock, rec.listEntries());
    }
}
