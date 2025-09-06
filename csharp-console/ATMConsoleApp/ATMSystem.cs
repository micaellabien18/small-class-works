using System;

public class ATMSystem
{
    private readonly Account _account;
    private const int MaxPinAttempts = 3;
    
    public ATMSystem(Account account)
    {
        _account = account;
    }
    
    public void Start()
    {
        Console.WriteLine("=== ATM System ===");
        
        if (!AuthenticateUser())
        {
            Console.WriteLine("\nAuthentication failed. Exiting system.");
            return;
        }
        
        CollectUserInformation();
        RunATMMenu();
    }
    
    private bool AuthenticateUser()
    {
        int attempts = 0;
        
        while (attempts < MaxPinAttempts)
        {
            string enteredPin = InputService.GetStringInput("\nEnter your PIN: ");
            
            if (AuthenticationService.ValidatePin(_account, enteredPin))
            {
                Console.WriteLine("PIN validated successfully.");
                return true;
            }
            
            attempts++;
            Console.WriteLine($"Invalid PIN. {MaxPinAttempts - attempts} attempts remaining.");
        }
        
        return false;
    }
    
    private void CollectUserInformation()
    {
        Console.WriteLine("\n--- User Information ---");
        string name = InputService.GetStringInput("Enter your name: ");
        string courseAndSection = InputService.GetStringInput("Enter your course and section: ");
        string subject = InputService.GetStringInput("Enter the subject: ");
        
        var user = new User(name, courseAndSection, subject);
        _account.SetAccountHolder(user);
    }
    
    private void RunATMMenu()
    {
        while (true)
        {
            DisplayMenu();
            int choice = InputService.GetIntInput("Enter your choice (1-5): ", 1, 5);
            
            if (!ProcessMenuChoice(choice))
                break;
        }
    }
    
    private void DisplayMenu()
    {
        Console.WriteLine("\n=== ATM Menu ===");
        Console.WriteLine("1. Balance Inquiry");
        Console.WriteLine("2. Deposit");
        Console.WriteLine("3. Withdraw");
        Console.WriteLine("4. Transfer Money");
        Console.WriteLine("5. Exit");
    }
    
    private bool ProcessMenuChoice(int choice)
    {
        switch (choice)
        {
            case 1:
                HandleBalanceInquiry();
                break;
            case 2:
                HandleDeposit();
                break;
            case 3:
                HandleWithdrawal();
                break;
            case 4:
                HandleTransfer();
                break;
            case 5:
                Console.WriteLine("\nThank you for using our ATM system!");
                Console.WriteLine($"Have a great day, {_account.AccountHolder?.Name}!");
                return false;
            default:
                Console.WriteLine("Invalid choice.");
                break;
        }
        return true;
    }
    
    private void HandleBalanceInquiry()
    {
        Console.WriteLine("\n--- Balance Inquiry ---");
        Console.WriteLine($"Account Holder: {_account.AccountHolder?.Name}");
        Console.WriteLine($"Current Balance: ₱{_account.Balance:F2}");
    }
    
    private void HandleDeposit()
    {
        Console.WriteLine("\n--- Deposit ---");
        double amount = InputService.GetDoubleInput("Enter the deposit amount: ₱");
        
        if (_account.Deposit(amount))
        {
            Console.WriteLine($"Deposit successful! New balance: ₱{_account.Balance:F2}");
        }
        else
        {
            Console.WriteLine("Invalid deposit amount. Please enter a positive amount.");
        }
    }
    
    private void HandleWithdrawal()
    {
        Console.WriteLine("\n--- Withdrawal ---");
        double amount = InputService.GetDoubleInput("Enter the withdrawal amount: ₱");
        
        if (_account.Withdraw(amount))
        {
            Console.WriteLine($"Withdrawal successful! New balance: ₱{_account.Balance:F2}");
        }
        else
        {
            if (amount > _account.Balance)
                Console.WriteLine("Insufficient funds. Cannot withdraw more than the current balance.");
            else
                Console.WriteLine("Invalid withdrawal amount. Please enter a positive amount.");
        }
    }
    
    private void HandleTransfer()
    {
        Console.WriteLine("\n--- Transfer Money ---");
        double amount = InputService.GetDoubleInput("Enter the transfer amount: ₱");
        
        if (amount <= 0)
        {
            Console.WriteLine("Invalid transfer amount. Please enter a positive amount.");
            return;
        }
        
        if (amount > _account.Balance)
        {
            Console.WriteLine("Insufficient funds. Cannot transfer more than the current balance.");
            return;
        }
        
        string recipient = InputService.GetStringInput("Enter the recipient's name: ");
        
        if (_account.Transfer(amount))
        {
            Console.WriteLine($"Transfer to {recipient} successful! New balance: ₱{_account.Balance:F2}");
        }
        else
        {
            Console.WriteLine("Transfer failed. Please try again.");
        }
    }
}