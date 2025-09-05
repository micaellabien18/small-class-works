public class QuickSort {

    public static void main(String[] args) {
        // Convert command line arguments to int array
        int[] array = new int[args.length];
        for (int i = 0; i < args.length; i++) {
            array[i] = Integer.parseInt(args[i]);
        }

        // Perform QuickSort
        quickSort(array, 0, array.length - 1);

        // Print sorted array
        for (int num : array) {
            System.out.print(num + " ");
        }
        System.out.println(); // newline
    }

    // QuickSort algorithm
    public static void quickSort(int[] array, int low, int high) {
        if (low < high) {
            int pivotIndex = partition(array, low, high);

            // Recursively sort left and right partitions
            quickSort(array, low, pivotIndex - 1);
            quickSort(array, pivotIndex + 1, high);
        }
    }

    // Partition method (Lomuto partition scheme)
    private static int partition(int[] array, int low, int high) {
        int pivot = array[high]; // choose last element as pivot
        int i = low - 1;         // index of smaller element

        for (int j = low; j < high; j++) {
            if (array[j] < pivot) {
                i++;
                swap(array, i, j);
            }
        }

        swap(array, i + 1, high);
        return i + 1; // return the partition index
    }

    // Utility method for swapping
    private static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}