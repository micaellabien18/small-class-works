import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class MatrixMultiplicationComparison {

    // Single-threaded multiplication
    public static int[][] multiply(int[][] matrixA, int[][] matrixB) {
        int rowsA = matrixA.length;
        int colsA = matrixA[0].length;
        int colsB = matrixB[0].length;

        int[][] result = new int[rowsA][colsB];

        for (int i = 0; i < rowsA; i++) {
            for (int j = 0; j < colsB; j++) {
                for (int k = 0; k < colsA; k++) {
                    result[i][j] += matrixA[i][k] * matrixB[k][j];
                }
            }
        }
        return result;
    }

    // Multi-threaded multiplication
    public static int[][] multiplyMultithreaded(int[][] matrixA, int[][] matrixB, int numThreads) {
        int rowsA = matrixA.length;
        int colsA = matrixA[0].length;
        int colsB = matrixB[0].length;

        int[][] result = new int[rowsA][colsB];

        ExecutorService executor = Executors.newFixedThreadPool(numThreads);

        for (int i = 0; i < rowsA; i++) {
            final int row = i;
            executor.submit(() -> {
                for (int j = 0; j < colsB; j++) {
                    for (int k = 0; k < colsA; k++) {
                        result[row][j] += matrixA[row][k] * matrixB[k][j];
                    }
                }
            });
        }

        // Shutdown and wait for tasks to finish
        executor.shutdown();
        try {
            if (!executor.awaitTermination(1, TimeUnit.MINUTES)) {
                executor.shutdownNow();
            }
        } catch (InterruptedException e) {
            executor.shutdownNow();
        }

        return result;
    }

    // Helper method to print matrices
    public static void printMatrix(int[][] matrix) {
        for (int[] row : matrix) {
            for (int value : row) {
                System.out.print(value + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int[][] matrixA = {{1, 2}, {3, 4}};
        int[][] matrixB = {{5, 6}, {7, 8}};
        int numThreads = 2;

        // Measure single-threaded execution time
        long startTimeSingle = System.currentTimeMillis();
        int[][] resultSingle = multiply(matrixA, matrixB);
        long executionTimeSingle = System.currentTimeMillis() - startTimeSingle;

        System.out.println("Single-Thread Result:");
        printMatrix(resultSingle);
        System.out.println("Single-Thread Execution Time: " + executionTimeSingle + " ms");

        // Measure multi-threaded execution time
        long startTimeMulti = System.currentTimeMillis();
        int[][] resultMulti = multiplyMultithreaded(matrixA, matrixB, numThreads);
        long executionTimeMulti = System.currentTimeMillis() - startTimeMulti;

        System.out.println("\nMultithread Result:");
        printMatrix(resultMulti);
        System.out.println("Multithread Execution Time: " + executionTimeMulti + " ms");
    }
}
