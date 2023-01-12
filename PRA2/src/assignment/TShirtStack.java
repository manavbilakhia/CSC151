package assignment;

import java.util.Arrays;
import java.util.Stack;
import java.util.StringJoiner;

public class TShirtStack {
//0:S 1:M 2:L 3:XL 4:Big Size You may use a String array

    //Constant values for STOCK_LIMIT
    private static int STOCK_LIMIT = 3;
    private Stack<TShirts> red;
    private Stack<TShirts> blue;
    private Stack<TShirts> green;
    private Integer[] sizeInStock; // 0 = small. 1 = mediunm, 2 = large, 3 = XL, 4 = big
    private Integer[] soldOut;

    //Instance variables red, green, blue Stacks
    //and int arrays sizesInStock and soldOut


    //Parameterless Constructor initialize arrays and stacks
    public TShirtStack() {
        red = new Stack<>();
        blue = new Stack<>();
        green = new Stack<>();
        sizeInStock = new Integer[5];
        soldOut = new Integer[5];
        for (int i = 0; i < sizeInStock.length; i++) {
            sizeInStock[i] = 0;
            soldOut[i] = 0;
        }
    }

    //addTShirt method
    public void addTShirt(TShirts TShirt) {
        String color = TShirt.getColor();
        switch (color) {
            case "Red":
                red.push(TShirt);
                sizeInStock[TShirt.getSize()] += 1;
                break;
            case "Blue":
                blue.push(TShirt);
                sizeInStock[TShirt.getSize()] += 1;
                break;
            case "Green":
                green.push(TShirt);
                sizeInStock[TShirt.getSize()] += 1;
                break;
            default:
                System.out.println("you shouldnt be here in add");
                break;
        }
    }

    public void sell(String color) {
        color=color.toLowerCase();
        switch (color) {
            case "red":
                TShirts TShirtRed = red.pop();
                sizeInStock[TShirtRed.getSize()] -= 1;
                soldOut[TShirtRed.getSize()] += 1;
                order();
                break;
            case "blue":
                TShirts TShirtBlue = blue.pop();
                sizeInStock[TShirtBlue.getSize()] -= 1;
                soldOut[TShirtBlue.getSize()] += 1;
                order();
                break;
            case "green":
                TShirts TShirtGreen = green.pop();
                sizeInStock[TShirtGreen.getSize()] -= 1;
                soldOut[TShirtGreen.getSize()] += 1;
                order();
                break;
            default:
                //System.out.println("you shouldnt be here in sell");
                break;
        }
    }

    public void order() {
        //System.out.println("you are in the order method");
        for (int i = 0; i < sizeInStock.length; i++) {
            // System.out.println("you are inside order for loop");
            if (sizeInStock[i] < STOCK_LIMIT) {
                //System.out.println("you are inside order for loop if statement");
                TShirts TShirtRed = new TShirts(i, "red");
                TShirts TShirtBlue = new TShirts(i, "blue");
                TShirts TShirtGreen = new TShirts(i, "green");
                for (int j = 0; j < STOCK_LIMIT; j++) {
                    //System.out.println("you are inside the for loop to add the t shirts");
                    red.push(TShirtRed);
                    blue.push(TShirtBlue);
                    green.push(TShirtGreen);
                    sizeInStock[i] += 3;
                }
            }
        }
    }

    private static String colorStackString(Stack<TShirts> stack) {
        final String[] size = {"S", "M", "L", "XL", "Big" };

        String[] strArr = new String[stack.size()];
        Object[] arr = stack.toArray();

        for (int i = 0; i < stack.size(); i++) {
            TShirts ts = (TShirts) arr[i];
            strArr[i] = size[ts.getSize()];
        }

        return String.join(",", strArr);
    }

    private static String stockSoldString(Integer[] arr) {
        return "S:" + arr[0] + " M:" + arr[1] + " L:" + arr[2] + " XL:" + arr[3] + " Big:" + +arr[4];
    }

    //sell method
    //order method
    //toString method
    @Override
    public String toString() {
        /*
                TShirt Stacks by color
                red=S,S,S,M,M,M,L,L,L,XL,XL,XL,Big,Big,Big
                green=S,S,S,M,M,M,L,L,L,XL,XL,XL,Big,Big,Big
                blue=S,S,S,M,M,M,L,L,L,XL,XL,XL,Big,Big,Big
                sizesInStock=S:9 M:9 L:9 XL:9 Big:9
                soldOut=S:0 M:0 L:0 XL:0 Big:0
        */

        String res = "TShirt Stacks by color\n";

        res += "red=" + colorStackString(red) + "\n";
        res += "green=" + colorStackString(green) + "\n";
        res += "blue=" + colorStackString(blue) + "\n";
        res += "sizesInStock=" + stockSoldString(sizeInStock) + "\n";
        res += "soldOut=" + stockSoldString(soldOut) + "\n";

        return res;
    }

    //main method. Please change this completely
    public static void main(String[] args) {
        /* String colors[] = {"Red", "Green", "Blue" };
        TShirtStack tsh = new TShirtStack();
        System.out.println(tsh);
        for (int i = 0; i < 5; i++) {
            tsh.addTShirt(new TShirts(i % (1 + TShirts.MAX_SIZE), colors[i % 3]));
            System.out.println(tsh);
        }
        tsh.sell("red");
        System.out.println(tsh);
        tsh.sell("green");
        System.out.println(tsh);
        tsh.sell("blue");
        System.out.println(tsh);


        TShirtStack actual = new TShirtStack();
        actual.addTShirt(new TShirts(1, "Red"));
        actual.sell("Red");
        System.out.println(actual.toString());


        TShirtStack tsh = new TShirtStack();
        TShirts tsh1 = new TShirts(2,"Red");
        TShirts tsh2 = new TShirts(3,"Blue");
        tsh.addTShirt(tsh1);
        tsh.addTShirt(tsh2);
        System.out.println(tsh);

         */
        TShirtStack tsh = new TShirtStack();
        TShirts tsh1 = new TShirts(2,"Red");
        TShirts tsh2 = new TShirts(3,"Blue");
        tsh.addTShirt(tsh1);
        tsh.addTShirt(tsh2);
        tsh.sell("blue");
        System.out.println(tsh);
    }
}
