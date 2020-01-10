package LocalDateTest;

import org.junit.Test;
import org.junit.Assert;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class LocalDateTest {
    @Test
    public void testParseDate() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy.MM.dd");
        LocalDate parsed = LocalDate.parse("2020.01.10", formatter);
        Assert.assertEquals(LocalDate.of(2020, 1, 10), parsed);
   }
}
