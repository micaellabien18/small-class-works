import java.util.Scanner;

public class SelectionMenu {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		char choice, answer;

		do {
			System.out.println("Menu");
			System.out.println("a. Apple");
			System.out.println("b. Banana");
			System.out.println("c. Caimito");
			System.out.println("d. Duhat");
			System.out.println("e. Eggplant");

			System.out.print("\nSelect Your Choice: ");
			choice = scanner.next().charAt(0);

			switch (choice) {
				case 'a':
					System.out.println("Apple is Red");
					break;
				case 'b':
					System.out.println("Banana is Yellow");
					break;
				case 'c':
					System.out.println("Caimito is Purple ");
					break;
				case 'd':
					System.out.println("Duhat is Purple Red");
					break;
				case 'e':
					System.out.println("Eggplant is Dark Purple ");
					break;
				default:
					System.out.println("Invalid Choice");
			}

			System.out.print("\nDo you want to select again? [Y/N]: ");
			answer = scanner.next().charAt(0);

		} while (answer == 'Y' || answer == 'y');

		scanner.close();
	}
}