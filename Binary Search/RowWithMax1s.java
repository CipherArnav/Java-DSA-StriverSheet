/* You are given a 2D binary array arr[][] consisting of only 1s and 0s. Each row of the array is sorted in non-decreasing 
order. Your task is to find and return the index of the first row that contains the maximum number of 1s. If no such row 
exists, return -1.

Note:
The array follows 0-based indexing.
The number of rows and columns in the array are denoted by n and m respectively.
Examples:

Input: arr[][] = [[0,1,1,1], [0,0,1,1], [1,1,1,1], [0,0,0,0]]
Output: 2
Explanation: Row 2 contains the most number of 1s (4 1s). Hence, the output is 2.
Input: arr[][] = [[0,0], [1,1]]
Output: 1
Explanation: Row 1 contains the most number of 1s (2 1s). Hence, the output is 1.
Input: arr[][] = [[0,0], [0,0]]
Output: -1
Explanation: No row contains any 1s, so the output is -1. */

import java.util.*;
public class RowWithMax1s{
    public int Max1s(int arr[][])
    {
        int index = -1;
        int maxSum = -1;
        int n = arr.length;
        int m = arr[0].length;

        if(n==0) return -1;

        for(int i=0; i<n; i++) // For Row
        {
            int rowSum = 0;
            for(int j=0; j<m; j++) // For Col
            {
                rowSum += arr[i][j];
            }
            if(rowSum > maxSum)
            {
                maxSum = rowSum;
                index = i;
            }
        }
        return index;
    }
    public static void main(String[] args) {
        int arr[][] = {
            {0, 1, 1, 1}, 
            {0, 0, 1, 1}, 
            {1, 1, 1, 1}, 
            {0, 0, 0, 0}
        };
        
        RowWithMax1s obj = new RowWithMax1s();
        System.out.println("Row with Max 1's is "+obj.Max1s(arr));

    }
}