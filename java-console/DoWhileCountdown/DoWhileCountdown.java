public class DoWhileCountdown {
	public static void main(String[] args) {
		int x = 9;

		do {
			System.out.println(x);
			x = x - 1;
		} while (x >= 4);
	}
}