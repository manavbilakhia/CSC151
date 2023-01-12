/*
 * I affirm that I have carried out the attached academic endeavors with full academic honesty.
 * Manav Bilakhia (MB)
 */
package assignment;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ResizableArrayBagTest {
    ResizableArrayBag r1 = new ResizableArrayBag();
    @Test
    void add() {
        r1.add("A");
        r1.add("D");
        r1.add("B");
        r1.add("A");
        r1.add("C");
        r1.add("A");
        r1.add("D");
        String [] expectedArr = {"A","D","B","A","C","A","D"};
        assertArrayEquals(expectedArr, r1.toArray());

    }

    @Test
    void isEmpty()
    {   assertEquals(true, r1.isEmpty());
        r1.add("A");
        r1.add("D");
        assertEquals(false, r1.isEmpty());
    }

    @Test
    void getCurrentSize() {
        assertEquals(0,r1.getCurrentSize());
        r1.add("A");
        r1.add("D");
        assertEquals(2,r1.getCurrentSize());
    }

    @Test
    void getFrequencyOf() {
        r1.add("A");
        r1.add("D");
        r1.add("A");
        assertEquals(2,r1.getFrequencyOf("A"));
        assertEquals(0,r1.getFrequencyOf("Z"));
    }

    @Test
    void contains() {
        r1.add("A");
        r1.add("D");
        r1.add("A");
        assertEquals(true,r1.contains("A"));
        assertEquals(false,r1.contains("z"));
    }

    @Test
    void clear() {
        r1.add("A");
        r1.add("D");
        r1.add("A");
        r1.clear();
        assertEquals(0,r1.getCurrentSize());
    }

    @Test
    void remove() {
        r1.add("A");
        r1.add("D");
        r1.add("A");
        String [] expectedArr1 = {"A","D"};
        r1.remove();
        assertArrayEquals(expectedArr1,r1.toArray());
        r1.remove("A");
        String [] expectedArr2 = {"D"};
        assertArrayEquals(expectedArr2,r1.toArray());
    }
}