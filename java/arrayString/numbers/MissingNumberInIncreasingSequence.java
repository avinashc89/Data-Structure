package com.tool.java.arrayString.numbers;

public class MissingNumberInIncreasingSequence
{
    /*
     
     Input: arr[] = {1, 2, 3, 4, 6, 7, 8}
        Output: 5
      
     */
    public int findMissingElement(int[] array, int low, int high)
    {
        // Invalid input case: if the array size is 0 or less than 0
        if (low > high)
        {
            System.out.println("Invalid Input");
            return -1;
        }
         
        // if the last element of the given array is correctly placed, then we can say that
        // all the elements of the given array are correctly placed
        if (correctlyPlaced(high, array[high]))
        {
            System.out.println("No missing number. All elements are correctly placed");
            return 0;
        }
         
        // we have found the first element from the left in the given sequence which is incorrectly placed.
        // Missing number must be this element's value minus 1
        if (low == high)
        {
            return array[high] - 1;
        }
         
        int mid = (low + high)/2;
         
        if (!correctlyPlaced(mid, array[mid]))
        {
            high = mid;
        }
        else
        {
            low = mid + 1;
        }
         
        return findMissingElement(array, low, high);
    }
    
    private boolean correctlyPlaced(int index, int number)
    {
        // remember we are using 0 based indexing scheme
        if (number == (index + 1))
        {
            return true;
        }
         
        return false;
    }

}
