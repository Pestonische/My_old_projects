using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Sum
{
    class summator
    {
        public int size_mas;
        public List<long> mas1;
        public List<long> mas;
        public void init(List<long> _mas1, int n)
        {
            this.mas1 = _mas1;
            size_mas = (int)Math.Sqrt(n);
            mas = new List<long>();
            //long nomer = 0;

            for (int i = 0; i < n;)
            {
                int size = i + size_mas;
                if (size >= n)
                    size = n;
                long sum = 0;
                for (; i < size; i++)
                {
                    sum += mas1[i];
                }
                mas.Add(sum);
                //nomer++;
            }
        }

        public void Add(int i, long x)
        {
            mas1[i] += x;
            mas[i / size_mas] += x;
        }
        public long FindSum(int l, int r)
        {
            int jl = l / size_mas;

            int jr = r / size_mas;

            long sum = 0;

            if (jl == jr)
            {               
                for (int i = l; i < r; i++)
                {
                    sum += mas1[i];
                }
                return sum;
            }
            else
            {
                int length = (jl + 1) * size_mas;
                for (int i = l; i < length; i++)
                {
                    sum += mas1[i];
                }
                for (int i = jl + 1; i < jr; i++)
                {
                    sum += mas[i];
                }
                for (int i = jr * size_mas; i < r; i++)
                {
                    sum += mas1[i];
                }
                return sum;
            }
        }

    }
    class Program
    {
        static void Main(string[] args)
        {
            int n = int.Parse(Console.ReadLine());
            string[] mas_src = Console.ReadLine().Split(new char[] { ' ' });
            List<long> mas = new List<long>();
            for (long i = 0; i < n; i++)
                mas.Add(long.Parse(mas_src[i]));
            summator sum = new summator();
            sum.init(mas, n);
            long j = long.Parse(Console.ReadLine());
            for (long i = 0; i < j; i++)
            {
                mas_src = Console.ReadLine().Split(new char[] { ' ' });
                if (mas_src[0] == "FindSum")
                Console.WriteLine(sum.FindSum(int.Parse(mas_src[1]), int.Parse(mas_src[2])).ToString());
                else
                    sum.Add(int.Parse(mas_src[1]), int.Parse(mas_src[2]));
            }
        }
    }
}
