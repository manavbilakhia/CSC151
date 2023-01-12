package assignment;

/*
 * Honor code
 * James Heffernan, Manav Bilakhia, Saeed AlSuwaidi, Eric Zhao
 */

import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class SpellCheckerDoublyTest {

    @Test
    void checkSpelling() throws FileNotFoundException {
        SpellCheckerDoubly spellCheckerDoubly = new SpellCheckerDoubly();
        // Create list of words
        ArrayList<String> dictionary = new ArrayList<>();
        dictionary.add("hello");
        dictionary.add("world");

        spellCheckerDoubly.setDictionary(dictionary);

        assertTrue(spellCheckerDoubly.checkSpelling( "hello"));
        assertFalse(spellCheckerDoubly.checkSpelling( "word"));
    }

    @Test
    void checkSpellingBag() throws FileNotFoundException {
        SpellCheckerDoubly spellCheckerDoubly = new SpellCheckerDoubly();
        // Create list of words
        DoublyLinkedBag<String> words = new DoublyLinkedBag<>();
        words.add("hello");
        words.add("word");

        // Dictionary list
        ArrayList<String> dictionary = new ArrayList<>();
        dictionary.add("hello");
        dictionary.add("world");

        // Check spelling
        spellCheckerDoubly.setDictionary(dictionary);

        DoublyLinkedBag<String> correct = new DoublyLinkedBag<>();
        DoublyLinkedBag<String> incorrect = new DoublyLinkedBag<>();

        spellCheckerDoubly.checkSpellingBag(words, correct, incorrect);

        assertEquals(1, correct.getFrequencyOf("hello"));
        assertEquals(correct.getCurrentSize(), 1);

        assertEquals(1, incorrect.getFrequencyOf("word"));
        assertEquals(incorrect.getCurrentSize(), 1);


    }

    @Test
    void checkSpellingFromLists() {
        SpellCheckerDoubly spellCheckerDoubly = new SpellCheckerDoubly();
        // Create list of words
        ArrayList<String> words = new ArrayList<>();
        words.add("hello");
        words.add("word");

        // Dictionary list
        ArrayList<String> dictionary = new ArrayList<>();
        dictionary.add("hello");
        dictionary.add("world");

        // Check spelling
        spellCheckerDoubly.setDictionary(dictionary);

        DoublyLinkedBag<String> correct = new DoublyLinkedBag<>();
        DoublyLinkedBag<String> incorrect = new DoublyLinkedBag<>();

        spellCheckerDoubly.checkSpellingFromLists(dictionary, words, correct, incorrect);

        assertEquals(1, correct.getFrequencyOf("hello"));
        assertEquals(correct.getCurrentSize(), 1);

        assertEquals(1, incorrect.getFrequencyOf("word"));
        assertEquals(incorrect.getCurrentSize(), 1);
    }

    @Test
    void checkSpellingFromFile() {
        SpellCheckerDoubly spellCheckerDoubly = new SpellCheckerDoubly();

        DoublyLinkedBag<String> correct = new DoublyLinkedBag<>();
        DoublyLinkedBag<String> incorrect = new DoublyLinkedBag<>();

        spellCheckerDoubly.checkSpellingFromFile("src/assignment/dictionary.txt", "src/assignment/document.txt", correct, incorrect);

        assertEquals(1, correct.getFrequencyOf("hello"));
        assertEquals(correct.getCurrentSize(), 1);

        assertEquals(1, incorrect.getFrequencyOf("word"));
        assertEquals(incorrect.getCurrentSize(), 1);
    }
}