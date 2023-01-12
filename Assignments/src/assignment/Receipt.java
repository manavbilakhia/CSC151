/*
 * I affirm that I have carried out the attached academic endeavors with full academic honesty.
 * Manav Bilakhia (MB)
 */
package assignment;

/**
 * Receipt class for your receipts of Products.
 * Each Receipt has a collection of Product objects kept as array
 * Total cost is calculated as unit price x quantity for all
 * Product instances in the array
 *
 * @Manav Bilakhia
 */
public class Receipt
{
    /**
     * Limit value for max items as a constant
     */
    public static final int MAX_ITEMS = 100;
    /**
     * private instance variables for receipt as array and item count
     */
    private int itemCount;
    private Product [] receipt;

    /**
     * Constructor with no parameter
     */
    public Receipt()
    {
        receipt = new Product[MAX_ITEMS];
        itemCount = 0;
    }

    /**
     * addItem method for adding a Product to the array
     * @param product product to be added
     * @return itemCount
     */
    public int addItem(Product product)
    {
        if (itemCount<100) {
            receipt[itemCount] = product;
            itemCount++;
        }
        return itemCount;
    }

    /**
     * calcTotal method for calculating the total cost of items
     * @return total
     */
    public int calcTotal()
    {
        int total = 0;
        for(int i = 0; i< itemCount;i++)
        {
            total = total + receipt[i].total();
        }
        return total;
    }
    /**
     * override tostring method
     * @return string
     */
    @Override
    public String toString()
    {
        String str = "";
        for(int i = 0;i<itemCount;i++)
        {
            str = str + ""+ receipt[i] + "\n";
        }
        return str;
    }

    /**
     * main method for testing,
     * @param args default java main parameter
     */
    public static void main(String[] args)
    {
        // TODO Auto-generated method stub
        Receipt mR = new Receipt();
        mR.addItem(new Product(1,  3, "p1"));
        mR.addItem(new Product(70,  5, "p2"));
        mR.addItem(new Product(950,  20, "p3"));
        System.out.println(mR + " = " + mR.calcTotal());
    }
}