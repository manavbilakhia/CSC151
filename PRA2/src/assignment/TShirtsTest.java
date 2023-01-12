package assignment;

import org.junit.Assert;

import static org.junit.jupiter.api.Assertions.*;

class TShirtsTest {

    @org.junit.jupiter.api.Test
    void getSize() {
        TShirts tsh = new TShirts(2,"green");
        assertEquals(2,tsh.getSize());

    }

    @org.junit.jupiter.api.Test
    void getColor() {
        TShirts tsh = new TShirts(2,"green");
        assertEquals("green",tsh.getColor());
    }

    @org.junit.jupiter.api.Test
    void setAll() {
        TShirts tsh = new TShirts(2,"green");
        tsh.setAll(3,"red");
        assertEquals("red",tsh.getColor());
        assertEquals(3,tsh.getSize());

    }
}