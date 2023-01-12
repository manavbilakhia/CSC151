/*
 * I affirm that I have carried out the attached academic endeavors with full academic honesty.
 * Manav Bilakhia (MB)
 */
package assignment;
/**
 * Product class for your receipts.
 * Each Product has a name, unit price and quantity
 * Total cost is calculated as unit price x quantity
 *
 * @Manav Bilakhia

 */
public class Product
{

    //Limit values as constants
    public static final int MAX_UNIT_PRICE = 100;
    public static final int MIN_UNIT_PRICE = 0;
    public static final int MAX_QUANTITY = 10;
    public static final int MIN_QUANTITY = 0;

    /**
     * Instance variables for unit price, quantity, product name
     */
    private int unitPrice;
    private int quantity;
    private String pName;

    /**
     * Constructor with no parameter
     * int instance variables are set to 0
     * String instance variable is set to NO NAME
     */
    public Product()
    {
        unitPrice = 0;
        quantity = 0;
        pName = "NO NAME";
    }

    /**
     * Constructor with 3 parameters
     * @param unitPrice initial unit price
     * @param quantity initial quantity
     * @param pName initial name of the product
     */
    public Product(int unitPrice,int quantity,String pName)
    {
        this.setUnitPrice(unitPrice);
        this.setQuantity(quantity);
        this.setPName(pName);
    }
    /**
     * get method
     * @return unit price as integer
     */
    public int getUnitPrice()
    {
        return unitPrice;
    }


    /**
     * set method
     * @param unitPrice to set
     */
    public void setUnitPrice(int unitPrice)
    {
        if (unitPrice>MAX_UNIT_PRICE||unitPrice<MIN_UNIT_PRICE)
        {
            this.unitPrice = 0;
        }
        else
            this.unitPrice = unitPrice;
    }
    /**
     * get method
     * @return quantity as integer
     */
    public int getQuantity()
    {
        return quantity;
    }

    /**
     * set method
     * @param quantity to set
     */
    public void setQuantity(int quantity)
    {
        if (quantity>MAX_QUANTITY||quantity<MIN_QUANTITY)
        {
            this.quantity = 0;
        }
        else
            this.quantity = quantity;
    }

    /**
    * get method
    * @return product name as String
    */
    public String getPName()
    {
        return pName;
    }

    /**
     * set method
     * @param pName the pName to set
     */
    public void setPName(String pName)
    {
        this.pName = pName;
    }

    /**
     * Override equals method
     * @param obj second product for comaprison
     * @return
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Product other = (Product) obj;
        if (pName == null){
            if (other.pName !=null)
                return false;
        } else if (!pName.equals(other.pName))
            return false;
        if (quantity != other.quantity)
            return false;
        if (unitPrice != other.unitPrice)
            return false;
        return true;
    }

    /**
     * total method for calculating total
     * @return total
     */
    public int total()
    {
        return this.getQuantity()*this.getUnitPrice();
    }

    /**
     * override tostring method
     * @return string
     */
    @Override
    public String toString()
    {
        return this.getPName()+":"+this.getUnitPrice()+" x "+this.getQuantity()+ " = "+ total();
    }

    /**
     * main method for testing,
     * @param args default java main parameter
     */
    public static void main(String[] args)
    {
        Product p1=new Product();
        Product p2=new Product(100,10,"Chocolate");
        Product p3=new Product(100,10,"Chocolate");
        Product p4=new Product(0,0,"shampoo");
        Product p5=new Product(10,5,"soap");
        int total=p1.total()+p2.total()+p4.total()+ p5.total();
        System.out.println(p1);
        System.out.println(p2);
        System.out.println(p4);
        System.out.println(p5);
        System.out.println(total);
        System.out.println(p3.equals(p4));
        System.out.println(p3.equals(p2));
    }
}