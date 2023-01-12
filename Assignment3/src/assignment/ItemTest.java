/*
 * I affirm that I have carried out the attached academic endeavors with full academic honesty.
 * Manav Bilakhia (MB)
 */
package assignment;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ItemTest {
    Item i2 = new Item("Shampoo", 2002);
    Item i3 = new Item("Shampoo", 2002);
    Item i4 = new Item("Conditioner", 1977);
    @Test
    void getDescription() {
        assertEquals("Conditioner",i4.getDescription());
    }

    @Test
    void getPrice() {
        assertEquals(1977,i4.getPrice());
    }

    @Test
    void testEquals() {
        assertEquals(false, i3.equals(i4));
        assertEquals(true, i3.equals(i2));
    }
}