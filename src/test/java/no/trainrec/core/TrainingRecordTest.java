package no.trainrec.core;

import org.junit.Before;
import org.junit.Test;
import org.junit.Assert;
import org.mockito.Mockito;

import java.util.List;

public class TrainingRecordTest {
    private TrainingRecord beforeRecord;
    private StorageInterface db;

    @Before
    public void setUp() {
        beforeRecord = new TrainingRecord();

        db = Mockito.mock(StorageInterface.class);
        beforeRecord.setStorage(db);
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
