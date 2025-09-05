import java.io.*;

public class BankInterest {
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String x;

		float amt, yrs, rate, interest;

		System.out.print("Input Amount: ");
		x = reader.readLine();
		amt = Float.parseFloat(x);

		System.out.print("Input Years: ");
		x = reader.readLine();
		yrs = Float.parseFloat(x);

		System.out.print("Input Rate: ");
		x = reader.readLine();
		rate = Float.parseFloat(x);

		interest = (amt * yrs * rate) / 100;
		System.out.println();
		System.out.println("The interest is: " + interest);
	}
}
