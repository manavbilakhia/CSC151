package assignment;

import static org.junit.jupiter.api.Assertions.*;
import java.util.*;

class TShirtStackTest {

    @org.junit.jupiter.api.Test
    void addTShirt() {
        TShirtStack tsh = new TShirtStack();
        TShirts tsh1 = new TShirts(2,"Red");
        TShirts tsh2 = new TShirts(3,"Blue");
        tsh.addTShirt(tsh1);
        tsh.addTShirt(tsh2);
        assertNotNull(tsh);
    }

    @org.junit.jupiter.api.Test
    void sell() {
        TShirtStack tsh = new TShirtStack();
        TShirts tsh1 = new TShirts(2,"Red");
        TShirts tsh2 = new TShirts(3,"Blue");
        tsh.addTShirt(tsh1);
        tsh.addTShirt(tsh2);
        tsh.sell("blue");
        tsh.sell("red");
        tsh.sell("green");
        assertNotNull(tsh);


    }

    @org.junit.jupiter.api.Test
    void order() {
        TShirtStack tsh = new TShirtStack();
        tsh.order();
        assertNotNull(tsh);

    }
}