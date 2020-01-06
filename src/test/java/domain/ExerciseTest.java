package domain;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

import java.util.Date;

public class ExerciseTest {

    @Test
    public void testExerciseConstructor() {
        Date today = new Date();
        Exercise ex = new Exercise("Squat", today);
    }

    @Test
    public void testGetName() {
        Date today = new Date();
        Exercise ex = new Exercise("Squat", today);
        assertEquals(ex.getName(), "Squat");
    }
}
