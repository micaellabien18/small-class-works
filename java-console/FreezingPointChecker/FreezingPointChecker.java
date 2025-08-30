import java.io.*;

public class FreezingPointChecker {
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

		System.out.print("Input a Temperature: ");
		String x = reader.readLine();
		int temperature = Integer.parseInt(x);

		if (temperature <= 32) {
			System.out.println("Result: Below Freezing Point");
		} else {
			System.out.println("Result: Above Freezing Point");
		}
	}
}
