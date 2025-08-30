import java.io.*;

public class DisplayUserDetails {
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

		System.out.print("Enter your name: ");
		String name = reader.readLine();

		System.out.print("Enter your age: ");
		int age = Integer.parseInt(reader.readLine());

		System.out.print("Enter your gender: ");
		String gender = reader.readLine();

		System.out.println("\nUser Details");
		System.out.println("Name: " + name);
		System.out.println("Age: " + age);
		System.out.println("Gender: " + gender);
	}
}