/* Given an array of integers nums and an integer threshold, we will choose a positive integer divisor, divide 
all the array by it, and sum the division's result. Find the smallest divisor such that the result mentioned 
\above is less than or equal to threshold.

Each result of the division is rounded to the nearest integer greater than or equal to that element. 
(For example: 7/3 = 3 and 10/2 = 5).
The test cases are generated so that there will be an answer.

Example 1:

Input: nums = [1,2,5,9], threshold = 6
Output: 5
Explanation: We can get a sum to 17 (1+2+5+9) if the divisor is 1. 
If the divisor is 4 we can get a sum of 7 (1+1+2+3) and if the divisor is 5 the sum will be 5 (1+1+1+2). 
Example 2:

Input: nums = [44,22,33,11,1], threshold = 5
Output: 44 
*/

import java.util.*;

public class SmallestDivisorGivenAThreshold{
    public static int GetCeilingSum(int[] nums, int divisor)
    {
        int n = nums.length;
        int sum = 0;
        // Iterate through the array to compute the sum
        for(int i=0; i<n; i++)
        {
            sum += Math.ceil((double)(nums[i]) / (double)(divisor)); // // Round up division result and add to sum
        }
        return sum;
    }
    // Function to find the smallest divisor such that the sum does not exceed the threshold
    public int smallestDivisor(int[] nums, int threshold) {
        int n = nums.length;
        // If the number of elements is greater than the threshold, return -1
        // (It's impossible to get a valid divisor in this case)
        if(n > threshold) return -1; 

        // Now find the maximum element in the given array.
        int MaxElement = Integer.MIN_VALUE;
        for(int i=0; i<n; i++)
        {
            MaxElement = Math.max(MaxElement,nums[i]); // // Get the maximum value in the array
        }
        int low = 1, high = MaxElement;
        while(low <= high) 
        {
            int mid = (low + high) / 2;
            if(GetCeilingSum(nums, mid) <= threshold)
            {
                high = mid - 1;
            }else{
                low = mid + 1;
            }
        }
        return low; // When the loop exits, 'low' points to the smallest valid divisor
        
    }
    public static void main(String[] args) {
        SmallestDivisorGivenAThreshold obj = new SmallestDivisorGivenAThreshold();
        int [] nums = {1,2,5,9};
        int threshold = 6;
        System.out.println("Smallest divisor for a given Threshold is "+obj.smallestDivisor(nums, threshold));
    }
}