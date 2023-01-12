/*
 * I affirm that I have carried out the attached academic endeavors with full academic honesty.
 * Manav Bilakhia (MB)
 */
package assignment;
/**
 * Testing for Array operations that use search and sort
 *
 * @Manav Bilakhia
 */
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ArrayOperationsTest {

    @Test
    void doubleExists(){
        int[] arr1 = { 9,1,6,3,2,0,1,6 };
        int[] arr2 = { 2,8,6,7,5,2,5,2};
        int[] arr3 = {};
        assertEquals(true,ArrayOperations.doubleExists(arr1));
        assertEquals(false,ArrayOperations.doubleExists(arr2));
        assertEquals(false,ArrayOperations.doubleExists(arr3));
    }

    @Test
    void moveGivenValue() {
        int[] arr4 = { 2,0,0,2,3,0,0,3 };
        ArrayOperations.moveGivenValue(arr4,0);
        int [] expectedArr4 = {2,2,3,3,0,0,0,0};
        int[] arr5 = { 0 };
        ArrayOperations.moveGivenValue(arr5,0);
        int [] expectedArr5 = {0};
        int[] arr6 = { 1,9,7,7 };
        ArrayOperations.moveGivenValue(arr6,9);
        int [] expectedArr6 = {1,7,7,9};
        assertArrayEquals(expectedArr4,arr4);
        assertArrayEquals(expectedArr5,arr5);
        assertArrayEquals(expectedArr6,arr6);

    }

    @Test
    void sortEvenOdd() {
        int[] arr8 = { 6,6,7,6,5,1,6 };
        ArrayOperations.sortEvenOdd(arr8);
        int[] expectedArr8 = {6, 6, 6, 6, 1, 5, 7};
        int[] arr9 = { 3, 1 };
        ArrayOperations.sortEvenOdd(arr9);
        int[] expectedArr9 = {1,3};
        int[] arr10 = { 8, 6, 2, 4 };
        ArrayOperations.sortEvenOdd(arr10);
        int[] expectedArr10 = {8,6,4,2};
        ArrayOperations.sortEvenOdd(arr10);
        assertArrayEquals(expectedArr8,arr8);
        assertArrayEquals(expectedArr9,arr9);
        assertArrayEquals(expectedArr10,arr10);
    }
}