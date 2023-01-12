/*
 * Honor Code
 */
package assignment;

public class TShirts {
    //0:S 1:M 2:L 3:XL 4:Big Size You may use a String array
    private int size;
    static int MAX_SIZE = 4;
    private String color;
    static int MIN_SIZE = 0;
    //Constant values for MAX_SIZE and MIN_SIZE

    //Instance variables

    /**
     * @param size
     * @param color
     */
    //Constructor
    public TShirts(int size, String color) {
        this.setColor(color);
        this.setSize(size);
    }
    //Set/get methods

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        if (size > MAX_SIZE || size < MIN_SIZE) {
            this.size = MIN_SIZE;
        } else {
            this.size = size;
        }
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        if (color == "Red" || color == "Blue" || color == "Green" || color == "red" || color == "blue" || color == "green") {
            this.color = color;
        } else {
            this.color = "";
        }
    }

    public void setAll(int size, String color) {
        setColor(color);
        setSize(size);
    }

    //toString method
    @Override
    public String toString() {
        switch (this.size) {
            case 0:
                return "size=S " + "color=" + color + "\n";
            case 1:
                return "size=M " + "color=" + color + "\n";
            case 2:
                return "size=L " + "color=" + color + "\n";
            case 3:
                return "size=XL " + "color=" + color + "\n";
            case 4:
                return "size=Big " + "color=" + color + "\n";
            default:
                return "you shouuldnt be here!";
        }
    }

    //main method. Please change this completely
    public static void main(String[] args) {
        String colors[] = {"Red", "Green", "Blue" };
        TShirts tsh[] = new TShirts[4];
        for (int i = 0; i < tsh.length; i++)
            tsh[i] = new TShirts(i, colors[i % 3]);
        for (int i = 0; i < tsh.length; i++)
            System.out.print(tsh[i]);
    }
}