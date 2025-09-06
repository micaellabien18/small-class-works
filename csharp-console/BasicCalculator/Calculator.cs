using System;

public class Calculator
{
    public double Add(double a, double b)
    {
        return a + b;
    }
    
    public double Subtract(double a, double b)
    {
        return a - b;
    }
    
    public double Multiply(double a, double b)
    {
        return a * b;
    }
    
    public double Divide(double a, double b)
    {
        if (b == 0)
        {
            Console.WriteLine("Error: Cannot divide by zero!");
            return 0;
        }
        return a / b;
    }
}