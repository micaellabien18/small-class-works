import java.io.*;

public class HighestLowest {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        System.out.print("Input first number: ");
        int num1 = Integer.parseInt(reader.readLine());

        System.out.print("Input second number: ");
        int num2 = Integer.parseInt(reader.readLine());

        System.out.print("Input third number: ");
        int num3 = Integer.parseInt(reader.readLine());

        int highest = num1;
        if (num2 > highest) {
            highest = num2;
        }
        if (num3 > highest) {
            highest = num3;
        }

        int lowest = num1;
        if (num2 < lowest) {
            lowest = num2;
        }
        if (num3 < lowest) {
            lowest = num3;
        }

		System.out.println();
        System.out.println("The Highest number: " + highest);
        System.out.println("The Lowest number: " + lowest);
    }
}
