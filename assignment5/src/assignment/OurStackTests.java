package assignment;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import assignment.*;
/*
 * I affirm that I have carried out the attached academic endeavors with full academic honesty.
 * @author Manav Bilakhia (MB)
 * @author Saeed AlSuwaidi
 * @author Jason D'Amico
 */
public class OurStackTests {

    LispToken plus = new LispToken('+');
    LispToken minus = new LispToken('-');
    LispToken mult = new LispToken('*');
    LispToken div = new LispToken('/');

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void addEntries() {
        StackInterface<String> testStack = new OurStack<>();

        for (int i = 0; i < 4; i++) {
            String newEntry = "entry " + i;
            testStack.push(newEntry);
            assertEquals(testStack.peek(), newEntry);
        }
	}

    @Test
	public void clearEntries() {
        StackInterface<String> testStack = new OurStack<>();

        for (int i = 0; i < 4; i++) {
            String newEntry = "entry " + i;
            testStack.push(newEntry);
        }

        testStack.clear();
        assertTrue(testStack.isEmpty());
	}

    @Test
	public void popEntries() {
        StackInterface<String> testStack = new OurStack<>();

        String[] entries = {"entry 1", "entry 2", "entry 3", "entry 4"};

        for (int i = 0; i < entries.length; i++) {
            String newEntry = entries[i];
            testStack.push(newEntry);
        }

        while(testStack.isEmpty()) {
            String popped = testStack.pop();

            boolean isInEntries = false;

            for (int i = 0; i < entries.length; i++) {
                isInEntries = isInEntries || entries[i].equals(popped);
            }

            assertTrue(isInEntries);
        }
	}
}
