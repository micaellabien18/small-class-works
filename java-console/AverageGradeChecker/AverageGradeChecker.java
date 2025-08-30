import java.io.*;

public class AverageGradeChecker {
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String x;

		float ave, math, science;

		System.out.print("Input Math Grade: ");
		x = reader.readLine();
		math = Float.parseFloat(x);

		System.out.print("Input Science Grade: ");
		x = reader.readLine();
		science = Float.parseFloat(x);

		ave = (math + science) / 2;
		System.out.println();
		System.out.println("The average is:	" + ave);

		if (ave >= 75) {
			System.out.println("Remarks: Passed");
		} else if (ave <= 74.5) {
			System.out.println("Remarks: Failed");
		}
	}
}