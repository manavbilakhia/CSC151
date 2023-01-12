package assignment;
/*
 * I affirm that I have carried out the attached academic endeavors with full academic honesty.
 * Manav Bilakhia (MB)
 */

import java.util.StringJoiner;

/**
 * A class of bags whose entries are stored in a chain of linked nodes. The bag
 * is never full.
 *
 * @author Frank M. Carrano
 * @author Timothy M. Henry
 * @version 5.0
 */
public final class LinkedBag<T>  implements BagInterface<T> {
    private Node firstNode; // Reference to first node
    private int numberOfEntries;

    /**
     * add: Adds a new entry to this bag.
     *
     * @param newEntry The object to be added as a new entry
     * @return True if the addition is successful, or false if not.
     */
    public boolean add(T newEntry)
    {
        Node newNode = new Node(newEntry);
        newNode.next = firstNode;
        firstNode = newNode;
        numberOfEntries++;
        return true;
    }

    /**
     * toArray: Retrieves all entries that are in this bag.
     *
     * @return A newly allocated array of all the entries in this bag.
     */
    public T[] toArray() {
        T[] result = (T[]) new Object[numberOfEntries];
        int index = 0;
        Node currentNode = firstNode;
        while ((index < numberOfEntries) && (currentNode != null)) {
            result[index] = currentNode.data;
            index++;
            currentNode = currentNode.next;
        }
        return result;
    }

    /**
     * isEmpty: Sees whether this bag is empty.
     *
     * @return True if this bag is empty, or false if not.
     */
    public boolean isEmpty() {
        return numberOfEntries == 0;
    }

    /**
     * getCurrentSize: Gets the number of entries currently in this bag.
     *
     * @return The integer number of entries currently in this bag.
     */
    public int getCurrentSize() {
        return numberOfEntries;
    }

    /**
     * remove: Removes one unspecified entry from this bag, if possible.
     *
     * @return Either the removed entry, if the removal was successful, or null.
     */
    public T remove() {
        T result = null;
        if (firstNode != null) {
            result = firstNode.data;
            firstNode = firstNode.next;
            numberOfEntries--;
        }
        return result;
    }

    /**
     * remove: Removes one occurrence of a given entry from this bag, if possible.
     *
     * @param anEntry The entry to be removed.
     * @return True if the removal was successful, or false otherwise.
     */
    public boolean remove(T anEntry) {
        boolean result = false;
        Node nodeN = getReferenceTo(anEntry);
        if (nodeN != null) {
            nodeN.data = firstNode.data;
            firstNode = firstNode.next;
            numberOfEntries--;
            result = true;
        }
        return result;
    }

    /**
     * clear: Removes all entries from this bag.
     */
    public void clear() {
        while (!isEmpty()) {
            remove();
        }
    }

    /**
     * getFrequencyOf: Counts the number of times a given entry appears in this bag.
     *
     * @param anEntry The entry to be counted.
     * @return The number of times anEntry appears in this bag.
     */
    public int getFrequencyOf(T anEntry) {
        int frequency = 0;
        int counter = 0;
        Node currentNode = firstNode;
        while ((counter < numberOfEntries) && (currentNode != null)) {
            if (anEntry.equals(currentNode.data)) {
                frequency++;
            }
            counter++;
            currentNode = currentNode.next;
        }
        return frequency;
    }

    /**
     * contains: Tests whether this bag contains a given entry.
     *
     * @param anEntry The entry to locate.
     * @return True if the bag contains anEntry, or false otherwise.
     */
    public boolean contains(T anEntry) {
        boolean found = false;
        Node currentNode = firstNode;
        while (!found && (currentNode != null)) {
            if (anEntry.equals(currentNode.data)) {
                found = true;
            } else {
                currentNode = currentNode.next;
            }
        }
        return found;
    }

    /**
     * toString: Convert this bag to a String for displaying.
     * each item will be comma separated and a space after comma enclosed in [ and ]
     * if we have a b c d in the bag a is the most recent one and will be converted as
     * [a, b, c, d]. StringJoiner is a good option to use.
     */
    @Override
    public String toString() {
        StringJoiner joiner = new StringJoiner(", ", "[", "]");
        Node currentNode = firstNode;
        for (int index = 0; index < numberOfEntries; index++)
            joiner.add(currentNode.data.toString());
            currentNode = currentNode.next;
        return joiner.toString();
    }
    // getReferenceTo: Should be private so not written in Javadoc format
    // parameter is an entry of type T
    // Locates a given entry within this bag.
    // Returns a reference to the node containing the entry, if located,
    // or null otherwise.
    private Node getReferenceTo(T anEntry) {
        boolean found = false;
        Node currentNode = firstNode;
        while (!found && (currentNode != null)) {
            if (anEntry.equals(currentNode.data)) {
                found = true;
            } else {
                currentNode = currentNode.next;
            }
        }
        return currentNode;
    }

    // Node class: Should be private so not written in Javadoc format
    // A class that represents a Node with a data of type generic and
    // a Node type next link
    private class Node {
        // Private instance variables
        // Entry in bag
        // Link to next node
        private T data;
        private Node next;
        // Constructors.
        // Constructor with a data of type T
        public Node(T dataPortion) {
            this(dataPortion, null);
        }
        // Constructor with a data of type T and a next of type Node
        public Node(T dataPortion, Node nextNode) {
            data = dataPortion;
            next = nextNode;
        }
        // get/set methods

        public T getData() {
            return data;
        }

        public void setData(T data) {
            this.data = data;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }
    } // end Node
} // end LinkedBag
