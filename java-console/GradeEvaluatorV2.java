import java.util.Scanner;

public class GradeEvaluatorV2 {
    public static String getRemark(double gpa) {
        if (gpa >= 100) {
            return "Outstanding";
        } else if (gpa >= 90) {
            return "Excellent";
        } else if (gpa >= 80) {
            return "Good";
        } else if (gpa >= 70) {
            return "Average";
        } else {
            return "Fail";
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter your name: ");
        String name = sc.nextLine();

        System.out.print("Enter your grade in Math: ");
        double math = sc.nextDouble();

        System.out.print("Enter your grade in Filipino: ");
        double filipino = sc.nextDouble();

        System.out.print("Enter your grade in English: ");
        double english = sc.nextDouble();

        System.out.print("Enter your grade in Science: ");
        double science = sc.nextDouble();

        System.out.print("Enter your grade in P.E.: ");
        double pe = sc.nextDouble();

        double gpa = (math + filipino + english + science + pe) / 5;

        System.out.printf("%n%s, here's the result.%n", name);
        System.out.printf("Your GPA is %.1f%n", gpa);
        System.out.println(getRemark(gpa));

        sc.close();
    }
}