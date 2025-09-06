using System;

class Program
{
    static void Main()
    {
        var calculator = new Calculator();
        
        Console.WriteLine("=== Simple Calculator ===\n");
        
        // Get input numbers
        double firstNumber = InputHelper.GetNumber("Input first number: ");
        double secondNumber = InputHelper.GetNumber("Input second number: ");
        
        Console.WriteLine();
        
        // Perform all operations and display results
        double addResult = calculator.Add(firstNumber, secondNumber);
        Console.WriteLine($"Addition: {firstNumber} + {secondNumber} = {addResult:F2}");
        
        double subtractResult = calculator.Subtract(firstNumber, secondNumber);
        Console.WriteLine($"Subtraction: {firstNumber} - {secondNumber} = {subtractResult:F2}");
        
        double multiplyResult = calculator.Multiply(firstNumber, secondNumber);
        Console.WriteLine($"Multiplication: {firstNumber} × {secondNumber} = {multiplyResult:F2}");
        
        double divideResult = calculator.Divide(firstNumber, secondNumber);
        if (secondNumber != 0) // Only show division result if valid
        {
            Console.WriteLine($"Division: {firstNumber} ÷ {secondNumber} = {divideResult:F2}");
        }
    }
}