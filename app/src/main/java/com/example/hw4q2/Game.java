package com.example.hw4q2;

import java.util.Random;

public class Game
{
    //integer array contains 10 random numbers
    private int[] numbers = new int[10];

    //Random number generator
    Random randomNumber = new Random();

    //numbers of swaps
    private int swaps;

    //window location
    private int windowLocation;

    public Game()
    {
        //initializing an array to random number 1-100
        for(int x = 0 ; x<numbers.length ; x++)
        {
            numbers[x] = randomNumber.nextInt(100)+1;
        }

        //initializing numbers of swaps
        swaps = 45;

        //initial window location
        windowLocation= randomNumber.nextInt(8);
    }

    //get a random numbers Array
    public int[] getArray()
    {
        return numbers;
    }

    //get number of swaps
    public int getSwaps()
    {
        return swaps;
    }

    //get window location
    public int getWindowLocation()
    {
        return windowLocation;
    }

    //method checks if the arrays is sorted
    public boolean sorted()
    {
        //check if the array is sorted
        for(int x = 0 ; x < numbers.length-1 ; x++)
        {
            // if the current number is greater than next number,
            // it is not sorted yet
            if(numbers[x]>numbers[x+1])
                return false;
        }

        return true;
    }

    //get message
    public String getMessage()
    {
        if(sorted())
            return "You have won";
        else if (swaps == 0)
            return "No more swaps left";
        else
            return swaps+" Swaps left";
    }

    //method swaps two numbers in array
    public void swap()
    {
        //swapping two numbers
        int temp = numbers[windowLocation];
        numbers[windowLocation]= numbers[windowLocation+1];
        numbers[windowLocation+1] = temp;

        //decrement number of swaps
        swaps-=1;
    }

    //method moves the window location
    public void move()
    {
        windowLocation = (windowLocation + 1) % 9;
    }

    //method checks if the game is over or not
    public boolean gameOver()
    {
        //if 0 swaps left
        if(swaps == 0)
            return true;
        //if the array is sorted
        else if(sorted())
            return true;
        else
            return false;
    }


}
