using System;

public class InputHelper
{
    public static double GetNumber(string prompt)
    {
        while (true)
        {
            Console.Write(prompt);
            string input = Console.ReadLine() ?? "";
            
            if (double.TryParse(input, out double result))
                return result;
            
            Console.WriteLine("Please enter a valid number.");
        }
    }
}