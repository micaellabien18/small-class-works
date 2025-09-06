using System;

class Program
{
    static void Main()
    {
        // Initialize account
        var account = new Account("TC24610", 10000.00);
        
        // Start ATM system
        var atmSystem = new ATMSystem(account);
        atmSystem.Start();
    }
}