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
public class LispTokenTests {

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
	public void plusTests() {
        assertTrue(plus.isOperator());
        assertEquals(plus.getIdentity(), (Double) 0.0);
        assertTrue(plus.takesZeroOperands());
	}

	@Test
	public void minusTests() {
        assertTrue(minus.isOperator());
        assertEquals(minus.getIdentity(), (Double) 0.0);
        assertFalse(minus.takesZeroOperands());
	}

    @Test
	public void multTests() {
        assertTrue(mult.isOperator());
        assertEquals(mult.getIdentity(), (Double) 1.0);
        assertTrue(mult.takesZeroOperands());
	}

    @Test
	public void divTests() {
        assertTrue(div.isOperator());
        assertEquals(div.getIdentity(), (Double) 1.0);
        assertFalse(div.takesZeroOperands());
	}

    @Test
	public void plusOperations() {
        assertEquals(plus.applyOperator(1.0, 2.0), (Double) 3.0);
        assertEquals(plus.applyOperator(1.0, -13.0), (Double) (-12.0));
	}

    @Test
	public void minusOperations() {
        assertEquals(minus.applyOperator(1.0, 2.0), (Double) (-1.0));
        assertEquals(minus.applyOperator(1.0, -13.0), (Double) (14.0));
	}

    @Test
	public void multOperations() {
        assertEquals(mult.applyOperator(3.0, 2.0), (Double) (6.0));
        assertEquals(mult.applyOperator(-3.0, 2.0), (Double) (-6.0));
        assertEquals(mult.applyOperator(-3.0, -2.0), (Double) (6.0));
	}

    @Test
	public void divOperations() {
        assertEquals(div.applyOperator(3.0, 2.0), (Double) (1.5));
        assertEquals(div.applyOperator(12.0, 2.0), (Double) (6.0));
        assertEquals(div.applyOperator(13.0, -5.0), (Double) (-2.6));
	}
}
