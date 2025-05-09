// ImplementLowerBound
/*Given a sorted array arr[] and an integer x, find the index (0-based) of the largest element in arr[] that is less than or equal to x. This element is called the floor of x. If such an element does not exist, return -1.

Note: In case of multiple occurrences of ceil of x, return the index of the last occurrence.

Examples

Input: arr[] = [1, 2, 8, 10, 10, 12, 19], x = 5
Output: 1
Explanation: Largest number less than or equal to 5 is 2, whose index is 1. */

import java.util.*;
public class FloorinaSortedArray {
    static int findFloor(int[] arr, int x)
    {
        int left = 0, right = arr.length-1;
        int result = -1;
        while(left <= right)
        {
            int mid = (left+ right)/2;
        
            if(arr[mid] <= x)
            {
                result = mid;
                left = mid+1;
            }else {
                right = mid-1;
            }
        }
        return result;
    }
    public static void main(String[] args) {
        int[] arr = {2,4,6,18,19,24};
        int x = 20;
        System.out.println("Floor of "+x+" is at index "+findFloor(arr, x));
    }
    
}

