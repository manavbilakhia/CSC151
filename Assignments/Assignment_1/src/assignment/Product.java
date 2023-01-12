package assignment;

import java.util.Objects;

public class Product 
{
    private int unitPrice;
    private int quantity;
    private String pName;
    public static final int MAX_UNIT_PRICE = 100;
    public static final int MIN_UNIT_PRICE = 0;
    public static final int MAX_QUANTITY = 10;
    public static final int MIN_QUANTITY = 0;
    
    
    public Product()
    {
        unitPrice = 0;
        quantity = 0;
        pName = "NO NAME";
    }

    /**
     * Constructor with 3 parameters
     *
     * @param unitPrice initial unit price
     * @param quantity initial quantity
     * @param pName initial name of the product
     *
     *
     */
    public Product(int unitPrice,int quantity,String pName)
    {
        this.unitPrice = unitPrice;
        this.quantity = quantity;
        this.pName = pName;
    }
    
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
    	if (unitPrice<MIN_UNIT_PRICE || unitPrice>MAX_UNIT_PRICE)
    	{
            return;
    	}
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
    	if (quantity<MIN_QUANTITY || quantity>MAX_QUANTITY)
    	{
    		return;
    	}
		this.quantity = quantity;
    }
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

	@Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Product other = (Product) obj;
        if (unitPrice != other.unitPrice)
        {
            return false;
        }
        if (quantity != other.quantity)
        {
            return false;
        }
        if (pName == null)
        {
            if (other.pName !=null)
                return false;
        }
        else if (!pName.equals(other.pName))
        {
            return false;
        }

        return true;
    }
	
	public int total()
    {
        return this.getQuantity()*this.getUnitPrice();
    }

    /* Override toString method
     */
    //@Override
    public String toString()
    {
        return this.getPName()+":"+this.getUnitPrice()+" x "+this.getQuantity()+ " = "+ total();
    }
    /* main method for testing, change the one below completely
     */
    public static void main(String[] args)
    {
        Product p1=new Product();
        Product p2=new Product(10,20,"Candy");
        int total=p1.total()+p2.total();
        System.out.println(p1);
        System.out.println(p2);
        System.out.println(total);
        p1.setUnitPrice(35);
        p1.setQuantity(125);
        System.out.println(p1);
        System.out.println(p2);
        total=p1.total()+p2.total();
        System.out.println(total);
        p1.setQuantity(5);
        System.out.println(p1);
        System.out.println(p2);
        total=p1.total()+p2.total();
        System.out.println(total);
    }
    

}
