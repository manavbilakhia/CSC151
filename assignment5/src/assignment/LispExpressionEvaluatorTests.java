package assignment;
/*
 * I affirm that I have carried out the attached academic endeavors with full academic honesty.
 * @author Manav Bilakhia (MB)
 * @author Saeed AlSuwaidi
 * @author Jason D'Amico
 */

import org.junit.*;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class LispExpressionEvaluatorTests {
    ArrayList<String> mes = new ArrayList<>();

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
	public void expression1() {
        Double result = LispExpressionEvaluator.evaluate("(+ 1 3)", mes);
        assertEquals(result, (Double) 4.0);
	}

    @Test
	public void expression2() {
        Double result = LispExpressionEvaluator.evaluate("(- 1)", mes);
        assertEquals(result, (Double) (-1.0));
	}


    @Test
	public void expression4() {
        Double result = LispExpressionEvaluator.evaluate("(+)", mes);
        assertEquals(result, (Double) 0.0);
	}

    @Test
	public void expression5() {
        Double result = LispExpressionEvaluator.evaluate("(*)", mes);
        assertEquals(result, (Double) 1.0);
	}


    @Test
	public void expression7() {
        Double result = LispExpressionEvaluator.evaluate("(- 1 2)", mes);
        assertEquals(result, (Double) (-1.0));
	}

    @Test
	public void expression8() {
        Double result = LispExpressionEvaluator.evaluate("(+ (- 1) (* 3 3 4) (/ 3 2 3) (* 4 4))", mes);
        assertEquals(result, (Double) (51.5));
	}


    @Test
	public void expression13() {
        Double result = LispExpressionEvaluator.evaluate("(* (*) (+ 1 7) (/ 5 4) (* 2 5))", mes);
        assertEquals(result, (Double) (100.0));
	}


    @Test
	public void expression15() {
        Double result = LispExpressionEvaluator.evaluate("(+ (*) (/ 2) (+))", mes);
        assertEquals(result, (Double) (1.5));
	}

    @Test
	public void expression16() {
        Double result = LispExpressionEvaluator.evaluate("(/ 2)", mes);
        assertEquals(result, (Double) (0.5));
	}

    @Test
	public void expression17() {
        Double result = LispExpressionEvaluator.evaluate("(*)", mes);
        assertEquals(result, (Double) (1.0));
	}

    @Test
	public void expression18() {
        Double result = LispExpressionEvaluator.evaluate("(+)", mes);
        assertEquals(result, (Double) (0.0));
	}
}
