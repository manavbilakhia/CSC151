package assignment;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;

import static org.junit.jupiter.api.Assertions.*;

class ListEncodeDecodeTest {

    @Test
    void packed() {
        Integer items[] = {1,1,1,3,3,3,3,3,4,4};
        ArrayList<Integer> uncompressed = new ArrayList<>();
        ArrayList<ListItem> compressedexp = new ArrayList<>();
        ArrayList<ListItem> compressedact = new ArrayList<>();
        Collections.addAll(uncompressed, items);
        ListItem item1  = new ListItem(1,3);
        ListItem item2  = new ListItem(3,5);
        ListItem item3  = new ListItem(4,2);
        compressedexp.add(item1);
        compressedexp.add(item2);
        compressedexp.add(item3);
        ListEncodeDecode.packed(uncompressed, compressedact, 0);
        assertArrayEquals(compressedexp.toArray(),compressedact.toArray());

    }

    @Test
    void unpacked() {
        Integer items[] = {1,1,1,3,3,3,3,3,4,4};
        ArrayList<Integer> uncompressedexp = new ArrayList<>();
        ArrayList<Integer> uncompressedact = new ArrayList<>();
        ArrayList<ListItem> compressed = new ArrayList<>();
        Collections.addAll(uncompressedexp, items);
        ListItem item1  = new ListItem(1,3);
        ListItem item2  = new ListItem(3,5);
        ListItem item3  = new ListItem(4,2);
        compressed.add(item1);
        compressed.add(item2);
        compressed.add(item3);
        ListEncodeDecode.unpacked(compressed,uncompressedact,0);
        assertArrayEquals(uncompressedexp.toArray(),uncompressedact.toArray());

    }

    @Test
    void unpackItem() {
        Integer items[] = {5,5,5,5,5,5,5};
        ArrayList<Integer> repeatedListexp = new ArrayList<>();
        ArrayList<Integer> repeatedListact = new ArrayList<>();
        Collections.addAll(repeatedListexp,items);
        ListEncodeDecode.unpackItem(5,7,repeatedListact);
        assertArrayEquals(repeatedListexp.toArray(),repeatedListact.toArray());


    }
}