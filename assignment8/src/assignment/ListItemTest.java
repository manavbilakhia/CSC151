package assignment;

import static org.junit.jupiter.api.Assertions.*;

class ListItemTest {

    @org.junit.jupiter.api.Test
    void getItem() {
        ListItem item = new ListItem(2,5);
        assertEquals(2,item.getItem());
    }

    @org.junit.jupiter.api.Test
    void getFreq() {
        ListItem item = new ListItem(2,5);
        assertEquals(5,item.getFreq());
    }

    @org.junit.jupiter.api.Test
    void testEquals() {
        ListItem item1 = new ListItem(2,5);
        ListItem item2 = new ListItem(3,4);
        ListItem item3 = new ListItem(2,5);
        assertTrue(item3.equals(item1));
        assertFalse(item1.equals(item2));
    }
}