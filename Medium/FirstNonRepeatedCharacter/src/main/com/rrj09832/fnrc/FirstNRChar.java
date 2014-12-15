package com.rrj09832.fnrc;

import java.io.FileNotFoundException;
import java.io.File;

import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

import java.lang.String;

public class FirstNRChar
{
    public static void main(String[] args) throws FileNotFoundException
    {
        File myfile = new File(args[0]);
        Scanner myscanner = new Scanner(myfile);
        String line = null;
        String result = null;

        while(myscanner.hasNextLine())
        {
            line = myscanner.nextLine();
            result = processLine(line);
            System.out.println(result);
        }
    }

    /* Parses line and prints first non-repeating character
     * Prints "empty string" if line is empty */
    public static String processLine(String line)
    {
        List<Character> readChars;  /* Holds one copy of each char that is read */
        List<Character> repeatedChars;  /* Holds chars that are repeated */
        char[] charArray;
        String result;

        if(line.length() < 1)
        {
            return "Empty string.";
        }
        if(line.length() == 1)
        {
            return line;
        }

        charArray = line.toCharArray();
        readChars = new ArrayList<Character>();
        repeatedChars = new ArrayList<Character>();

        /* */
        for(char ch : charArray)
        {
            if(repeatedChars.contains(ch))
            {
                ;  /* No extra action needed if it's a known repeat */
            }
            else if(readChars.contains(ch))
            {
                /* If repeated for first time, add to repeat list */
                repeatedChars.add(ch);
            }
            else
            {
                /* Add to read list if read for first time */
                readChars.add(ch);
            }
        }

        /*  */
        for(char c : readChars)
        {
            if(repeatedChars.contains(c))
            {
                ;  /* No action needed; move to next element */
            }
            else
            {
                return String.valueOf(c);
            }
        }
        /* Only reach this point if all characters repeat */
        return "No non-repeating characters found.";
    }
}