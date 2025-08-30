import java.io.*;

public class ShowConversionFormula {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        double f, c, fah, cel;

        System.out.print("Input temperature in Fahrenheit: ");
        fah = Double.parseDouble(reader.readLine());

        c = (fah - 32) * 5.0 / 9.0;

        System.out.println();
        System.out.println("Fahrenheit to Celsius");
        System.out.println("Formula: (" + fah + "F - 32) * (5/9) = " + c + "C");

        System.out.print("\nInput temperature in Celsius: ");
        cel = Double.parseDouble(reader.readLine());

        f = cel * (9.0 / 5.0) + 32.0;

        System.out.println();
        System.out.println("Celsius to Fahrenheit");
        System.out.println("Formula: (" + cel + "C) * (9/5) + 32 = " + f + "F");
    }
}
