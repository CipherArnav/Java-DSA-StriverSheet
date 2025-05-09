/* You are given an m x n integer matrix matrix with the following two properties:

Each row is sorted in non-decreasing order.
The first integer of each row is greater than the last integer of the previous row.
Given an integer target, return true if target is in matrix or false otherwise.

You must write a solution in O(log(m * n)) time complexity.

 

Example 1:
Input: matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 3
Output: true

Example 2:
Input: matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 13
Output: false
 */

 import java.util.*;
 class SearchA2DMatrix {
    public boolean searchMatrix(int[][] matrix, int target) {
        int n = matrix.length;
        int m = matrix[0].length;
        for(int i=0; i<n; i++)
        {
            if(matrix[i][0] <= target && target <= matrix[i][m-1])
            {
                return BinarySearch(matrix[i], target);
            }
        }
        return false;
    }
    public boolean BinarySearch(int[] row, int target)
    {
        int low = 0, high = row.length-1;
        while(low <= high)
        {
            int mid = (low + high) / 2;
            if(row[mid] == target) return true;
            if(target < row[mid])
            {
                high = mid - 1;
            }else if(target > row[mid])
            {
                low = mid + 1;
            }
        }
        return false;
    }
        public static void main(String[] args) {
            SearchA2DMatrix obj = new SearchA2DMatrix();
            
            int[][] matrix = {
                {1, 3, 5, 7},
                {10, 11, 16, 20},
                {23, 30, 34, 60}
            };
    
            int target1 = 3;
            int target2 = 13;
    
            System.out.println("Searching for " + target1 + ": " + obj.searchMatrix(matrix, target1)); // true
            System.out.println("Searching for " + target2 + ": " + obj.searchMatrix(matrix, target2)); // false
        }
    }
    
