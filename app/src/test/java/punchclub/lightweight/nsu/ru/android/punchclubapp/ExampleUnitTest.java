package punchclub.lightweight.nsu.ru.android.punchclubapp;

import org.junit.Test;
import punchclub.lightweight.nsu.ru.android.punchclubapp.model.Profile;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
    @Test
    public void addition_isCorrect() {
        assertEquals(4, 2 + 2);
    }

    @Test
    public void profileCreation_isCorrect(){
        Profile profile = new Profile("Goga", 25, "NSO", "m");
        assertEquals(25, profile.getAge());
        assertEquals("Goga", profile.getName());
        assertEquals("NSO", profile.getCity());
        assertEquals("m", profile.getSex());
    }
}