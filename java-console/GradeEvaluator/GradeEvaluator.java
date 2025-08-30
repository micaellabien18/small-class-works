import java.io.*;

public class GradeEvaluator {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String x;

        System.out.print("Input first grade: ");
        x = reader.readLine();
        float g1 = Float.parseFloat(x);

        System.out.print("Input second grade: ");
        x = reader.readLine();
        float g2 = Float.parseFloat(x);

        float ave = (g1 + g2) / 2;
		System.out.println();
        System.out.println("The Average is: " + ave);

        String equivalent;
        boolean passed;

        if (ave >= 98 && ave <= 100) {
            equivalent = "Excellent";
            passed = true;
        } else if (ave >= 94 && ave < 98) {
            equivalent = "Very Good";
            passed = true;
        } else if (ave >= 90 && ave < 94) {
            equivalent = "Good";
            passed = true;
        } else if (ave >= 85 && ave < 90) {
            equivalent = "Very Satisfactory";
            passed = true;
        } else if (ave >= 80 && ave < 85) {
            equivalent = "Satisfactory";
            passed = true;
        } else if (ave >= 75 && ave < 80) {
            equivalent = "Needs Improvement";
            passed = true;
        } else if (ave >= 70 && ave < 75) {
            equivalent = "Poor";
            passed = false;
        } else {
            equivalent = "Failing";
            passed = false;
        }

        System.out.println("Equivalent: " + equivalent);
        System.out.println("Remarks: " + (passed ? "Passed" : "Failed"));
    }
}