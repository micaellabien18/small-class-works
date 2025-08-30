import java.io.*;

public class HCFCalculator {
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

		System.out.print("Enter first number: ");
		int num1 = Integer.parseInt(reader.readLine());

		System.out.print("Enter second number: ");
		int num2 = Integer.parseInt(reader.readLine());

		int hcf = 1;
		for(int i = 1; i <= num1 && i <= num2; i++) {
			if(num1 % i == 0 && num2 % i == 0)
			hcf = i;
		}
		
		System.out.println();
		System.out.println("HCF of given two numbers is: " + hcf);
	}
}