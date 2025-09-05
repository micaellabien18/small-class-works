import java.io.*;

public class ConditionalIncrement {
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String x;

		int num;

		System.out.print("Input a number: ");
		x = reader.readLine();
		num = Integer.parseInt(x);

		System.out.println();

		if (num >= 10) {
			num = num + 5;
			System.out.println("Your number is greater than 10: " + num);
		} else {
			System.out.println("It's not greater than 10!: " + num);
		}
	}
}