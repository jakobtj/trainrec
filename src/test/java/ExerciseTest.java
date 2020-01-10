package trainrec;

import org.junit.Test;
import org.junit.Assert;

public class ExerciseTest {
    @Test
    public void testCompareExercises() {
        Exercise first = new Exercise("Squat");
        Exercise second = new Exercise("Squat");
        Exercise third = new Exercise("Bench press");

        Assert.assertEquals(second, first);
        Assert.assertNotEquals(third, first);
    }
}
