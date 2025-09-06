using System;

public class AuthenticationService
{
    public static bool ValidatePin(Account account, string enteredPin)
    {
        return account.Pin == enteredPin;
    }
}