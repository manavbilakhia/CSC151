package assignment;

/*
 * Honor code
 * James Heffernan, Manav Bilakhia, Saeed AlSuwaidi, Eric Zhao
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

/**
 * SpellCheckerDoubly class: A spelling checker class.
 *
 * @author Frank M. Carrano
 * @author zorhan modified
 * @version 5.0
 */
public class SpellCheckerDoubly {
    BagInterface<String> correctWords; // Storage for the correct words

    /**
     * Parameterless constructor that initializes this Bag.
     * correctWords should be a new DoublyLinkedBag of String
     */
    public SpellCheckerDoubly() {
        this.correctWords = new DoublyLinkedBag();
    }

    /**
     * setDictionary: Initializes the dictionary of correctly spelled words from a file.
     *
     * @param fileName A File name as a String that represents a text file of correctly
     *                 spelled words, one per line.
     * @return True if the dictionary is initialized, if not returns false.
     */
    public boolean setDictionary(String fileName) {
        File file = new File(fileName);
        Scanner sc;
        try {
            sc = new Scanner(file);
        } catch (FileNotFoundException e) {
            return false;
        }

        while (sc.hasNextLine()) {
            correctWords.add(sc.nextLine());
        }
        return true;
    }

    /**
     * setDictionary: Initializes the dictionary of correctly spelled words from a list.
     *
     * @param correctWordsList An ArrayList list of String that contains correctly spelled words.
     */
    public void setDictionary(ArrayList<String> correctWordsList) {
        for (String correctWords : correctWordsList) {
            this.correctWords.add(correctWords);
        }
    }

    /**
     * setDocument: Initializes the document to be checked from a file.
     *
     * @param fileName A File name as a String that represents a text file of the document
     *                 whose words will be checked, one per line.
     * @return DoublyLinkedBag(BagInterface) of document's words.
     */
    public BagInterface<String> setDocument(String fileName) throws FileNotFoundException {
        File file = new File(fileName);
        Scanner sc = new Scanner(file);
        DoublyLinkedBag<String> bag = new DoublyLinkedBag();
        while (sc.hasNextLine()) {
            bag.add(sc.nextLine());
        }

        return bag;
    }

    /**
     * setDocument: Initialises the document to be checked from a list
     *
     * @param wordList An ArrayList of String that contains words to be checked.
     * @return DoublyLinkedBag(BagInterface) of document's words.
     */
    public BagInterface<String> setDocument(ArrayList<String> wordList) {
        DoublyLinkedBag<String> bag = new DoublyLinkedBag();
        for (String word : wordList) {
            bag.add(word);
        }

        return bag;
    }

    private boolean checkSpelling(Object[] dictList, String aWord) {
        for (Object correctWord : dictList) {
            if (aWord.equals(correctWord))
                return true;
        }
        return false;
    }

    /**
     * checkSpelling: Checks the spelling of a given single word as String.
     *
     * @param aWord A string whose spelling is to be checked.
     * @return True if the given word is spelled correctly, otherwise returns false.
     */
    public boolean checkSpelling(String aWord) {
        return checkSpelling(this.correctWords.toArray(), aWord);
    }

    private void checkSpellingBag(Object[] dictList, Object[] wordList, BagInterface<String> correct, BagInterface<String> incorrect) {
        for (Object o : wordList) {
            String word = (String) o;
            if (checkSpelling(dictList, word)) {
                correct.add(word);
            } else {
                incorrect.add(word);
            }
        }
    }

    /**
     * checkBagSpelling: Checks the spelling of a given bag of words
     *
     * @param wordBag   A bag of words whose spelling is to be checked.
     * @param correct   A bag of the words in wordBag whose spellings are correct
     * @param incorrect A bag of the words in wordBag whose spellings are incorrect
     */
    public void checkSpellingBag(BagInterface<String> wordBag, BagInterface<String> correct, BagInterface<String> incorrect) {
        checkSpellingBag(this.correctWords.toArray(), wordBag.toArray(), correct, incorrect);
    }

    /**
     * checkSpellingFromLists: Checks the spelling of a given bag of words
     * from the given list of words list and dictionary list.
     *
     * @param dictList  A list of dictionary words
     * @param wordList  A list of words to be checked
     * @param correct   A bag of the words in wordBag whose spellings are correct
     * @param incorrect A bag of the words in wordBag whose spellings are incorrect
     */
    public void checkSpellingFromLists(ArrayList<String> dictList, ArrayList<String> wordList, BagInterface<String> correct, BagInterface<String> incorrect) {
        Collections.reverse(dictList);
        Collections.reverse(wordList);
        checkSpellingBag(dictList.toArray(), wordList.toArray(), correct, incorrect);
    }

    /**
     * checkSpellingFromFile: Checks the spelling of a given bag of words by
     * creating the words list and dictionary from the files.
     *
     * @param dictFile  A file name of dictionary words
     * @param wordFile  A file name of words to be checked
     * @param correct   A bag of the words in wordBag whose spelling are correct
     * @param incorrect A bag of the words in wordBag whose spelling are incorrect
     */
    public void checkSpellingFromFile(String dictFile, String wordFile, BagInterface<String> correct, BagInterface<String> incorrect) {
        try {
            ArrayList<String> dictList = new ArrayList();
            File fileD = new File(dictFile);
            Scanner dsc = new Scanner(fileD);
            while (dsc.hasNextLine()) {
                dictList.add(dsc.nextLine());
            }

            ArrayList<String> wordList = new ArrayList();
            File fileW = new File(wordFile);
            Scanner wsc = new Scanner(fileW);
            while (wsc.hasNextLine()) {
                wordList.add(wsc.nextLine());
            }

            checkSpellingFromLists(dictList, wordList, correct, incorrect);
        } catch (FileNotFoundException e) {

        }
    }

    public static void main(String[] args) {
        ArrayList<String> wordList = new ArrayList<>();
        wordList.add("cow");
        wordList.add("dog");
        wordList.add("vcat");
        wordList.add("piga");
        wordList.add("elk");
        ;
        ArrayList<String> dict = new ArrayList<>();
        dict.add("cow");
        dict.add("dog");
        dict.add("cat");
        dict.add("pig");
        dict.add("elk");


        SpellCheckerDoubly spD = new SpellCheckerDoubly();
        spD.setDictionary(dict);
        System.out.println("Check spelling of misspelled word: " + spD.checkSpelling("emuashf"));
        System.out.println("Check spelling of correctly spelled word: " + spD.checkSpelling("cat"));

        System.out.println("----------------------------------------------------");

        BagInterface<String> correct = new DoublyLinkedBag<>();
        BagInterface<String> incorrect = new DoublyLinkedBag<>();
        spD.checkSpellingFromLists(dict, wordList, correct, incorrect);
        System.out.println("All words to be checked " + wordList);
        System.out.println("All dictionary words " + dict);
        System.out.println("Correctly spelled" + correct);
        System.out.println("Incorrectly spelled" + incorrect);

        System.out.println(" ----------------------------------------------------");

        SpellCheckerDoubly spD2 = new SpellCheckerDoubly();
        BagInterface<String> correct2 = new DoublyLinkedBag<>();
        BagInterface<String> incorrect2 = new DoublyLinkedBag<>();
        spD2.checkSpellingFromFile("src/assignment/dictionary.txt", "src/assignment/document.txt", correct2,
                incorrect2);
        System.out.println("Correctly spelled" + correct2);
        System.out.println("Incorrectly spelled" + incorrect2);
    }
}