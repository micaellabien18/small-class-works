import java.util.Scanner;

public class BasicCalculatorV2 {
    static double num1, num2;

    public static double add() {
        return num1 + num2;
    }
    
    public static double subt() {
        return num1 - num2;
    }

    public static double mult() {
        return num1 * num2;
    } 

    public static double div() {
        return num1 / num2;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Input first number: ");
        num1 = sc.nextDouble();

        System.out.print("Input second number: ");
        num2 = sc.nextDouble();

        System.out.println("\nAdd: " + add());
        System.out.println("Subtract: " + subt());
        System.out.println("Multiply: " + mult());
        System.out.println("Divide: " + div());

        sc.close();
    }
}