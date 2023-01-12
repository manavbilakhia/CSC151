/*
 * I affirm that I have carried out the attached academic endeavors with full academic honesty.
 * Manav Bilakhia (MB)
 */
package assignment;
import java.util.Arrays;
import java.util.StringJoiner;
/**
 * A class that implements a bag of objects by using an array. The bag is never
 * full.
 *
 * @author Frank M. Carrano, Timothy M. Henry
 * @version 5.0
 */
public final class ResizableArrayBag<T> implements BagInterface<T> {
    private T[] bag; // Cannot be final due to doubling
    private int numberOfEntries;
    private boolean integrityOK = false;
    private static final int DEFAULT_CAPACITY = 25; // Initial capacity of bag
    private static final int MAX_CAPACITY = 10000;
    /* Constructors */
    /** Constructor: No parameter. Creates an empty bag whose initial capacity is 25. */
    public ResizableArrayBag()
    {
        this(DEFAULT_CAPACITY);
    }
    /**
     * Constructor: int parameter. Creates an empty bag having a given initial capacity.
     *
     * @param initialCapacity The integer capacity desired.
     */
    public ResizableArrayBag(int initialCapacity)
    {
        checkCapacity(initialCapacity);
        T[] tempBag = (T[])new Object[initialCapacity]; // Unchecked cast
        bag = tempBag;
        numberOfEntries = 0;
        integrityOK = true;
    }
    /**
     * Constructor with an array parameter. Creates a bag containing given entries.
     *
     * @param contents An array of objects.
     */
    public ResizableArrayBag(T[] contents) {
        checkCapacity(contents.length);
        bag = Arrays.copyOf(contents, contents.length);
        numberOfEntries = contents.length;
        integrityOK = true;
    } // end constructor
    /**
     * Adds a new entry to this bag.
     *
     * @param newEntry The object to be added as a new entry.
     * @return True.
     */
    public boolean add(T newEntry) {
        checkintegrity();
        if (isArrayFull())
        {
            doubleCapacity();
        } // end if
        bag[numberOfEntries] = newEntry;
        numberOfEntries++;
        return true;
    } // end add
    /**
     * Retrieves all entries that are in this bag.
     *
     * @return A newly allocated array of all the entries in this bag.
     */
    public T[] toArray() {
        checkintegrity();
        T[] result = (T[])new Object[numberOfEntries];
        for (int i = 0; i < numberOfEntries; i++)
        {
            result[i] = bag[i];
        }
        return result;
    } // end toArray
    /**
     * Sees whether this bag is empty.
     *
     * @return True if this bag is empty, or false if not.
     */
    public boolean isEmpty() {
        if (numberOfEntries==0)
            return true;
        return false;
    } // end isEmpty
    /**
     * Gets the current number of entries in this bag.
     *
     * @return The integer number of entries currently in this bag.
     */
    public int getCurrentSize() {
        return numberOfEntries;
    } // end getCurrentSize
    /**
     * Counts the number of times a given entry appears in this bag.
     *
     * @param anEntry The entry to be counted.
     * @return The number of times anEntry appears in this ba.
     */
    public int getFrequencyOf(T anEntry) {
        checkintegrity();
        int count = 0;
        for (int i = 0; i < numberOfEntries; i++)
        {
            if (anEntry.equals(bag[i]))
            {
                count++;
            }
        }
        return count;
    } // end getFrequencyOf
    /**
     * Tests whether this bag contains a given entry.
     *
     * @param anEntry The entry to locate.
     * @return True if this bag contains anEntry, or false otherwise.
     */
    public boolean contains(T anEntry) {
        checkintegrity();
        return getIndexOf(anEntry) >= 0;
    }  // end contains
    /** Removes all entries from this bag. */
    public void clear()
    {
        while (!isEmpty())
            remove();
    } // end clear
    /**
     * Removes one unspecified entry from this bag, if possible.
     *
     * @return Either the removed entry, if the removal was successful, or null.
     */
    public T remove() {
        checkintegrity();
        T toReturn = removeEntry(numberOfEntries - 1);
        return toReturn;
    } // end remove
    /**
     * Removes one occurrence of a given entry from this bag.
     *
     * @param anEntry The entry to be removed.
     * @return True if the removal was successful, or false if not.
     */
    public boolean remove(T anEntry) {
        checkintegrity();
        int index = getIndexOf(anEntry);
        T toReturn = removeEntry(index);
        return anEntry.equals(toReturn);
    } // end remove
    // Locates a given entry within the array bag.
    // Returns the index of the entry, if located,
    // or -1 otherwise.
    // Precondition: checkintegrity has been called.
    private int getIndexOf(T anEntry) {
        for (int i = 0; i < numberOfEntries; i++)
        {
            if (anEntry.equals(bag[i]))
                return i;
        }
        return -1;
    } // end getIndexOf
    // Removes and returns the entry at a given index within the array.
    // If no such entry exists, returns null.
    // Precondition: 0 <= givenIndex < numberOfEntries.
    // Precondition: checkintegrity has been called.
    private T removeEntry(int givenIndex) 	{
        T toReturn = null;
        if (!isEmpty() && (givenIndex >= 0))
        {
            toReturn = bag[givenIndex];
            int last = numberOfEntries - 1;
            bag[givenIndex] = bag[last];
            bag[last] = null;
            numberOfEntries--;
        } // end if
        return toReturn;
    } // end removeEntry
    // Returns true if the array bag is full, or false if not.
    private boolean isArrayFull() 	{
        if (numberOfEntries >= bag.length)
            return true;
        else
            return false;
    } // end isArrayFull
    // Doubles the size of the array bag.
    // Precondition: checkInitialization has been called.
    private void doubleCapacity() {
        int newLength = 2 * bag.length;
        checkCapacity(newLength);
        bag = Arrays.copyOf(bag, newLength);
    } // end doubleCapacity
    // Throws an exception if the client requests a capacity that is too large.
    private void checkCapacity(int capacity) {
        if (capacity > MAX_CAPACITY)
            throw new IllegalStateException("The capacity of the created bag exceeds allowed maximum capacity");
    } // end checkCapacity
    // Throws an exception if receiving object is not initialized.
    private void checkintegrity() {
        if (!integrityOK)
            throw new SecurityException ("The object of ArrayBag is not initialized");
    } // end checkintegrity
    /**
     * toString joins the bag’s elements with a comma
     * and space then encloses in []
     */
    @Override
    public String toString() {
        StringJoiner joiner = new StringJoiner(", ", "[", "]");
        for (int index = 0; index < numberOfEntries; index++)
            joiner.add(bag[index].toString());
        return joiner.toString();
    }

    public static void main(String[] args) {
        ResizableArrayBag r1 = new ResizableArrayBag();
        System.out.println(r1.isEmpty());
        r1.add("A");
        r1.add("D");
        r1.add("B");
        r1.add("A");
        r1.add("C");
        r1.add("A");
        r1.add("D");
        System.out.println(r1);
        System.out.println(r1.isEmpty());
        System.out.println(r1.getFrequencyOf("A"));
        System.out.println(r1.getFrequencyOf("B"));
        System.out.println(r1.getFrequencyOf("C"));
        System.out.println(r1.getFrequencyOf("D"));
        System.out.println(r1.getFrequencyOf("Z"));
        System.out.println(r1.contains("A"));
        System.out.println(r1.contains("D"));
        System.out.println(r1.contains("Z"));
        System.out.println(r1.remove());
        System.out.println(r1.remove("B"));
        System.out.println(r1.remove("A"));
        System.out.println(r1.remove("C"));
        System.out.println(r1.remove("Z"));
        System.out.println(r1);
        r1.clear();
        System.out.println(r1.isEmpty());
    }
} // end ResizableArrayBag
/*
 * Write the following test in this class or in another driver class
 * Testing isEmpty with an empty bag: isEmpty finds the bag empty: OK.
 *
 * Adding to the bag more strings than its initial capacity. Adding to the bag:
 * A D B A C A D The bag contains 7 string(s), as follows: A D B A C A D Testing
 * isEmpty with a bag that is not empty: isEmpty finds the bag not empty: OK.
 *
 *
 * Testing the method getFrequencyOf: In this bag, the count of A is 3 In this
 * bag, the count of B is 1 In this bag, the count of C is 1 In this bag, the
 * count of D is 2 In this bag, the count of Z is 0
 *
 * Testing the method contains: Does this bag contain A? true Does this bag
 * contain B? true Does this bag contain C? true Does this bag contain D? true
 * Does this bag contain Z? false
 *
 * Removing a string from the bag: remove() returns D The bag contains 6
 * string(s), as follows: A D B A C A
 *
 * Removing "B" from the bag: remove("B") returns true The bag contains 5
 * string(s), as follows: A D A A C
 *
 * Removing "A" from the bag: remove("A") returns true The bag contains 4
 * string(s), as follows: C D A A
 *
 * Removing "C" from the bag: remove("C") returns true The bag contains 3
 * string(s), as follows: A D A
 *
 * Removing "Z" from the bag: remove("Z") returns false The bag contains 3
 * string(s), as follows: A D A
 *
 * Clearing the bag: Testing isEmpty with an empty bag: isEmpty finds the bag
 * empty: OK.
 *
 * The bag contains 0 string(s), as follows:
 */