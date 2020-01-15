package trainrec;

import org.junit.Test;
import org.junit.Assert;

public class DateTest{
    @Test
    public void testCreateDateFromString() {
        String isoformatted = "2010-10-15";
        Date date = Date.fromString(isoformatted);
        Assert.assertEquals(isoformatted, date.toString());
    }
}
