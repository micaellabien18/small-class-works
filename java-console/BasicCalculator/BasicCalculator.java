import java.io.*;

public class BasicCalculator {
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String x;

		float num1, num2, sum, diff, prod, quo;

		System.out.print("Input first number: ");
		x = reader.readLine();
		num1 = Float.parseFloat(x);

		System.out.print("Input second number: ");
		x = reader.readLine();
		num2 = Float.parseFloat(x);

		sum = num1 + num2;
		System.out.println();
		System.out.println("Sum: " + sum);

		diff = num1 - num2;
		System.out.println("Difference: " + diff);

		prod = num1 * num2;
		System.out.println("Product: " + prod);

		quo = num1 / num2;
		System.out.println("Quotient: " + quo);
	}
}
