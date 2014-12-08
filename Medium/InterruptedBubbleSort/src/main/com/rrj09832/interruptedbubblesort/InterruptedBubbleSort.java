package com.rrj09832.interruptedbubblesort;

import java.util.Scanner;
import java.util.List;
import java.util.LinkedList;

import java.lang.Integer;
import java.lang.StringBuilder;

import java.io.File;
import java.io.FileNotFoundException;


public class InterruptedBubbleSort
{
    public static void main(String[] args)
    {
        File myfile = new File(args[0]);
        Scanner lineScanner = null;
        List<Integer> numberList = null;
        String rawLine;
        String[] splitLine;
        long numRepetitions;

        try
        {
            lineScanner = new Scanner(myfile);
        }
        catch(FileNotFoundException ex)
        {
            System.err.println("File not found.  Try again with a valid filename.");
            System.exit(1);
        }

        while(lineScanner.hasNextLine())
        {
            // Get line from file and split it on pipe character
            rawLine = lineScanner.nextLine();
            splitLine = rawLine.split("\\|");

            // Removes leading space and gets integer value for number of repetitions
            splitLine[1] = splitLine[1].substring(1);
            numRepetitions = Integer.parseInt(splitLine[1]);

            // Creates list of elements and passes it to sort
            numberList = getNumberList(splitLine[0]);
            sort(numberList, numRepetitions);

            System.out.println(getFormattedString(numberList));
        }
    }

    // Bubble sort
    public static void sort(List<Integer> numberList, long numRepetitions)
    {
        // No need for more repetitions than elements in list
        if(numRepetitions > numberList.size()-1)
        {
            numRepetitions = numberList.size() - 1;
        }

        // Loops until desired number of repetitions is reached
        for(int i=0; i<numRepetitions; i++)
        {
            for(int j=0; j<numberList.size()-1; j++)
            {
                if(numberList.get(j) > numberList.get(j+1))
                {
                    swap(numberList, j, j+1);
                }
            }
        }
    }

    // Swaps two elements in list
    public static void swap(List<Integer> numberList, int firstPos, int secondPos)
    {
        Integer temp = numberList.get(secondPos);
        numberList.set(secondPos, numberList.get(firstPos));
        numberList.set(firstPos, temp);
    }

    // Iterates through list and returns string in correct format
    public static String getFormattedString(List<Integer> numberList)
    {
        StringBuilder sb = new StringBuilder();

        for(int i=0; i<numberList.size(); i++)
        {
            sb.append(numberList.get(i));

            if(i != numberList.size()-1)
            {
                sb.append(" ");
            }
        }
        return sb.toString();
    }

    // Parses string for integers and puts them in list
    public static List<Integer> getNumberList(String numberString)
    {
        List<Integer> numberList = new LinkedList<Integer>();
        Scanner numberReader = new Scanner(numberString);

        while(numberReader.hasNext())
        {
            numberList.add(numberReader.nextInt());
        }
        return numberList;
    }
}