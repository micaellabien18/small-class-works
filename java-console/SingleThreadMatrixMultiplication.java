public class SingleThreadMatrixMultiplication {

    public static int[][] multiply(int[][] matrixA, int[][] matrixB) {
        // Validate dimensions
        if (matrixA[0].length != matrixB.length) {
            throw new IllegalArgumentException(
                "Number of columns in Matrix A must equal number of rows in Matrix B"
            );
        }

        int rowsA = matrixA.length;
        int colsA = matrixA[0].length;
        int colsB = matrixB[0].length;

        int[][] result = new int[rowsA][colsB];

        // Perform multiplication
        for (int i = 0; i < rowsA; i++) {
            for (int j = 0; j < colsB; j++) {
                for (int k = 0; k < colsA; k++) {
                    result[i][j] += matrixA[i][k] * matrixB[k][j];
                }
            }
        }

        return result;
    }

    public static void printMatrix(int[][] matrix) {
        for (int[] row : matrix) {
            for (int value : row) {
                System.out.printf("%6d", value); // formatted output
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int[][] matrixA = {
            {1, 2},
            {3, 4}
        };

        int[][] matrixB = {
            {5, 6},
            {7, 8}
        };

        System.out.println("Matrix A:");
        printMatrix(matrixA);

        System.out.println("\nMatrix B:");
        printMatrix(matrixB);

        int[][] result = multiply(matrixA, matrixB);

        System.out.println("\nSingle-Thread Result:");
        printMatrix(result);
    }
}
