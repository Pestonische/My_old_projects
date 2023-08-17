using System;

namespace ConsoleApp1
{
    internal class Program
    {
        static int fib ( int n)
        {
            if (n == 0 || n == 1) return n;
            int first = fib(n - 1);
            int second = fib(n - 2);
            int k = first + second;
            return k;
        }
        static void Main(string[] args)
        {
            Console.WriteLine(fib(6).ToString());
        }
    }
}
