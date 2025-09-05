import java.util.Arrays;
import java.util.Scanner;

public class DisplayArray {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter array size: ");
        int size = sc.nextInt();

        int[] arr = new int[size];

        for (int i = 0; i < arr.length; i++ ) {
            System.out.print("Enter element: ");
            arr[i] = sc.nextInt();
        }

        System.out.print("Your array: " + Arrays.toString(arr));

        sc.close();
    }
}