package assignment;

/*
 * Honor code
 * James Heffernan, Manav Bilakhia, Saeed AlSuwaidi, Eric Zhao
 */

import static org.junit.jupiter.api.Assertions.*;

class DoublyLinkedBagTest {

    // Test the add method
    @org.junit.jupiter.api.Test
    void add() {
        DoublyLinkedBag<String> bag = new DoublyLinkedBag<>();
        bag.add("a");
        bag.add("b");
        bag.add("c");

        assertEquals(3, bag.getCurrentSize());
    }

    // Test the toArray method
    @org.junit.jupiter.api.Test
    void testToArray() {
        DoublyLinkedBag<String> bag = new DoublyLinkedBag<>();
        bag.add("a");
        bag.add("b");
        bag.add("c");

        Object[] bagArray = bag.toArray();
        assertEquals(3, bagArray.length);
    }

    // Test the isEmpty method
    @org.junit.jupiter.api.Test
    void isEmpty() {
        DoublyLinkedBag<String> bag = new DoublyLinkedBag<>();
        assertTrue(bag.isEmpty());
    }

    // Test the getCurrentSize method
    @org.junit.jupiter.api.Test
    void getCurrentSize() {
        DoublyLinkedBag<String> bag = new DoublyLinkedBag<>();
        bag.add("a");
        bag.add("b");
        bag.add("c");

        assertEquals(3, bag.getCurrentSize());
    }

    // Test the getFrequencyOf method
    @org.junit.jupiter.api.Test
    void getFrequencyOf() {
        DoublyLinkedBag<String> bag = new DoublyLinkedBag<>();
        bag.add("a");
        bag.add("b");
        bag.add("c");

        assertEquals(1, bag.getFrequencyOf("a"));
        assertEquals(1, bag.getFrequencyOf("b"));
        assertEquals(1, bag.getFrequencyOf("c"));
    }

    // Test the contains method
    @org.junit.jupiter.api.Test
    void contains() {
        DoublyLinkedBag<String> bag = new DoublyLinkedBag<>();
        bag.add("a");
        bag.add("b");
        bag.add("c");

        assertTrue(bag.contains("a"));
        assertTrue(bag.contains("b"));
        assertTrue(bag.contains("c"));
    }

    // Test the clear method
    @org.junit.jupiter.api.Test
    void clear() {
        DoublyLinkedBag<String> bag = new DoublyLinkedBag<>();
        bag.add("a");
        bag.add("b");
        bag.add("c");

        bag.clear();
        assertEquals(0, bag.getCurrentSize());
    }

    @org.junit.jupiter.api.Test
    void remove() {
        DoublyLinkedBag<String> bag = new DoublyLinkedBag<>();
        bag.add("a");
        bag.add("b");
        bag.add("c");

        bag.remove("a");
        assertEquals(2, bag.getCurrentSize());
    }


    @org.junit.jupiter.api.Test
    void testRemove() {
        DoublyLinkedBag<String> bag = new DoublyLinkedBag<>();
        bag.add("a");

        bag.remove();
        assertTrue(bag.isEmpty());
    }

    @org.junit.jupiter.api.Test
    void union() {
        DoublyLinkedBag<String> bag = new DoublyLinkedBag<>();
        bag.add("a");
        bag.add("b");
        bag.add("c");

        DoublyLinkedBag<String> bag2 = new DoublyLinkedBag<>();
        bag2.add("a");
        bag2.add("b");
        bag2.add("d");

        DoublyLinkedBag<String> union = bag.union(bag2);
        assertEquals(2, union.getFrequencyOf("a"));
        assertEquals(2, union.getFrequencyOf("b"));
        assertEquals(1, union.getFrequencyOf("c"));
        assertEquals(1, union.getFrequencyOf("d"));
    }

    @org.junit.jupiter.api.Test
    void intersection() {
        DoublyLinkedBag<String> bag = new DoublyLinkedBag<>();
        bag.add("a");
        bag.add("b");
        bag.add("c");

        DoublyLinkedBag<String> bag2 = new DoublyLinkedBag<>();
        bag2.add("a");
        bag2.add("b");
        bag2.add("d");

        DoublyLinkedBag<String> intersection = bag.intersection(bag2);
        assertEquals(1, intersection.getFrequencyOf("a"));
        assertEquals(1, intersection.getFrequencyOf("b"));
        assertEquals(2, intersection.getCurrentSize());
    }

    @org.junit.jupiter.api.Test
    void difference() {
        DoublyLinkedBag<String> bag = new DoublyLinkedBag<>();
        bag.add("a");
        bag.add("b");
        bag.add("c");

        DoublyLinkedBag<String> bag2 = new DoublyLinkedBag<>();
        bag2.add("a");
        bag2.add("b");
        bag2.add("d");


        DoublyLinkedBag<String> difference = bag.difference(bag2);
        assertEquals(1, difference.getFrequencyOf("c"));
        assertEquals(1, difference.getFrequencyOf("d"));
        assertEquals(2, difference.getCurrentSize());
    }
}