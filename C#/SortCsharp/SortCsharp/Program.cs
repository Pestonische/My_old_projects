using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Collections;
using System.IO;

namespace SortCsharp
{

    class Sort
    {
        private int n;
        public int b = 0;
        public Sort(List<int> deque, int N)
        {
            n = N;
            
            for (int i = 0; i < deque.Count; i++)
            {
                if (deque[i] % N == 0)
                {
                    b++;

                    if (b > 1)
                    {
                        deque.RemoveAt(i);
                        
                        i--;
                    }
                }
                else
                {
                    b = 0;
                }

            }
            
        }
    }

    class Program
    {
        static void Main(string[] args)
        {
            string file_path;
            Console.WriteLine("Введите введите строку с путем к файлу (имя файла numbers.txt)");
            file_path = Console.ReadLine();
            List<int> deq = new List<int>();
            using (StreamReader sr = new StreamReader(@file_path))
            {
                string temp;
                while (sr.Peek() != -1)
                {
                    temp = sr.ReadLine();
                    if (temp == "flag")
                        continue;
                    else
                        deq = temp.Split(' ').Select(x => Convert.ToInt32(x)).ToList();
                }
            }
            for (int i = 0; i < deq.Count; i++)
            {
                Console.Write(deq[i]+" ");
            }
            Console.WriteLine();
            int number_to_divide;
            for (;;)
            {
                Console.WriteLine("Введите число для сортировки: ");
                number_to_divide = Int32.Parse(Console.ReadLine());
                if (number_to_divide == 0)
                {
                    Console.WriteLine("На ноль делить нельзя");
                }
                else
                    break;
            }
           
            Sort _sort = new Sort(deq, number_to_divide);
            Console.WriteLine(deq[4]);
            for (int i = 0; i < deq.Count; i++)
            {
                Console.Write(deq[i] + " ");
            }
            Console.WriteLine();
            Console.WriteLine("Количество элементов после сортировки: {0} ", deq.Count);
        }
    }
}
