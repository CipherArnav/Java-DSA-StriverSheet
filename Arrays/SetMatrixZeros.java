import java.util.Arrays;

class SetMatrixZeros {
    public void setZeroes(int[][] matrix) {
        int n = matrix.length;       // Number of rows
        int m = matrix[0].length;    // Number of columns

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (matrix[i][j] == 0) {
                    markrow(matrix, i, m);
                    markcol(matrix, j, n);
                }
            }
        }

        // Replace all marked (-1) elements with 0
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (matrix[i][j] == -1) {
                    matrix[i][j] = 0;
                }
            }
        }
    }

    public void markrow(int[][] matrix, int i, int m) {
        for (int j = 0; j < m; j++) {
            if (matrix[i][j] != 0) {
                matrix[i][j] = -1;
            }
        }
    }

    public void markcol(int[][] matrix, int j, int n) {
        for (int i = 0; i < n; i++) {
            if (matrix[i][j] != 0) {
                matrix[i][j] = -1;
            }
        }
    }

    // Main method for testing
    public static void main(String[] args) {
        SetMatrixZeros solution = new SetMatrixZeros();

        int[][] matrix = {
            {1, 2, 3},
            {4, 0, 6},
            {7, 8, 9}
        };

        System.out.println("Original Matrix:");
        printMatrix(matrix);

        solution.setZeroes(matrix);

        System.out.println("\nMatrix after applying setZeroes:");
        printMatrix(matrix);
    }

    // Helper function to print the matrix
    public static void printMatrix(int[][] matrix) {
        for (int[] row : matrix) {
            System.out.println(Arrays.toString(row));
        }
    }
}
