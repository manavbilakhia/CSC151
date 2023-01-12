package assignment;
/**
 * This class to demonstrate the class Huge.
 *
 * @author Charles Hoot
 * @author Frank M. Carrano
 * @author Zeynep Orhan modified
 * @version 5.0
 */
public class Driver {
    public static void main(String[] args) {
        Integer h1[] = { 0, 0, 0, 0, 0, 0, 0, 0, 0 };
        Integer h2[] = { 0, 0, 0, 0, 0, 0, 0, 0, 1 };
        Integer h3[] = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 1, 2, 3, 4, 5, 6, 7, 8, 9 };
        Integer h4[] = { 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2 };
        Huge huge1 = new Huge(h1);
        Huge huge2 = new Huge(h2);
        Huge huge3 = new Huge(h3);
        Huge huge4 = new Huge(h4);
        Huge addHuge, multHuge, rHuge;
        if (huge1.isZero()) System.out.println(huge1 + " is zero.");
        else System.out.println(huge1 + " is not zero.");
        if (huge2.isZero()) System.out.println(huge2 + " is zero.");
        else System.out.println(huge2 + " is not zero.");
        if (huge3.isZero()) System.out.println(huge3 + " is zero.");
        else System.out.println(huge3 + " is not zero.");
        if (huge4.isZero()) System.out.println(huge4 + " is zero.");
        else System.out.println(huge4 + " is not zero.");
        rHuge = new Huge();
        addHuge = huge3.addHuge(huge4);
        multHuge = huge3.multiplyHuge(huge4);
        System.out.println(huge3 + " + " + huge4 + " = " + addHuge);
        System.out.println(huge3 + " * " + huge4 + " = " + multHuge);
        System.out.println("huge1 is " + huge1);
        System.out.println("huge2 is " + huge2);
        System.out.println("huge3 is " + huge3);
        System.out.println("huge4 is " + huge4);
        String goodString = "1234567890123456789012345678901234567890";
        String badString = "12345678901234567890x12345678901234567890";
        try {
            System.out.println("Converting a string to a huge integer:");
            rHuge = Huge.getHuge(goodString);
            System.out.println(rHuge.toString());
            System.out.println("Converting a string to a huge integer that is too large:");
            rHuge = Huge.getHuge(badString);
            System.out.println(rHuge.toString());
        } // end try
        catch (NumberFormatException e) {
            System.out.println("Error converting a string to a huge integer.");
        } // end catch
        System.out.println("Zeros at the beginning should be removed");
        Integer h7[] = { 0, 0, 2, 2, 2 };
        Huge huge7 = new Huge(h7);
        System.out.println(huge7);
        System.out.println("Set to zero");
        huge7.setHuge("0");
        System.out.println(huge7);
        System.out.println("Trying a multiplication that will result in overflow.");
        Huge huge5 = Huge.getHuge(goodString);
        Huge huge6 = huge5.multiplyHuge(huge5);
    } // end main
} // end Driver