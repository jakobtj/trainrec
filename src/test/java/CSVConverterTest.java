package trainrec;

import org.junit.Test;
import org.junit.Assert;

import java.time.LocalDate;

public class CSVConverterTest {
    @Test
    public void testCSVConverterFromString() {
        String inString = "2020.01.10;Squat";
        ExerciseEntry converted = CSVConverter.fromString(inString);
        ExerciseEntry comparison = new ExerciseEntry(
                LocalDate.of(2020, 1, 10), new Exercise("Squat")
                );
        Assert.assertEquals(comparison, converted);
    }
}
