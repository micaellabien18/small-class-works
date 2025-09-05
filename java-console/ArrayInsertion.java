import java.util.Arrays;

public class ArrayInsertion {
    public static void main(String[] args) {
        int arr[] = {1, 1, 1, 1, 1, 1};  
        int index = 3;   // position to insert
        int value = 0;   // value to insert

        System.out.println("The original array elements are:\n" + Arrays.toString(arr));

        int newArr[] = new int[arr.length + 1];

        // Copy old array into new array with insertion
        for (int i = 0, j = 0; i < newArr.length; i++) {
            if (i == index) {
                newArr[i] = value;   // insert the new value
            } else {
                newArr[i] = arr[j]; // copy from old array
                j++;
            }
        }

        System.out.println();
        System.out.println("The array elements after insertion:\n" + Arrays.toString(newArr));
    }
}
