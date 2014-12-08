import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import java.lang.Exception;

import java.util.Stack;

import com.rrj09832.textdollar.TextDollar;

public class TestTextDollar
{
    private TextDollar textdollar;

    @Before
    public void setUp() throws Exception
    {
        textdollar = new TextDollar();
    }

    /*******************************************
     *
     *   convertToText tests
     *
     *******************************************/

    @Test
    public void minimumValueShouldReturnZeroDollars()
    {
        assertEquals("ZeroDollars", textdollar.convertToText("0"));
    }

    @Test
    public void maximumValueShouldReturn999Million999Thousand999()
    {
        assertEquals("NineHundredNinetyNineMillionNineHundredNinetyNineThousandNineHundredNinetyNineDollars",
                textdollar.convertToText("999999999"));
    }

    @Test
    public void validValueShouldReturnCorrectText()
    {
        assertEquals("NinetyNineDollars", textdollar.convertToText("99"));
        assertEquals("FourThousandThreeHundredTwentyOneDollars", textdollar.convertToText("4321"));
        assertEquals("TwentyEightThousandOneDollars", textdollar.convertToText("28001"));
        assertEquals("OneHundredTwentyFiveThousandTenDollars", textdollar.convertToText("125010"));
        assertEquals("OneMillionDollars", textdollar.convertToText("1000000"));
        assertEquals("TwelveMillionOneThousandDollars", textdollar.convertToText("12001000"));
    }


    /*******************************************
     *
     *   getTripletModifier tests
     *
     *******************************************/

    @Test
    public void invalidTripletModifierShouldReturnEmptyString()
    {
        assertEquals("", textdollar.getTripletModifier(0));
        assertEquals("", textdollar.getTripletModifier(1));
        assertEquals("", textdollar.getTripletModifier(4));
    }

    @Test
    public void validTripletModifierShouldReturnCorrectText()
    {
        assertEquals("Thousand", textdollar.getTripletModifier(2));
        assertEquals("Million", textdollar.getTripletModifier(3));
    }


    /*******************************************
     *
     *   getTensPlaceText tests
     *
     *******************************************/

    @Test
    public void invalidTensPlaceShouldReturnEmptyString()
    {
        assertEquals("", textdollar.getTensPlaceText(0));
        assertEquals("", textdollar.getTensPlaceText(1));
        assertEquals("", textdollar.getTensPlaceText(10));
    }

    @Test
    public void validTensPlaceShouldReturnCorrectText()
    {
        assertEquals("Twenty", textdollar.getTensPlaceText(2));
        assertEquals("Thirty", textdollar.getTensPlaceText(3));
        assertEquals("Forty", textdollar.getTensPlaceText(4));
        assertEquals("Fifty", textdollar.getTensPlaceText(5));
        assertEquals("Sixty", textdollar.getTensPlaceText(6));
        assertEquals("Seventy", textdollar.getTensPlaceText(7));
        assertEquals("Eighty", textdollar.getTensPlaceText(8));
        assertEquals("Ninety", textdollar.getTensPlaceText(9));
    }


    /*******************************************
     *
     *   getTeensDigits tests
     *
     *******************************************/

    @Test
    public void invalidTeensDigitShouldReturnEmptyString()
    {
        assertEquals("", textdollar.getTeensDigits(10));
    }

    @Test
    public void validTeensDigitShouldReturnCorrectText()
    {
        assertEquals("Ten", textdollar.getTeensDigits(0));
        assertEquals("Eleven", textdollar.getTeensDigits(1));
        assertEquals("Twelve", textdollar.getTeensDigits(2));
        assertEquals("Thirteen", textdollar.getTeensDigits(3));
        assertEquals("Fourteen", textdollar.getTeensDigits(4));
        assertEquals("Fifteen", textdollar.getTeensDigits(5));
        assertEquals("Sixteen", textdollar.getTeensDigits(6));
        assertEquals("Seventeen", textdollar.getTeensDigits(7));
        assertEquals("Eighteen", textdollar.getTeensDigits(8));
        assertEquals("Nineteen", textdollar.getTeensDigits(9));
    }


    /*******************************************
     *
     *   getSingleDigitText tests
     *
     *******************************************/

    @Test
    public void invalidSingleDigitShouldReturnEmptyString()
    {
        assertEquals("", textdollar.getSingleDigitText(0));
        assertEquals("", textdollar.getSingleDigitText(10));
    }

    @Test
    public void validSingleDigitShouldReturnCorrectText()
    {
        assertEquals("One", textdollar.getSingleDigitText(1));
        assertEquals("Two", textdollar.getSingleDigitText(2));
        assertEquals("Three", textdollar.getSingleDigitText(3));
        assertEquals("Four", textdollar.getSingleDigitText(4));
        assertEquals("Five", textdollar.getSingleDigitText(5));
        assertEquals("Six", textdollar.getSingleDigitText(6));
        assertEquals("Seven", textdollar.getSingleDigitText(7));
        assertEquals("Eight", textdollar.getSingleDigitText(8));
        assertEquals("Nine", textdollar.getSingleDigitText(9));
    }


    /*******************************************
     *
     *   getNumericDigit tests
     *
     *******************************************/

    @Test
    public void emptyStackPopShouldReturnZero()
    {
        Stack<Integer> emptyStack = new Stack<Integer>();
        assertEquals(0, textdollar.getNumericDigit(emptyStack));
    }

    @Test
    public void nonEmptyStackPopShouldReturnCorrectDigit()
    {
        Stack<Integer> mystack = new Stack<Integer>();
        mystack.push(1);
        mystack.push(2);
        mystack.push(3);

        assertEquals(3, textdollar.getNumericDigit(mystack));
        assertEquals(2, textdollar.getNumericDigit(mystack));
        assertEquals(1, textdollar.getNumericDigit(mystack));
    }


    /*******************************************
     *
     *   populateStack tests
     *
     *******************************************/

    @Test
    public void stackShouldBePopulatedCorrectly()
    {
        Stack<Integer> mystack = new Stack<Integer>();
        char[] mychars = {'1', '2', '3' ,'4', '5'};
        textdollar.populateStack(mystack, mychars);

        assertEquals((Integer)5, mystack.pop());
        assertEquals((Integer)4, mystack.pop());
        assertEquals((Integer)3, mystack.pop());
        assertEquals((Integer)2, mystack.pop());
        assertEquals((Integer)1, mystack.pop());
    }
}
