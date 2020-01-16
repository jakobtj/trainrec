package trainrec;

import org.junit.Test;
import org.junit.Assert;

public class EntryDateTest{
    @Test
    public void testCreateDateFromString() {
        String isoformatted = "2010-10-15";
        EntryDate date = EntryDate.fromString(isoformatted);
        Assert.assertEquals(isoformatted, date.toString());
    }
}
