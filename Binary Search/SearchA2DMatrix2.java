/* Write an efficient algorithm that searches for a value target in an m x n integer matrix matrix. 
This matrix has the following properties:

Integers in each row are sorted in ascending from left to right.
Integers in each column are sorted in ascending from top to bottom.
 

Example 1: 
Input: matrix = [[1,4,7,11,15],[2,5,8,12,19],[3,6,9,16,22],[10,13,14,17,24],[18,21,23,26,30]], target = 5
Output: true

Example 2:
Input: matrix = [[1,4,7,11,15],[2,5,8,12,19],[3,6,9,16,22],[10,13,14,17,24],[18,21,23,26,30]], target = 20
Output: false

*/
class SearchA2DMatrix2 {
    public boolean searchMatrix(int[][] matrix, int target) {
        int n = matrix.length, m = matrix[0].length;
        int row = 0, col = m-1;
        while(row < n && col >= 0 )
        {
            if(matrix[row][col] == target)
            {
                return true;
            }else if(matrix[row][col] < target)
            {
                row++;
            }else {
                col--;
            }
        }
        return false;

    }

    public static void main(String[] args) {
                SearchA2DMatrix2 obj = new SearchA2DMatrix2();
                
                int[][] matrix = {
                    {1, 4, 7, 11},
                    {2, 5, 8, 12},
                    {3, 6, 9, 16},
                    {10, 13, 14, 17}
                };
        
                int target = 5;
        
                boolean result = obj.searchMatrix(matrix, target);
                System.out.println("Target found: " + result);  // true (for boolean return)
    }
}