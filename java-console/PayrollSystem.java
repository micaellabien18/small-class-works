import java.util.*;

class Employee {
    private String id, firstName, lastName, middleName, position, department, status;
    private double monthlySalary, allowance, hourlyRate;

    public Employee(String id, String firstName, String lastName, String middleName,
                    String position, String department, String status,
                    double monthlySalary, double allowance, double hourlyRate) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.middleName = middleName;
        this.position = position;
        this.department = department;
        this.status = status;
        this.monthlySalary = monthlySalary;
        this.allowance = allowance;
        this.hourlyRate = hourlyRate;
    }

    public String getId() { return id; }
    public String getFullName() { return firstName + " " + middleName + " " + lastName; }
    public String getPosition() { return position; }
    public String getDepartment() { return department; }
    public String getStatus() { return status; }
    public double getMonthlySalary() { return monthlySalary; }
    public double getAllowance() { return allowance; }
    public double getHourlyRate() { return hourlyRate; }
}

class PayrollCalculator {
    private static final double LATE_PER_HOUR = 150;
    private static final double LATE_PER_MINUTE = 50;
    private static final double ABSENCE_PER_DAY_HOURS = 8;
    private static final int WORKING_HOURS = 192; // 24 days * 8 hours
    private static final int UNDERTIME_HOURS = 4;
    private static final double OVERTIME_RATE = 350;

    public static double calculateOvertime(double hours) {
        return hours * OVERTIME_RATE;
    }

    public static double[] calculateDeductions(double income, int bracket) {
        double taxRate, sssRate, pagibigRate = 0.01, philhealthRate = 0.01;

        switch (bracket) {
            case 1 -> {
                taxRate = 0.20; // Single
                sssRate = 0.07;
            }
            case 2 -> {
                taxRate = 0.10; // Married
                sssRate = 0.03;
            }
            case 3 -> {
                taxRate = 0.08; // Widow
                sssRate = 0.02;
            }
            default -> {
                taxRate = 0.20; // Single as default
                sssRate = 0.07;
            }
        }

        return new double[] {
            income * taxRate,        // [0] = tax
            income * sssRate,        // [1] = sss
            income * pagibigRate,    // [2] = pagibig
            income * philhealthRate, // [3] = philhealth
        };
    }

    public static double calculateLatePenalty(double hours, double minutes) {
        return (hours * LATE_PER_HOUR) + (minutes > 0 ? LATE_PER_MINUTE : 0);
    }

    public static double calculateGrossPay(Employee emp, double overtimeHours, double lateHours,
                                            double lateMinutes, double absences, int undertime) {
        double overTimePay = calculateOvertime(overtimeHours);
        double latePenalty = calculateLatePenalty(lateHours, lateMinutes);
        double absencePenalty = absences * ABSENCE_PER_DAY_HOURS;
        double undertimePenalty = undertime * UNDERTIME_HOURS;

        double totalHours = WORKING_HOURS - absencePenalty - undertimePenalty - lateHours;
        double grossIncome = (totalHours * emp.getHourlyRate()) + emp.getAllowance() + overTimePay - latePenalty;
        return grossIncome;
    }
}

public class PayrollSystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        List<Employee> employees = Arrays.asList(
            new Employee("1001", "Jose", "Cruz", "A", "Manager", "IT", "Single", 99840, 4500, 520),
            new Employee("1002", "Paulo", "Santiago", "N", "Assistant Manager", "IT", "Single", 86400, 2500, 450),
            new Employee("1003", "Anna", "Reyes", "L", "Secretary", "IT", "Married", 67200, 1500, 350),
            new Employee("1004", "Lisa", "Mendoza", "P", "Assistant Secretary", "IT", "Widow", 57600, 1000, 300)
        );

        // Display employee table
        System.out.println("------------------------------------------------------------------------------------------");
        System.out.println("                                    Payroll System 101                                    ");
        System.out.println("------------------------------------------------------------------------------------------");
        System.out.println("| ID   | Employee Name      | Position              | Dept | Rate | Salary   | Allowance |");
        System.out.println("------------------------------------------------------------------------------------------");
        for (Employee e : employees) {
            System.out.printf("| %-4s | %-18s | %-21s | %-4s | %-4.0f | %-8.0f | %-9.0f |\n",
                e.getId(),
                e.getFullName(),
                e.getPosition(),
                e.getDepartment(),
                e.getHourlyRate(),
                e.getMonthlySalary(),
                e.getAllowance()
            );
        }
        System.out.println("---------------------------------------------------------------------------------------");

        char ans;
        do {
            System.out.println("\nEnter Employee's Data");
            System.out.print("\n  Enter Employee Number   : ");
            String empId = sc.nextLine();

            Employee emp = employees.stream()
                                    .filter(e -> e.getId().equals(empId))
                                    .findFirst()
                                    .orElse(null);

            if (emp == null) {
                System.out.println("Invalid employee ID.");
                System.out.println("\nDo you want to repeat again? [Y/N]: ");
                ans = sc.nextLine().charAt(0);
                continue;
            }

            System.out.println("    Employee Name         : " + emp.getFullName());
            System.out.println("    Position              : " + emp.getPosition());
            System.out.println("    Department            : " + emp.getDepartment());
            System.out.println("    Status                : " + emp.getStatus());
            System.out.println("    Monthly Salary        : " + emp.getMonthlySalary());
            System.out.println("    Allowance             : " + emp.getAllowance());
            System.out.println();

            System.out.print("  Enter Overtime Hours    : ");
            double overtimeHours = sc.nextDouble();
            System.out.print("  Enter Late Hours        : ");
            double lateHours = sc.nextDouble();
            System.out.print("  Enter Late Minutes      : ");
            double lateMinutes = sc.nextDouble();
            System.out.print("  Enter Absences (Days)   : ");
            double absences = sc.nextDouble();
            System.out.print("  Enter Undertime (Hours) : ");
            int undertime = sc.nextInt();
            System.out.print("  Specify Tax Bracket\n    [1] Single\n    [2] Married\n    [3] Widow             : ");
            int bracket = sc.nextInt();
            System.out.print("  House Loan              : ");
            double houseLoan = sc.nextDouble();
            System.out.print("  Car Loan                : ");
            double carLoan = sc.nextDouble();
            sc.nextLine();

            double totalLoan = houseLoan + carLoan;
            double overtimePay = PayrollCalculator.calculateOvertime(overtimeHours);
            double grossPay = PayrollCalculator.calculateGrossPay(emp, overtimeHours, lateHours, lateMinutes, absences, undertime);
            double[] deductions = PayrollCalculator.calculateDeductions(grossPay, bracket);
            double totalDeductions = deductions[0] + deductions[1] + deductions[2] + deductions[3];
            double netPay = grossPay - (houseLoan + carLoan);

            // Print full payroll slip
            System.out.println("\n-------------- Payroll Slip --------------");
            System.out.println("\nEmployee Number          : " + emp.getId());
            System.out.println("Employee Name            : " + emp.getFullName());
            System.out.println("Position                 : " + emp.getPosition());
            System.out.println("Department               : " + emp.getDepartment());
            System.out.println("Status                   : " + emp.getStatus());
            System.out.println("Monthly Salary           : " + emp.getMonthlySalary());
            System.out.println("Allowance                : " + emp.getAllowance());
            System.out.println("Overtime Pay             : " + overtimePay);
            System.out.println("\nComputation of Time");
            System.out.println("    Late                 : " + lateHours + " hr, " + lateMinutes + " min");
            System.out.println("    Absences             : " + absences + " days");
            System.out.println("    Undertime            : " + undertime + " hr");
            System.out.println("    Total Hours          : " + (192 - absences*8 - undertime - lateHours));
            System.out.println("    Rate                 : " + emp.getHourlyRate());
            System.out.println("    Total Income         : " + grossPay);
            System.out.println("\nComputation of Deduction");
            System.out.println("    Tax                  : " + deductions[0]);
            System.out.println("    SSS                  : " + deductions[1]);
            System.out.println("    Pag-IBIG             : " + deductions[2]);
            System.out.println("    PhilHealth           : " + deductions[3]);
            System.out.println("    Total Deduction      : " + totalDeductions);
            System.out.println("  Others");
            System.out.println("    House Loan           : " + houseLoan);
            System.out.println("    Car Loan             : " + carLoan);
            System.out.println("    Total Loan           : " + totalLoan);
            System.out.println("\nTotal Gross Pay          : " + grossPay);
            System.out.println("Total Net Pay            : " + netPay);
            System.out.println("\n------------------------------------------");

            System.out.println("\nDo you want to repeat again? [Y/N]: ");
            ans = sc.nextLine().charAt(0);
        
        } while (ans == 'Y' || ans == 'y');

        sc.close();
    }
}