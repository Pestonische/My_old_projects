using System;
using System.Collections.Generic;
using System.Linq;
using System.Numerics;
using System.Text;
using System.Threading.Tasks;

namespace Шредер
{
    class Schroder
    {
        object sync = new object();
        List<BigInteger> cache;

        public Schroder(int Capacity = 1000)
        {
            cache = new List<BigInteger>(Capacity) { 1 };
        }

        BigInteger Next()
        {
            int n = cache.Count;
            var r = cache[n - 1];
            for (int i = 0; i < n; i++)
                r += cache[i] * cache[n - 1 - i];

            return r;
        }
        
        public BigInteger Calc(int n, IProgress<int> Progress = null)
        {
            lock (sync)
            {
                int from = cache.Count;
         
                for (int i = from; i <= n; i++)
                {
                    cache.Add(Next());
                    Progress?.Report((int)(100f * (i + 1 - from) / (n + 1 - from)));
                }

                return cache[n];
            }
        }
    }
    class Program
    {
        static void Main(string[] args)
        {
            Schroder sh = new Schroder();
            Console.WriteLine(sh.Calc(4));
        }
    }
}
