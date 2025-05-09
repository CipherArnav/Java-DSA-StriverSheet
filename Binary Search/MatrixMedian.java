/* Given a row-wise sorted matrix where the number of rows and columns is always odd, find the median of the matrix.
Examples:
Input: mat = [[1, 3, 5], [2, 6, 9], [3, 6, 9]]
Output: 5
Explanation: Sorting matrix elements gives us {1,2,3,3,5,6,6,9,9}. Hence, 5 is median. 

Input: mat = [[1], [2], [3]]
Output: 2
Explanation: Sorting matrix elements gives us {1,2,3}. Hence, 2 is median

Input: mat = [[3], [5], [8]]
Output: 5
Explanation: Sorting matrix elements gives us {3,5,8}. Hence, 5 is median. */

import java.util.*;
public class MatrixMedian{
    int median(int mat[][]) {
        int m = mat.length;       // number of rows
        int n = mat[0].length;    // number of columns
        
        List<Integer> list = new ArrayList<>();  // to store all elements

        // Flatten the matrix into the list
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                list.add(mat[i][j]);
            }
        }

        Collections.sort(list);   // sort the list

        // return the middle element (median)
        return list.get(list.size() / 2);
    }
    public static void main(String[] args) {
        MatrixMedian obj = new MatrixMedian();
        int[][] mat = {
            {1,3,5},
            {2,6,9},
            {3,6,9}
        };
        int result = obj.median(mat);
        System.out.println("The median of the given matrix is: "+result);

    }
}