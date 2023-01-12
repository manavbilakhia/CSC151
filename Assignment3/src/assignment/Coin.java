/*
 * I affirm that I have carried out the attached academic endeavors with full academic honesty.
 * Manav Bilakhia (MB)
 */
package assignment;

import java.util.Objects;

/**
 *
 * @author Manav Bilakhia
 *
 */
public class Coin {
    /*
     * Instance variables
     */
    private int value;
    private String name;
    private int year;

    /**
     * Default Constructor
     */
    public Coin() {
        int value = 0;
        String name = "";
        int year = 0000;
    }
    /**
     * Parameterized Constructor
     * @param value value of the coin
     * @param year year in which the coin was minted
     */
    public Coin(int value, int year) {
        this.setValue(value);
        this.setName();
        this.setYear(year);
    }
    /**
     * Getter method for value of the coin
     * @return integer value of the coin
     */
    public int getValue() {
        return value;
    }
    /**
     * getter method for coin year
     * @return integer value of coin year
     */
    public int getYear() {
        return year;
    }
    /**
     *getter method
     * @return returns the name of the coin
     */
    public String getName() {
        return name;
    }
    /**
     * setter method sets the name of a coin
     */
    public void setName() {
        String[] coinName = {"PENNY", "NICKEL", "DIME", "QUARTER", "NONAME"};
        if (this.getValue() == 1) {
            this.name = coinName[0];
        }
        else if (this.getValue() == 5) {
            this.name = coinName[1];
        }
        else if (this.getValue() == 10) {
            this.name = coinName[2];
        }
        else if (this.getValue() == 25) {
            this.name = coinName[3];
        }
        else {
            this.name = coinName[4];
        }
    }
    /**
     * setter method
     * @param value sets the value of the coin
     */
    public void setValue(int value) {
        this.value = value;
    }

    public void setYear(int year) {
        this.year = year;
    }
    /**
     * tostring method
     * @return the output in the given format
     */
    @Override
    public String toString() {
        return "[" + this.getValue() + ", " + this.getName() + ", " + this.getYear() + "]";
    }
    /**
     * override equals method
     * @param obj object to be compared to
     * @return true if this and other object are the same
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Coin other = (Coin) obj;
        if (name == null) {
            if (other.name != null)
                return false;
        } else if (!name.equals(other.name))
            return false;
        if (year != other.year)
            return false;
        if (value != other.value)
            return false;
        return true;
    }
    public static void main(String[] args) {
        Coin c1 = new Coin();
        Coin c2 = new Coin(1, 2002);
        Coin c3 = new Coin(5, 2005);
        Coin c4 = new Coin(10, 1977);
        Coin c5 = new Coin(25, 2001);
        Coin c6 = new Coin(25, 2001);
        System.out.println(c1);
        System.out.println(c2);
        System.out.println(c3);
        System.out.println(c5);
        System.out.println(c5.equals(c6));
        System.out.println(c3.equals(c4));
    }
}