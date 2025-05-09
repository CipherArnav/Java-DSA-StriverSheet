import java.util.ArrayList;
import java.util.List;

class PrintTheMatrixInSpiralManner {
    public List<Integer> spiralOrder(int[][] matrix) {

        int n = matrix.length; // Number of rows
        int m = matrix[0].length; // Number of columns

        int left = 0, right = m - 1; // Left and right boundaries
        int top = 0, bottom = n - 1; // Top and bottom boundaries

        ArrayList<Integer> spiralOrderList = new ArrayList<>(); // List to store the result

        while (top <= bottom && left <= right) {
            // Traverse from left to right along the top row
            for (int i = left; i <= right; i++)
                spiralOrderList.add(matrix[top][i]);
            top++; // Move the top boundary down

            // Traverse from top to bottom along the right column
            for (int i = top; i <= bottom; i++)
                spiralOrderList.add(matrix[i][right]);
            right--; // Move the right boundary left

            // Traverse from right to left along the bottom row (if it exists)
            if (top <= bottom) {
                for (int i = right; i >= left; i--)
                    spiralOrderList.add(matrix[bottom][i]);
                bottom--; // Move the bottom boundary up
            }

            // Traverse from bottom to top along the left column (if it exists)
            if (left <= right) {
                for (int i = bottom; i >= top; i--)
                    spiralOrderList.add(matrix[i][left]);
                left++; // Move the left boundary right
            }
        }

        return spiralOrderList; // Return the spiral order list
    }

    // Main function to test the code
    public static void main(String[] args) {
        PrintTheMatrixInSpiralManner solution = new PrintTheMatrixInSpiralManner(); 

        int[][] matrix = {
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9}
        };

        // Get the spiral order
        List<Integer> result = solution.spiralOrder(matrix);

        // Print the result
        System.out.println("Spiral Order: " + result);
    }
}
