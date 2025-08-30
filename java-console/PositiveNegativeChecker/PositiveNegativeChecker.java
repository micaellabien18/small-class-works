import java.io.*;

public class PositiveNegativeChecker {
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

		System.out.print("Enter a number: ");
		int num = Integer.parseInt(reader.readLine());

		String result;

		if (num > 0) {
			result = "Positive";
		} else if (num < 0) {
			result = "Negative";
		} else {
			result = "Zero";
		}

		System.out.println("Result: " + result);
	}
}
