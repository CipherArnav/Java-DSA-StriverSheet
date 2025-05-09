/* There is an integer array nums sorted in non-decreasing order (not necessarily with distinct values).
Before being passed to your function, nums is rotated at an unknown pivot index k (0 <= k < nums.length) such that the
resulting array is [nums[k], nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]] (0-indexed).
For example, [0,1,2,4,4,4,5,6,6,7] might be rotated at pivot index 5 and become [4,5,6,6,7,0,1,2,4,4].
Given the array nums after the rotation and an integer target, return true if target is in nums, or false if it is not in
nums.

You must decrease the overall operation steps as much as possible.
Example 1:

Input: nums = [2,5,6,0,0,1,2], target = 0
Output: true
Example 2:

Input: nums = [2,5,6,0,0,1,2], target = 3
Output: false */

import java.util.*;
public class SearchInRotatedSortedArrayII {
    public boolean search(int[] nums, int target)
    {
        int low = 0, high = nums.length - 1;
        while(low <= high)
        {
            int mid = (low + high) / 2;
            if(nums[mid] == target) return true;
            if(nums[low] == nums[mid] && nums[high] == nums[mid])
            {
                low = low + 1;
                high = high - 1;
                continue;
            }
            if(nums[low] <= nums[mid]) // Left half is sorted.
            {
                if(nums[low] <= target && target < nums[mid]) // Checking is target is present in sorted left.
                {
                    high = mid - 1; // Search in left half.
                }else {
                    low  = mid + 1; // Search in right half.
                }
            }else {  // Right half is sorted.
                if(nums[mid] < target && target <= nums[high]) // Checking if target is present in sorted right.
                {
                    low = mid + 1; // Search in right half.
                }else {
                    high = mid - 1; // Search in left half.
                }
            }
        }
        return false;
    }
    public static void main(String[] args) {
        int [] nums = {2,5,6,0,0,1,2};
        int target = 6;
        SearchInRotatedSortedArrayII obj = new SearchInRotatedSortedArrayII();
        System.out.println(obj.search(nums, target));
    }
    
}
