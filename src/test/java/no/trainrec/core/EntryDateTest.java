package no.trainrec.core;

import org.junit.Test;
import org.junit.Assert;
import org.junit.function.ThrowingRunnable;

public class EntryDateTest{
    @Test
    public void testCreateDateFromString() {
        String isoformatted = "2010-10-15";
        EntryDate date = EntryDate.fromString(isoformatted);
        Assert.assertEquals(isoformatted, date.toString());
    }

    @Test
    public void testCreateDateWithWrongFormatRaisesException() {
        String notADate = "%%";
        Throwable exception = Assert.assertThrows(
                IllegalArgumentException.class,
                new ThrowingRunnable() {
                    @Override
                    public void run() throws Throwable {
                        EntryDate date = EntryDate.fromString(notADate);
                    }
                });
        Assert.assertEquals("Date string must have YYYY-MM-DD format",
            exception.getMessage()
            );
    }
}
