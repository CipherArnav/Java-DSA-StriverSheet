/* A peak element is an element that is strictly greater than its neighbors.
Given a 0-indexed integer array nums, find a peak element, and return its index. If the array contains multiple peaks,
 return the index to any of the peaks.
You may imagine that nums[-1] = nums[n] = -∞. In other words, an element is always considered to be strictly greater
 than a neighbor that is outside the array.

You must write an algorithm that runs in O(log n) time.

Example 1:

Input: nums = [1,2,3,1]
Output: 2
Explanation: 3 is a peak element and your function should return the index number 2.
Example 2:

Input: nums = [1,2,1,3,5,6,4]
Output: 5
Explanation: Your function can return either index number 1 where the peak element is 2, or index number 5 where the peak element is 6. */

import java.util.*;
public class FindPeakElement {
    public int findpeakelement(int[] nums)
    {
        int n = nums.length;
        if(n == 1) return 0; // If there is only 1 element then that element is the peak
        if(nums[0] > nums[1]) return 0; // Checking for 1st element
        if(nums[n-1] > nums[n-2]) return n-1; // Checking for n-1 element

        int low = 1, high = n-2;
        while(low <= high) // Base condition to terminate the loop.
        {
            int mid = (low + high)/2;
            // Checking if mid is peak element or not.
            if(nums[mid] > nums[mid+1] && nums[mid] > nums[mid-1])
            {
                return mid;
            }
            // peak is on right, termiante left side
            if(nums[mid] < nums[mid+1])
            {
                low = mid+1;
            }else if(nums[mid] < nums[mid-1]){  // peakk is on left, termiante right
                high = mid-1;
            }
        }
        return -1;

    }
    public static void main(String[] args) {
        FindPeakElement obj = new FindPeakElement();
        int[] nums = {1,2,3,1,5,4};
        System.out.println("Peak Element Index is "+obj.findpeakelement(nums)); 

    }
    
}
