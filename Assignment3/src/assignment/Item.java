/*
 * I affirm that I have carried out the attached academic endeavors with full academic honesty.
 * Manav Bilakhia (MB)
 */
package assignment;
/**
 *
 * @author Manav Bilakhia
 *
 */
public class Item {
    /*
     * Instance variables
     */
    private String description;
    private int price;

    /**
     *parameterized constructoe
     * @param description description of the item
     * @param price price of a given item
     */
    public Item(String description, int price)
    {
    this.setDescription(description);
    this.setPrice(price);
    }

    /**
     *getter method
     * @return the description of the item
     */
    public String getDescription() {
        return description;
    }

    /**
     *setter method
     * @param description sets the description of a given method
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     *getter method
     * @return the price of the given the item
     */
    public int getPrice() {
        return price;
    }

    /**
     * setter method
     * @param price sets the price of a given item
     */
    public void setPrice(int price) {
        this.price = price;
    }

    /**
     * to string method
     * @return the output in the given format
     */
    @Override
    public String toString() {
        int dollars = this.price/100;
        int cents = this.price%100;
        String toReturn = this.getDescription() + "\t" +"$"+ dollars + "."+cents;
        return toReturn;
    }
    /**
     * override equals method
     * @param obj object to be compared to
     * @return true if this and other object are the same
     */
    public boolean equals(Object obj) {
    if (this == obj)
        return true;
    if (obj == null)
        return false;
    if (getClass() != obj.getClass())
        return false;
    Item other = (Item) obj;
    if (description == null) {
        if (other.description != null)
            return false;
    } else if (!description.equals(other.description))
        return false;
    if (price != other.price)
        return false;
    return true;
    }
    public static void main(String[] args) {

        Item i2 = new Item("Shampoo", 2002);
        Item i3 = new Item("Shampoo", 2002);
        Item i4 = new Item("Chicken", 1977);
        System.out.println(i2);
        System.out.println(i3);
        System.out.println(i4);
        System.out.println(i3.equals(i2));
        System.out.println(i2.equals(i4));
    }
} // end Item