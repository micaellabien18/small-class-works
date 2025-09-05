import java.util.Scanner;

public class BasicCalculatorV3 {
    public static void calculator(double num1, double num2, char choice) {
        double sum = num1 + num2;
        double diff = num1 - num2;
        double prod = num1 * num2;
        double quo = num1 / num2;
        double rem = num1 % num2;

        switch (choice) {
            case 'A':
                System.out.printf("The sum is: %.2f", sum);
                break;
            case 'B':
                System.out.printf("The difference is: %.2f", diff);
                break;
            case 'C':
                System.out.printf("The product is: %.2f", prod);
                break;
            case 'D':
                if (num2 == 0) {
                    System.out.println("Division by zero is not allowed.");
                } else {
                    System.out.printf("The quotient is: %.2f", quo);
                }
                break;
            case 'E':
                if (num2 == 0) {
                    System.out.println("Modulo by zero is not allowed.");
                } else {
                    System.out.printf("The remainder is: %.2f", rem);
                }
                break;
            default:
                System.out.println("Invalid choice.");
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter first number: ");
        double num1 = sc.nextDouble();

        System.out.print("Enter second number: ");
        double num2 = sc.nextDouble();

        System.out.println("\nChoices");
        System.out.println("A - Addition");
        System.out.println("B - Subtraction");
        System.out.println("C - Multiplication");
        System.out.println("D - Division");
        System.out.println("E - Modulo\n");

        System.out.print("Enter choice: ");
        char choice = Character.toUpperCase(sc.next().charAt(0));

        System.out.println();
        calculator(num1, num2, choice);

        sc.close();
    }
}