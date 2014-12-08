package com.rrj09832.textdollar;

import java.lang.String;
import java.util.Scanner;
import java.util.Stack;

import java.lang.Character;
import java.lang.StringBuilder;

import java.io.File;
import java.io.FileNotFoundException;

public class TextDollar
{
    public static void main(String[] args)
    {
        File myfile = new File(args[0]);
        Scanner myscanner = null;
        String numericDollar = "";
        String textDollar = "";

        try
        {
            myscanner = new Scanner(myfile);
        }
        catch(FileNotFoundException ex)
        {
            System.err.println("File not found.  Try again with a valid filename.");
            System.exit(1);
        }

        while(myscanner.hasNextLine())
        {
            numericDollar = myscanner.nextLine();
            textDollar = convertToText(numericDollar);
            System.out.println(textDollar);
        }
    }

    // Takes a positive integer (in String format) and returns the value written out in English
    public static String convertToText(String numericDollar)
    {
        Stack<Integer> digitStack = new Stack<Integer>();
        StringBuilder sbResult = new StringBuilder();  // For building result string
        int tripletCount = 0;  // Keeps track of number of sets of three digits
        int ones, tens, hundreds = 0;

        // Catches special case of zero since no processing is needed
        if(numericDollar.equals("0"))
        {
            return "ZeroDollars";
        }

        char[] digits = numericDollar.toCharArray();
        digitStack = populateStack(digitStack, digits);  // Converts chars to ints and fills stack

        sbResult.append("Dollars");

        // Takes digits off in groups of three, padding with 0's if it empties midway
        while(!digitStack.empty())
        {
            ones = getNumericDigit(digitStack);
            tens = getNumericDigit(digitStack);
            hundreds = getNumericDigit(digitStack);
            tripletCount++;

            processTriplet(sbResult, tripletCount, ones, tens, hundreds);
        }

        return sbResult.toString();
    }

    //  Takes three digit group and gets text value
    public static void processTriplet(StringBuilder sbResult, int tripletCount, int ones, int tens, int hundreds)
    {
        // Gets Thousand or Million if needed
        if(tripletCount > 1)
        {
            // If there's at least one non-zero digit in the triplet
            if(ones != 0 || tens != 0 || hundreds != 0)
            {
                sbResult.insert(0, getTripletModifier(tripletCount));
            }
        }

        if(tens == 1) // Gets text for TEEN numbers
        {
            sbResult.insert(0,getTeensDigits(ones));
        }
        else
        {
            // Gets text for ONES place
            sbResult.insert(0, getSingleDigitText(ones));

            // Gets text for TENS place
            if(tens != 0)
            {
                sbResult.insert(0, getTensPlaceText(tens));
            }
        }

        // Gets text for HUNDREDS place
        if(hundreds != 0)
        {
            sbResult.insert(0, "Hundred");
            sbResult.insert(0, getSingleDigitText(hundreds));
        }
    }

    // Gets Thousand and Million modifiers
    public static String getTripletModifier(int tripletCount)
    {
        String text = "";
        switch(tripletCount)
        {
            case 2:
                text = "Thousand";
                break;
            case 3:
                text = "Million";
                break;
            default:
                break;
        }
        return text;
    }

    // Gets text for non-Teen TENS
    public static String getTensPlaceText(int tens)
    {
        String text = "";
        switch(tens)
        {
            case 2:
                text = "Twenty";
                break;
            case 3:
                text = "Thirty";
                break;
            case 4:
                text = "Forty";
                break;
            case 5:
                text = "Fifty";
                break;
            case 6:
                text = "Sixty";
                break;
            case 7:
                text = "Seventy";
                break;
            case 8:
                text = "Eighty";
                break;
            case 9:
                text = "Ninety";
                break;
            default:
                ;
        }
        return text;
    }

    // Gets text for TEEN numbers
    public static String getTeensDigits(int ones)
    {
        String text = "";
        switch(ones)
        {
            case 0:
                text = "Ten";
                break;
            case 1:
                text = "Eleven";
                break;
            case 2:
                text = "Twelve";
                break;
            case 3:
                text = "Thirteen";
                break;
            case 4:
                text = "Fourteen";
                break;
            case 5:
                text = "Fifteen";
                break;
            case 6:
                text = "Sixteen";
                break;
            case 7:
                text = "Seventeen";
                break;
            case 8:
                text = "Eighteen";
                break;
            case 9:
                text = "Nineteen";
                break;
            default:
                ;
        }
        return text;
    }

    // Gets text for single digit number
    public static String getSingleDigitText(int digit)
    {
        String text = "";
        switch(digit)
        {
            case 1:
                text = "One";
                break;
            case 2:
                text = "Two";
                break;
            case 3:
                text = "Three";
                break;
            case 4:
                text = "Four";
                break;
            case 5:
                text = "Five";
                break;
            case 6:
                text = "Six";
                break;
            case 7:
                text = "Seven";
                break;
            case 8:
                text = "Eight";
                break;
            case 9:
                text = "Nine";
                break;
            default:
                text = "";
        }
        return text;
    }

    // Gets next digit off stack, or gets ZERO to hold place in triplet
    public static int getNumericDigit(Stack<Integer> digitStack)
    {
        if(!digitStack.empty())
        {
            return digitStack.pop();
        }
        else
        {
            return 0;
        }
    }

    // Converts char to integer and pushes onto stack
    public static Stack<Integer> populateStack(Stack<Integer> digitStack, char[] digits)
    {
        for(char c : digits)
        {
            digitStack.push(Character.getNumericValue(c));
        }
        return digitStack;
    }
}