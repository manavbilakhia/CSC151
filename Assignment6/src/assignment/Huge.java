/*
 * I affirm that I have carried out the attached academic endeavors with full academic honesty.
 * Manav Bilakhia (MB)
 */
package assignment;
import java.util.ArrayDeque;
import java.util.Deque;
/**
 * This class represents large nonnegative integers having up to 50 digits.
 *
 * @author Jesse Grabowski
 * @author Charles Hoot
 * @author Frank M. Carrano
 * @author Joseph Erickson
 * @author Zeynep Orhan modified
 * @version 5.0
 */
public class Huge {
    private Deque<Integer> hugeNumber;
    private final static int MAX_SIZE = 50;
    /**
     * Constructor: No parameters. Creates an ArrayDeque for hugeNumber and add 0
     */
    public Huge()
    {
        hugeNumber = new ArrayDeque<>();
        hugeNumber.add(0);
    }
    /**
     * Constructor with an Integer array parameter: Creates an ArrayDeque for
     * hugeNumber and sets the value of the Huge number based on a given array of
     * Integers
     *
     * @param digits Integer[] digits
     */
    public Huge(Integer digits[])
    {
        hugeNumber = new ArrayDeque<>();
        // calling sethuge so that zeros are checked and every element of the array is added
        setHuge(digits);
    }
    /**
     * Constructor with a String parameter: Creates an ArrayDeque for hugeNumber and
     * sets the value of the Huge number based on a given String
     *
     * @param hugeString a String of digits
     */
    public Huge(String hugeString)
    {
        hugeNumber = new ArrayDeque<>();
        // calling sethuge so that zeros are checked and every element of the string is added
        setHuge(hugeString);
    }
    /**
     * Constructor with another Huge number parameter: Creates an ArrayDeque for
     * hugeNumber and sets the value of the Huge number based on a given Huge number
     *
     * @param huge
     */
    public Huge(Huge huge)
    {
        hugeNumber = new ArrayDeque<>();
        // calling sethuge so that zeros are checked and every element of the huge is added
        setHuge(huge.toArray());
    }
    /**
     * setHuge: Sets the value of the Huge number based on a given array of Integers. May
     * throw an Error if the number is too large. throw new Error("Overflow") when
     * the number of digits is greater than the MAX_SIZE Ignore zeros at the
     * beginning and add the digits starting from the 0th index to the end of the
     * deque
     *
     * @param digits An array of Integers that represents the Huge's digits.
     *
     */
    public void setHuge(Integer digits []) {
        if (digits.length > MAX_SIZE) {
            throw new Error("Overflow");//error overflow
        }
        //clearing so that everytime setter is called, it has a different value
        hugeNumber.clear();
        boolean startWithZero = true;
        for (int index = 0; index < digits.length; index++) {
            if (!digits[index].equals(0) || !startWithZero) {
                hugeNumber.add(digits[index]);
                if (startWithZero)
                    startWithZero = true;
            }

        }
        if (hugeNumber.size() == 0) {
            hugeNumber.add(0);

        }
    }

    /**
     * setHuge: Sets the value of the Huge number based on a string of numbers. May throw an
     * Error if the number is too large, or a NumberFormatException if the string is
     * formatted incorrectly.
     *
     * throw new Error("Overflow") when the number of digits is greater than the
     * MAX_SIZE
     *
     * throw new NumberFormatException("Non-hugeNumber in huge int"); when a digit
     * is not a character in [0-9]
     *
     * Ignore zeros at the beginning and add the digits starting from the char at
     * 0th index to the end of the deque
     *
     * @param hugeString The string to convert into a Huge.
     * @throws NumberFormatException if the string is formatted incorrectly.
     */
    public void setHuge(String hugeString) throws NumberFormatException {
        if (hugeString.length() > MAX_SIZE) {
            throw new Error("Overflow");//error overflow
        }
        //clearing so that everytime setter is called, it has a different value
        hugeNumber.clear();
        boolean startingWithZero = true;
        for (int index = 0; index < hugeString.length(); index++) {
            Character character = hugeString.charAt(index);
            if (!Character.isDigit(character)) {
                throw new NumberFormatException("Bad Character");
            }

            Integer digit = Character.getNumericValue(character);
            if (digit != 0 || !startingWithZero) {
                hugeNumber.add(digit);
                if (startingWithZero) {
                    startingWithZero = false;
                }
            }
        }
        if (hugeNumber.size() == 0) {
            hugeNumber.add(0);
        }
    }
    /**
     * Override toString: Print the digits next to each other without a space
     */
    @Override
    public String toString() {
        String str = "";
        for (Object o : hugeNumber.toArray()) {
            Integer digit = (Integer) o;

            str += digit.toString();
        }

        return str;
    }
    /**
     * toArray: Converts the Huge into an array of Integers.
     *
     * @return An array representation of the Huge.
     */
    public Integer[] toArray() {
        Integer[] arr = new Integer[hugeNumber.size()];

        Object[] objectArr = hugeNumber.toArray();
        for (int i = 0; i < hugeNumber.size(); i++) {
            arr[i] = (Integer) objectArr[i];
        }

        return arr;
    }

    /**
     * addHuge: Adds another Huge to this Huge without changing either one.
     *
     * @param h The Huge to add to this Huge.
     * @return A Huge which is the sum of both Huges.
     */
    public Huge addHuge(Huge h)
    {
        String operand1 = this.toString();
        String operand2 = h.toString();
        if (operand1.length() > operand2.length()){
            String temp = operand1;
            operand1 = operand2;
            operand2 = temp;
        }
        String result = "";
        int length1 = operand1.length();
        int length2 = operand2.length();
        operand1=new StringBuilder(operand1).reverse().toString();
        operand2=new StringBuilder(operand2).reverse().toString();
        int carry = 0;
        for (int index = 0; index < length1; index++)
        {
            int sum = ((operand1.charAt(index) - '0') +
                    (operand2.charAt(index) - '0') + carry);
            result += (char)(sum % 10 + '0');
            carry = sum / 10;
        }
        for (int index = length1; index < length2; index++)
        {
            int sum = ((operand2.charAt(index) - '0') + carry);
            result += (char)(sum % 10 + '0');
            carry = sum / 10;
        }
        if (carry > 0)
            result += (char)(carry + '0');

        result = new StringBuilder(result).reverse().toString();
        Huge sum = new Huge(result);
        return sum;
    }
    /**
     * multiplyHuge: Multiplies another Huge to this Huge without changing either one.
     *
     * @param h The Huge to multiply to this Huge.
     * @return A Huge which is the product of both Huges.
     */
    public Huge multiplyHuge(Huge h)
    {
        String operand1 = this.toString();
        String operand2 = h.toString();
        int length1 = operand1.length();
        int length2 = operand2.length();
        if (length1 == 0 || length2 == 0) {
            Huge product = new Huge();
            return product;
        }

        // storing result in a vector
        // in reverse order
        int result[] = new int[length1 + length2];

        // Below two indexes are used to
        // find positions in result.
        int position1 = 0;
        int position2 = 0;

        // Go from right to left in num1
        for (int index1 = length1 - 1; index1 >= 0; index1--)
        {
            int carry = 0;
            int num1 = operand1.charAt(index1) - '0';

            // To shift position to left after every
            position2 = 0;

            // Go from right to left in num2
            for (int index2 = length2 - 1; index2 >= 0; index2--)
            {
                // Take current digit of second number
                int num2 = operand2.charAt(index2) - '0';

                // Multiply with current digit of first number
                // and add result to previously stored result
                // charAt current position.
                int sum = num1 * num2 + result[position1 + position2] + carry;

                // Carry for next itercharAtion
                carry = sum / 10;

                // Store result
                result[position1 + position2] = sum % 10;

                position2++;
            }

            // store carry in next cell
            if (carry > 0)
                result[position1 + position2] += carry;
            position1++;
        }

        // ignore '0's from the right
        int index = result.length - 1;
        while (index >= 0 && result[index] == 0)
            index--;
        if (index == -1)
        {
            Huge product = new Huge();
            return product;
        }

        // generate the result String
        String s = "";

        while (index >= 0)
            s =s+ (result[index--]);
        if (s.length()> MAX_SIZE)
            throw new Error("Overflow");
        Huge product = new Huge(s);

        return product;

    }
    /**
     * getHuge: Returns a duplicate of the given Huge representation of a String.
     *
     * @param s The String to convert into a Huge.
     * @return A duplicate of the Huge version of the String.
     */
    public static  Huge getHuge(String s)
    {
        Huge huge = new Huge(s);
        return huge;
    }
    /**
     * isZero: Determines if the Huge is = 0.
     *
     * @return true if the Huge is 0, otherwise false
     */
    public boolean isZero()
    {
        /*
        String str = this.toString();
        int n = str.length();
        for (int index = 1; index < n; index++)
            if (str.charAt(index) != '0')
                return false;
        return true;
         */
        if(hugeNumber.getFirst() == 0)
            if (hugeNumber.size() == 1)
                return true;
            else
                return false;
        else
            return false;
    }
} // end Huge