import java.util.Scanner;

public class RoomArea {
    public static double computeArea(double length, double width) {
        return length * width;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double length, width;

        System.out.print("Enter room length: ");
        length = sc.nextDouble();

        System.out.print("Enter room width: ");
        width = sc.nextDouble();

        System.out.printf("The floor space of the room is %.2f square feet", computeArea(length, width));

        sc.close();
    }
} 