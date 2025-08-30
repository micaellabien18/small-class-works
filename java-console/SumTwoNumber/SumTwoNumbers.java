import java.io.*;
	public class SumTwoNumbers {
		public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

		int num1, num2, sum;

		System.out.print("Input first number: ");
		num1 = Integer.parseInt(reader.readLine());

		System.out.print("Input second number: ");
		num2 = Integer.parseInt(reader.readLine());

		sum = num1 + num2;

		System.out.println("SUM: " + sum);
	}
}