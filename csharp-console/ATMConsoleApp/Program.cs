using System;

class Program
{
    const string pin = "TC24610";
    const double previousBalance = 10000;
    static string name;
    static string courseAndSection;
    static string subject;
    static double currentBalance = previousBalance;

    static void Main()
    {
        Console.WriteLine("ATM System");

        // Validate PIN
        Console.Write("\nEnter your PIN: ");
        string enteredPin = Console.ReadLine();

        if (enteredPin != pin)
        {
            Console.WriteLine("Invalid PIN");
            return;
        }

        // Gather user information
        Console.Write("Enter your name: ");
        name = Console.ReadLine();

        Console.Write("Enter your course and section: ");
        courseAndSection = Console.ReadLine();

        Console.Write("Enter the subject: ");
        subject = Console.ReadLine();

        // ATM Process Loop
        while (true)
        {
            Console.WriteLine("\nATM Menu:");
            Console.WriteLine("1. Balance Inquiry");
            Console.WriteLine("2. Deposit");
            Console.WriteLine("3. Withdraw");
            Console.WriteLine("4. Transfer Money");
            Console.WriteLine("5. Exit");

            Console.Write("Enter your choice (1-5): ");
            int choice = int.Parse(Console.ReadLine());

            switch (choice)
            {
                case 1:
                    Console.WriteLine("\nBalance Inquiry:");
                    Console.WriteLine("Current Balance: ${0:F2}", currentBalance);
                    break;
                case 2:
                    Console.Write("\nEnter the deposit amount: $");
                    double depositAmount = double.Parse(Console.ReadLine());
                    if (depositAmount > 0)
                    {
                        currentBalance += depositAmount;
                        Console.WriteLine("Deposit successful. Current Balance: ${0:F2}", currentBalance);
                    }
                    else
                    {
                        Console.WriteLine("Invalid deposit amount. Please enter a positive amount.");
                    }
                    break;
                case 3:
                    Console.Write("\nEnter the withdrawal amount: $");
                    double withdrawalAmount = double.Parse(Console.ReadLine());

                    if (withdrawalAmount > 0 && withdrawalAmount <= currentBalance)
                    {
                        currentBalance -= withdrawalAmount;
                        Console.WriteLine("Withdrawal successful. Current Balance: ${0:F2}", currentBalance);
                    }
                    else if (withdrawalAmount > currentBalance)
                    {
                        Console.WriteLine("Insufficient funds. Cannot withdraw more than the current balance.");
                    }
                    else
                    {
                        Console.WriteLine("Invalid withdrawal amount. Please enter a positive amount.");
                    }
                    break;
                case 4:
                    Console.Write("\nEnter the transfer amount: $");
                    double transferAmount = double.Parse(Console.ReadLine());

                    if (transferAmount > 0 && transferAmount <= currentBalance)
                    {
                        Console.Write("Enter the recipient's name: ");
                        string recipientName = Console.ReadLine();

                        currentBalance -= transferAmount;
                        Console.WriteLine("Transfer to {0} successful. Current Balance: ${1:F2}", recipientName, currentBalance);
                    }
                    else if (transferAmount > currentBalance)
                    {
                        Console.WriteLine("Insufficient funds. Cannot transfer more than the current balance.");
                    }
                    else
                    {
                        Console.WriteLine("Invalid transfer amount. Please enter a positive amount.");
                    }
                    break;
                case 5:
                    Console.WriteLine("Exiting ATM. Thank you!");
                    return;
                default:
                    Console.WriteLine("Invalid choice. Please enter a number between 1 and 5.");
                    break;
            }
        }
    }
}