import java.util.Scanner;

public class AreaCircle {
    public static double computeArea(double pi, double radius) {
        return pi * radius * radius;
    }

    public static void main(String[] args){
        final double PI = 3.1416;
        double radius, area;

        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the radius of the circle: ");
        radius = sc.nextDouble();

        area = computeArea(PI, radius);

        System.out.println("The area of the circle is: " + area);

        sc.close();
    }
}