/*
 * I affirm that I have carried out my academic endeavors with full academic honesty.
 */
package assignment;

import java.util.Objects;

/**
 * The class for an integer and frequency pair
 * @author Zeynep Orhan
 *
 */
public class ListItem {
    //Instance variables int item and int freq
    private int item;
    private int freq;
//Constructors: One with no parameters and one with 2 integer parameters
    public ListItem()
    {
     this.item = 0;
     this.freq = 0;
    }
    public ListItem(int item, int freq)
    {
        this.setItem(item);
        this.setFreq(freq);
    }
//setters and getters

    public int getItem() {
        return item;
    }

    public int getFreq() {
        return freq;
    }

    public void setItem(int item) {
        this.item = item;
    }

    public void setFreq(int freq) {
        this.freq = freq;
    }

    //toString
    public String toString() {
        return "[" + item + ", " + freq + "]";
    }

//hashCode

    //hashCode
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + freq;
        result = prime * result + item;
        return result;
    }

    //equals
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        ListItem other = (ListItem) obj;
        if (freq != other.freq)
            return false;
        if (item != other.item)
            return false;
        return true;
    }

    public static void main(String[] args) {
        ListItem lI1 = new ListItem(1,1);
        ListItem lI2 = new ListItem(3,5);
        ListItem lI3 = new ListItem(8,4);
        System.out.println(lI1);
        System.out.println(lI2);
        System.out.println(lI3);
    }
}