using System;

public class Example
{
    public static void Main()
    {
        String s;

        Console.Clear();
        s = Console.ReadLine();
        char[] arr = s.ToCharArray();
        foreach (char c in arr){
            char newC = char.IsUpper(c) ? char.ToLower(c):char.ToUpper(c);
            Console.Write(newC);

        }
            
    }
}