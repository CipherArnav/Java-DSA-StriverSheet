/* Given a sorted array of distinct integers and a target value, return the index if the target is found. If not, return the index where it would be if it were inserted in order.

You must write an algorithm with O(log n) runtime complexity.

Example 1:

Input: nums = [1,3,5,6], target = 5
Output: 2
Example 2:

Input: nums = [1,3,5,6], target = 2
Output: 1
Example 3:

Input: nums = [1,3,5,6], target = 7
Output: 4 */

class SearchInsertPosition {
    public int searchInsert(int[] nums, int target) {
        int n = nums.length;
        int low = 0, high = n-1;
        int result = n;
        
        while(low <= high)
        {
            int mid = (low + high)/2;
            if(nums[mid] >= target)
            {
                result = mid;
                high = mid - 1;
            }else {
                low = mid + 1;
            }

        }
        return result;
    }
    public static void main(String[] args) {
        SearchInsertPosition obj = new SearchInsertPosition();
        int[] nums = {2,4,6,11,14,19,22};
        int target = 12;
        System.out.println("Index of Insertion or Target Element is at Index "+ obj.searchInsert(nums, target));
    }
}
