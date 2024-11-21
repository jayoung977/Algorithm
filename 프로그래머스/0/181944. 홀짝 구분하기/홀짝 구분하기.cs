using System;

public class Example
{
    public static void Main()
    {
       

        String s = Console.ReadLine();

        int a = Int32.Parse(s);
        if (a%2==0)  
            Console.WriteLine("{0} is even",a);
        else
            Console.WriteLine("{0} is odd",a);
    }
}