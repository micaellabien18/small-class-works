import java.util.Arrays;

public class ArrayEndInsertion {
    public static void main(String[] args) {
        int[] arr = {1, 1, 1, 1, 1, 1};
        int value = 0; // value to insert at the end

        // Create new array with one extra slot
        int[] newArr = new int[arr.length + 1];

        // Copy old array elements into new array
        for (int i = 0; i < arr.length; i++) {
            newArr[i] = arr[i];
        }

        // Insert new value at the end
        newArr[arr.length] = value;

        // Print results
        System.out.println("The original array elements are:\n" + Arrays.toString(arr));
        System.out.println("\nThe array elements after insertion:\n" + Arrays.toString(newArr));
    }
}
