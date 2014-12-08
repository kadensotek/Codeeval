import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import java.lang.Exception;

import java.util.List;
import java.util.LinkedList;

import com.rrj09832.interruptedbubblesort.InterruptedBubbleSort;

public class TestInterruptedBubbleSort
{
    private InterruptedBubbleSort ibs;

    @Before
    public void setUp() throws Exception
    {
        ibs = new InterruptedBubbleSort();
    }

    /*******************************************
     *
     *   sort test
     *
     *******************************************/

    @Test
    public void sortingListShouldSortList()
    {
        String expectedString1 = "4 3 2 1 5";
        String expectedString2 = "3 2 1 4 5";
        String expectedString3 = "2 1 3 4 5";
        String expectedString4 = "1 2 3 4 5";  // Used for last two cases

        // One repetition
        List<Integer> numberList = initializeList();
        ibs.sort(numberList, 1L);
        assertEquals(expectedString1, ibs.getFormattedString(numberList));

        // Two repetitions
        numberList = initializeList();
        ibs.sort(numberList, 2L);
        assertEquals(expectedString2, ibs.getFormattedString(numberList));

        // Three repetitions
        numberList = initializeList();
        ibs.sort(numberList, 3L);
        assertEquals(expectedString3, ibs.getFormattedString(numberList));

        // Four repetitions
        numberList = initializeList();
        ibs.sort(numberList, 4L);
        assertEquals(expectedString4, ibs.getFormattedString(numberList));

        // Five repetitions
        numberList = initializeList();
        ibs.sort(numberList, 5L);
        assertEquals(expectedString4, ibs.getFormattedString(numberList));
    }

    public List<Integer> initializeList()
    {
        List<Integer> numberList = new LinkedList<Integer>();
        numberList.add(5);
        numberList.add(4);
        numberList.add(3);
        numberList.add(2);
        numberList.add(1);
        return numberList;
    }

    /*******************************************
     *
     *   swap test
     *
     *******************************************/

     @Test
     public void swappingTwoElementsShouldCorrectlySwap()
     {
         List<Integer> numberList = new LinkedList<Integer>();
         numberList.add(2);
         numberList.add(1);
         ibs.swap(numberList, 0, 1);
         assertEquals((int)1, (int)numberList.get(0));
         assertEquals((int)2, (int)numberList.get(1));
     }

    /*******************************************
     *
     *   getFormattedString test
     *
     *******************************************/

    @Test
    public void getFormattedStringShouldReturnCorrectlyFormattedString()
    {
        String expectedString = "1 2 3";
        List<Integer> numberList = new LinkedList<Integer>();
        numberList.add(1);
        numberList.add(2);
        numberList.add(3);
        assertEquals(expectedString, ibs.getFormattedString(numberList));
    }

    /*******************************************
     *
     *   getNumberList test
     *
     *******************************************/

    @Test
    public void getNumberListShouldReturnCorrectlyOrderedListOfNumbers()
    {
        String numberString = "1 2 3";
        List<Integer> expectedList = new LinkedList<Integer>();
        expectedList.add(1);
        expectedList.add(2);
        expectedList.add(3);
        assertEquals(expectedList, ibs.getNumberList(numberString));
    }
}
