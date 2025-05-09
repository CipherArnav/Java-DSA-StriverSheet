/* You are given a sorted array consisting of only integers where every element appears exactly twice, except for one element which appears exactly once.

Return the single element that appears only once.

Your solution must run in O(log n) time and O(1) space.

 

Example 1:

Input: nums = [1,1,2,3,3,4,4,8,8]
Output: 2
Example 2:

Input: nums = [3,3,7,7,10,11,11]
Output: 10 */

import java.util.*;
public class SingleElementInASortedArray {
    public int singleNonDuplicate(int[] nums) {
        int n = nums.length;
        if(n==1) return nums[0]; // Checking if there is only 1 element present.
        if(nums[0] != nums[1]) return nums[0]; // Checking if single element is present at starting.
        if(nums[n-1] != nums[n-2]) return nums[n-1]; // Checking if last element is single or not.

        int left = 1, right = n-2;
        while(left <= right)
        {
            int mid = (left + right)/2;
            /* Checking is the "mid" element is single or not. */
            if(nums[mid] != nums[mid-1] && nums[mid] != nums[mid+1]) return nums[mid]; 
            // Standing on the left half 
            if(mid % 2 == 0 && nums[mid] == nums[mid+1] || mid % 2 == 1 && nums[mid] == nums[mid-1])
            {
                // Eliminate the left half
                left = mid + 1;
            }else{
                right = mid - 1;
            }
        }
        return -1;
    }
    public static void main(String[] args) {
        SingleElementInASortedArray object = new SingleElementInASortedArray();
        int[] arr = {1,1,2,2,4,4,5,6,6};
        System.out.println(object.singleNonDuplicate(arr));
    }
    
}
