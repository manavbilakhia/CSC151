/*
 * I affirm that I have carried out the attached academic endeavors with full academic honesty.
 * Manav Bilakhia (MB)
 */
package assignment;

/**
 * A class of that tests singly linked lists that have String as the data.
 *
 * @author Zeynep Orhan
 */
public class LinkedBagDriver {
    /**
     * palindrome: Tests whether a string is
     *
     * @param w a String
     * @return True if the w is a palindrome, or false otherwise.
     */
    public static boolean palindrome(String w)
    {
        StringBuilder s = new StringBuilder();
        s.append(w);
        s.reverse();

        return w.equals(s.toString());
    }
    /**
     * addAll: adds all the strings in a given String array to this bag.
     *
     * @param w a String array
     * @return a BagInterface<String> which is a LinkedBag by adding all Strings in w
     */
    public static BagInterface<String> addAll(String [] w)
    {
        BagInterface<String> bag = new LinkedBag();
        for (int i = 0; i<w.length; i++)
        {
            bag.add(w[i]);
        }

        return bag;
    }
    /**
     * allPalindrome: adds all the strings in a given String array to a LinkedBag
     * and tests if they are all palindrome
     *
     * @param w a String array
     * @return True if all strings are palindromes, or false otherwise.
     */
    public static boolean allPalindrome(String [] w)
    {
        addAll(w);
        for (int i = 0; i<w.length; i++)
        {
            if(!palindrome(w[i]))
                return false;
        }
        return true;
    }
    /**
     * allPalindromes: adds all the strings in a given String array to a LinkedBag
     * and returns a string of the palindromes
     *
     * @param w a String array
     * @return a string that has all the palindrome strings in the bag separated by space,
     * most recent one should be at the beginning
     */
    public static String allPalindromes(String [] w)
    {
        BagInterface<String> bag = new LinkedBag();
        for (int i = 0; i<w.length;i++)
        {
            bag.add(w[i]);
        }
        Object[] arr = bag.toArray();
        String s = "";
        for (int i = 0; i<arr.length; i++)
        {
            if(palindrome((String)arr[i]))
                s = s + " " + arr[i];
        }
        return s;

    }
    public static void main(String[] args) {
// TODO Auto-generated method stub
        BagInterface<String> words = new LinkedBag<>();
        String w[] = { "a", "ab", "aba", "abba", "abcba", "abb" };
        for (String word : w)
            words.add(word);
        System.out.println("Add all words");
        System.out.println(words);
        Object wordArray[] = words.toArray();
        for (Object word : wordArray)
            if (palindrome((String) word))
                System.out.println(word + " is a palindrome");
            else
                System.out.println(word + " is not a palindrome");
        System.out.println("Is the list empty? " + words.isEmpty());
        System.out.println("Number of aa in the list " + words.getFrequencyOf("aa"));
        System.out.println("Number of abb in the list " + words.getFrequencyOf("abb"));
        System.out.println("Add abb " + words.add("abb"));
        System.out.println("Number of abb in the list after adding one more " + words.getFrequencyOf("abb"));
        System.out.println("Number of words in the list " + words.getCurrentSize());
        words.clear();
        System.out.println("Number of words in the list after clear " + words.getCurrentSize());
        LinkedBag<String> words2 = (LinkedBag<String>) addAll(w);
        System.out.println("Is the list empty? " + words2.isEmpty());
        System.out.println("Number of aa in the list " + words2.getFrequencyOf("aa"));
        System.out.println("Number of abb in the list " + words2.getFrequencyOf("abb"));
        System.out.println("Add abb " + words2.add("abb"));
        System.out.println("Number of abb in the list after adding one more " + words2.getFrequencyOf("abb"));
        System.out.println("Number of words in the list " + words2.getCurrentSize());
        words2.clear();
        System.out.println("Number of words in the list after clear " + words2.getCurrentSize());
        System.out.println("Are all palindromes? " + allPalindrome(w));
        System.out.println("Show all palindromes " + allPalindromes(w));
    }
}