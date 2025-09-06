using System;

public class Account
{
    private double _balance; // Private field to protect balance from direct access
    
    public string Pin { get; private set; }
    public double Balance => _balance; // Read-only property exposing balance
    public User? AccountHolder { get; private set; }
    
    public Account(string pin, double initialBalance)
    {
        Pin = pin;
        _balance = initialBalance;
    }
    
    public void SetAccountHolder(User user)
    {
        AccountHolder = user;
    }
    
    public bool Deposit(double amount)
    {
        if (amount <= 0)
            return false;
            
        _balance += amount;
        return true;
    }
    
    public bool Withdraw(double amount)
    {
        if (amount <= 0 || amount > _balance)
            return false;
            
        _balance -= amount;
        return true;
    }
    
    public bool Transfer(double amount)
    {
        return Withdraw(amount); // Same as withdrawal
    }
}