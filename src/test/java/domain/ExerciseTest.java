package domain;

import org.junit.*;
import static org.junit.Assert.assertEquals;

import java.util.Date;

public class ExerciseTest {

    private Exercise ex;
    private Date today;
    private String name;

    @Before
    public void setUp() {
        today = new Date();
        name = "Squat";
        ex = new Exercise(name, today);
    }

    @Test
    public void testGetName() {
        assertEquals(ex.getName(), name);
    }

    @Test
    public void testGetDate() {
        assertEquals(ex.getDate(), today);
    }

}
