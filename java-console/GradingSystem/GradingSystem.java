import java.util.Scanner;

// Class representing a student
class Student {
    private String firstName, lastName, section;

    public Student(String firstName, String lastName, String section) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.section = section;
    }

    public String getFullName() {
        return firstName + " " + lastName;
    }

    public String getSection() {
        return section;
    }
}

// Class representing the grade computation (Prelim, Midterm, Final, Semestral)
class GradeCalculator {
    private double classStanding, finalGrade;

    public GradeCalculator(int attendance, int quiz, int recitation, int project, int exam) {
        this.classStanding = (attendance + quiz + recitation + project) / 4.0;
        this.finalGrade = (classStanding + exam) / 2.0;
    }

    public double getFinalGrade() {
        return finalGrade;
    }

    public String getPointEquivalent() {
        if (finalGrade >= 96) return "1.00";
        else if (finalGrade >= 93) return "1.25";
        else if (finalGrade >= 91) return "1.50";
        else if (finalGrade >= 88) return "1.75";
        else if (finalGrade >= 86) return "2.00";
        else if (finalGrade >= 84) return "2.25";
        else if (finalGrade >= 80) return "2.50";
        else if (finalGrade >= 78) return "2.75";
        else if (finalGrade >= 74) return "3.00";
        else return "5.00";
    }

    public String getRemarks() {
        return finalGrade >= 75 ? "Passed" : "Failed";
    }
}

public class GradingSystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        char ans;

        do {
            System.out.println("************** Grading System ***************");

            System.out.print("Enter Last Name: ");
            String lastName = sc.nextLine();

            System.out.print("Enter First Name: ");
            String firstName = sc.nextLine();

            System.out.print("Enter Section: ");
            String section = sc.nextLine();

            Student student = new Student(firstName, lastName, section);

            System.out.println("\n********* Preliminary Grades *********");
            GradeCalculator prelim = inputGrades(sc, "Prelim");

            System.out.println("\n*********** Midterm Grades ***********");
            GradeCalculator midterm = inputGrades(sc, "Midterm");

            System.out.println("\n************ Final Grades ************");
            GradeCalculator finals = inputGrades(sc, "Final");

            double semestralGrade = (prelim.getFinalGrade() + midterm.getFinalGrade() + finals.getFinalGrade()) / 3.0;

            System.out.println("\n************** STUDENT REPORT **************");
            System.out.println("Name: " + student.getFullName());
            System.out.println("Section: " + student.getSection());

            printGrade("Prelim", prelim);
            printGrade("Midterm", midterm);
            printGrade("Final", finals);

            System.out.printf("\nSemestral Grade: %.2f\n", semestralGrade);
            System.out.println("Point: " + getPointEquivalent(semestralGrade));
            System.out.println("Remarks: " + (semestralGrade >= 75 ? "Passed" : "Failed"));

            System.out.println("********************************************");

            System.out.print("\nDo you want to enter another student? [y/n]: ");
            ans = sc.next().charAt(0);
            sc.nextLine();

        } while (ans == 'y' || ans == 'Y');

        sc.close();
    }

    // Helper to input grades
    private static GradeCalculator inputGrades(Scanner sc, String term) {
        System.out.print("Input Attendance: ");
        int attendance = sc.nextInt();

        System.out.print("Input Quiz: ");
        int quiz = sc.nextInt();

        System.out.print("Input Recitation: ");
        int recitation = sc.nextInt();

        System.out.print("Input Project: ");
        int project = sc.nextInt();

        System.out.print("Input " + term + " Exam: ");
        int exam = sc.nextInt();

        sc.nextLine();
        return new GradeCalculator(attendance, quiz, recitation, project, exam);
    }

    // Helper to print grades
    private static void printGrade(String term, GradeCalculator grade) {
        System.out.printf("\n%s Grade: %.2f%n", term, grade.getFinalGrade());
        System.out.println("Point: " + grade.getPointEquivalent());
        System.out.println("Remarks: " + grade.getRemarks());
    }

    // Helper to get point equivalent
    private static String getPointEquivalent(double grade) {
    if (grade >= 96) return "1.00";
    else if (grade >= 93) return "1.25";
    else if (grade >= 91) return "1.50";
    else if (grade >= 88) return "1.75";
    else if (grade >= 86) return "2.00";
    else if (grade >= 84) return "2.25";
    else if (grade >= 80) return "2.50";
    else if (grade >= 78) return "2.75";
    else if (grade >= 74) return "3.00";
    else return "5.00";
}

}