using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Threading;

namespace Dad_Mom_Csharp
{
    public class Dad_Mom
    {

        private int times;
        private int repeats;
        private string message;
        public static int total_number_of_repeats;
        public static object lo = new object();
        public Dad_Mom(string amessage, int atimes, int arepeats)
        {
            this.times = atimes;
            this.repeats = arepeats;
            this.message = amessage;
        }

        public void Set()
        {
            for (int i = 0; i < repeats; i++)
            {
                lock (lo)
                {
                    if (total_number_of_repeats == 0)
                        break;
                    total_number_of_repeats--;
                   
                    Console.WriteLine(message); 
                    if (total_number_of_repeats != 0)
                    {
                        Monitor.Wait(lo, times);
                    }
                    else
                        Monitor.PulseAll(lo);
                }
            }
        }
    }
    class Program
    {
        public static void Main(string[] args)
        {
            Console.WriteLine("Введите общее количество повторений");
            Dad_Mom.total_number_of_repeats = int.Parse(Console.ReadLine());
            Console.WriteLine("Введите количество потоков");
            int n = int.Parse(Console.ReadLine());
            Thread[] treads = new Thread[n];

            for (int i = 0; i < n; i++)
            {
                Console.WriteLine("Введите сообщение потока {0}", i+1);
                string message = Console.ReadLine();
                Console.WriteLine("Введите количество повторений");
                int repeats = int.Parse(Console.ReadLine());
                Console.WriteLine("Введите задержку между сообщениями");
                int times = int.Parse(Console.ReadLine());
                Dad_Mom a = new Dad_Mom(message, times, repeats);
                treads[i] = new Thread(new ThreadStart(a.Set));
            }
            foreach (var th in treads)
            {
                th.Start();
            }
            foreach (var th in treads)
            {
                th.Join();
            }
        }
    }

}
