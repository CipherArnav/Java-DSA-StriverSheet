/* A peak element in a 2D grid is an element that is strictly greater than all of its adjacent neighbors
to the left, right, top, and bottom.
Given a 0-indexed m x n matrix mat where no two adjacent cells are equal, find any peak element mat[i][j] and return 
the length 2 array [i,j].
You may assume that the entire matrix is surrounded by an outer perimeter with the value -1 in each cell.
You must write an algorithm that runs in O(m log(n)) or O(n log(m)) time.

Example 1:
Input: mat = [[1,4],[3,2]]
Output: [0,1]
Explanation: Both 3 and 4 are peak elements so [1,0] and [0,1] are both acceptable answers.

Example 2:
Input: mat = [[10,20,15],[21,30,14],[7,16,32]]
Output: [1,1]
Explanation: Both 30 and 32 are peak elements so [1,1] and [2,2] are both acceptable answers. 
*/

import java.util.*;
class FindAPeakElement2 {
    public int[] findPeakGrid(int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;
        
        int low = 0, high = m - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            int row = maxElement(mat, n, mid); // Find row index of max in column
            // Handling boundary conditions explicitly
            int left, right;
            if (mid - 1 >= 0) {
                left = mat[row][mid - 1];  // Valid left neighbor
            } else {
                left = -1;  // No left neighbor
            }

            if (mid + 1 < m) {
                right = mat[row][mid + 1];  // Valid right neighbor
            } else {
                right = -1;  // No right neighbor
            }

            if (mat[row][mid] > left && mat[row][mid] > right) {
                return new int[]{row, mid};  // Found peak
            } else if (mat[row][mid] < left) {
                high = mid - 1; // Move left
            } else {
                low = mid + 1; // Move right
            }
        }
        return new int[]{-1, -1}; // No peak found
    }

    // Function to find row index of max element in given column
    private int maxElement(int[][] mat, int n, int col) {
        int maxRow = 0;
        for (int i = 1; i < n; i++) {
            if (mat[i][col] > mat[maxRow][col]) {
                maxRow = i;
            }
        }
        return maxRow;
    }
    public class Solution {
        public int[] findPeakGrid(int[][] mat) {
            int n = mat.length;
            int m = mat[0].length;
    
            int low = 0, high = m - 1;
            while (low <= high) {
                int mid = (low + high) / 2;
                int row = maxElement(mat, n, mid);
    
                int left, right;
                if (mid - 1 >= 0) {
                    left = mat[row][mid - 1];
                } else {
                    left = -1;
                }
    
                if (mid + 1 < m) {
                    right = mat[row][mid + 1];
                } else {
                    right = -1;
                }
    
                if (mat[row][mid] > left && mat[row][mid] > right) {
                    return new int[]{row, mid};
                } else if (mat[row][mid] < left) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            }
            return new int[]{-1, -1};
        }
    
        private int maxElement(int[][] mat, int n, int col) {
            int maxRow = 0;
            for (int i = 1; i < n; i++) {
                if (mat[i][col] > mat[maxRow][col]) {
                    maxRow = i;
                }
            }
            return maxRow;
        }
    }
    public static void main(String[] args) {
        FindAPeakElement2 sol = new FindAPeakElement2();

        int[][] mat = {
            {1, 4, 3},
            {6, 7, 8},
            {2, 9, 5}
        };

        int[] result = sol.findPeakGrid(mat);
        System.out.println("Peak found at: [" + result[0] + ", " + result[1] + "]");
    }
    
}
