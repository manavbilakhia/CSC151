package assignment;
import java.util.*;
/**
 * This class packs/unpacks the lists of integers
 * The repeated items are represented
 * by the item and its frequency in the packed version
 *
 * The items and the frequencies can be unpacked
 * as the full representation
 *
 * @author Zeynep Orhan
 *
 */
public class ListEncodeDecode {
/**
 * Recursive static method packed: Pack the list of repeated sequences into item and frequency pairs
 *
 * @param repeatedList an ArrayList of Integers of repeated sequences
 * @param packList an ArrayList of ListItem where we have item and frequencies
 * @param start index of the starting position in the repeatedList
 *
 */

    public static void packed(ArrayList <Integer>repeatedList, ArrayList <ListItem>packList,int start)
    {
        Collections.sort(repeatedList);
        if(start >= repeatedList.size())
        {
            return;
        }
        if(packList.isEmpty())
        {
            ListItem item  =  new ListItem(repeatedList.get(start),1);
            packList.add(item);

        }
        else {
            ListItem current = packList.get(packList.size()-1);
            if (repeatedList.get(start)== current.getItem())
            {
                current.setFreq(current.getFreq()+1);
            }
            else{
                ListItem item  =  new ListItem(repeatedList.get(start),1);
                packList.add(item);
            }
        }
        packed(repeatedList, packList, start+1);
    }

/**
 * Recursive static method unpacked: Unpack the list of item and frequency pairs into repeated sequences
 *
 * This method mutates the elements of the repeated list
 * @param packList an ArrayList of ListItem where we have item and frequencies
 * @param repeatedList an ArrayList of Integers of repeated sequences
 * @param start index of the starting position in the repeatedList
*/
public static void unpacked(ArrayList <ListItem>packList,ArrayList <Integer>repeatedList,int start)
{

    if(start >= packList.size())
    {
        return;
    }
    ListItem current = packList.get(start);
    repeatedList.add(current.getItem());
    current.setFreq(current.getFreq()-1);
    if(current.getFreq()==0)
    {
        start+=1;
    }
    unpacked(packList,repeatedList,start);
}
    /**
     * Recursive static method unpackItem: Unpack one item, add item to repeatedList howMany times
     * @param item int item to be added
     * @param howMany int frequency of the item
     * @param repeatedList ArrayList<Integer> the result of adding item howMany times to this list
*/
    public static void unpackItem(int item, int howMany, ArrayList <Integer>repeatedList)
    {
        if (howMany<=0)
            return;
        repeatedList.add(item);
        unpackItem(item, howMany-1,repeatedList);
    }

    public static void main(String[] args) {
        //Integer items[] = {2};
        Integer items[] = {1,1,1,2,3,3,3,3,3,4,4};
//Integer items[] = { 1, 1, 1 };
        ArrayList<Integer> uncompressed = new ArrayList<>();
        ArrayList<ListItem> compressed = new ArrayList<>();
        ArrayList<Integer> newUncompressed = new ArrayList<>();
        ArrayList<Integer> repeatedList = new ArrayList<>();
        Collections.addAll(uncompressed, items);
        packed(uncompressed, compressed, 0);
        System.out.println(uncompressed);
        System.out.println(compressed);
        unpacked(compressed, newUncompressed, 0);
        unpackItem(5,7,repeatedList);


        System.out.println(newUncompressed);
        System.out.println(repeatedList);
    }
}