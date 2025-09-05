import java.util.Scanner;

public class Pyramid {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of input: ");
        int row = sc.nextInt();

        for (int i = 0; i < row; i++) {
            for (int k = row - 1; k > i; k--) {
                    System.out.print(" ");
            }

            for (int j = 0; j <= i; j++) {
                System.out.print("* ");
            }

            System.out.println();
        }

        sc.close();
    }
}