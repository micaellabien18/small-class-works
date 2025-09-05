import java.io.*;

public class EvenOddChecker {
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

		System.out.print("Input a number: ");
		String x = reader.readLine();
		int num = Integer.parseInt(x);

		if (num % 2 == 0) {
			System.out.println("Result: Even number");
		} else {
			System.out.println("Result: Odd number");
		}
	}
}
