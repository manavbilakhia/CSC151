/*
 * I affirm that I have carried out the attached academic endeavors with full academic honesty.
 * Manav Bilakhia (MB)
 */
package assignment;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class CoinTest {
    Coin c1 = new Coin();
    Coin c2 = new Coin(1, 2002);
    Coin c5 = new Coin(25, 2001);
    Coin c6 = new Coin(25, 2001);

    @Test
    void getValue() {
        assertEquals(25,c5.getValue());
    }
    @Test
    void getYear() {
        assertEquals(2001,c5.getYear());
    }
    @Test
    void getName() {
        assertEquals("PENNY",c2.getName());
    }
    @Test
    void equals() {
        assertEquals(true,c5.equals(c6));
        assertEquals(false,c1.equals(c6));
    }
}