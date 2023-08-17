using System;
using System.Collections.Generic;
using System.IO;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace дороги_0._1
{
    class DisjointSetUnion
    {
        public long[] size;
        public long[] parent;

        public void init(long n)
        {
            size = new long[n + 1];
            parent = new long[n + 1];

            for (long i = 1; i <= n; i++)
            {
                size[i] = 1;
                parent[i] = i;
            }
        }
        public long FindSet(long x)
        {
            if (x == parent[x])
            {
                return x;
            }
            parent[x] = FindSet(parent[x]);
            return parent[x];
        }
        public void Union(long x, long y) 
        {
            x = FindSet(x);
            y = FindSet(y);
            if (x != y)
            {
                long q = 0;
                if (size[x] < size[y])
                {
                    q = x;
                    x = y;
                    y = q;
                }
                parent[y] = x;
                size[x] += size[y];
            }
}
    }
    class Program
    {
        static void Main(string[] args)
        {
            string path = @"input.txt";
            string[] mas_src;
            using (StreamReader sr = new StreamReader(path, System.Text.Encoding.Default))
            {
                mas_src = sr.ReadLine().Split(new char[] { ' ' });
            }
            
            
            DisjointSetUnion road = new DisjointSetUnion();

            // Console.WriteLine(mas_src[1]);
            road.init(long.Parse(mas_src[0]));

            long size = long.Parse(mas_src[0]);
            
            long s = long.Parse(mas_src[1]);
            int g = 0;
            using (StreamReader sr = new StreamReader(path, System.Text.Encoding.Default))
            {
                for (long i = 0; i <= s; i++)
                {
                    if (g > 0)
                    {
                        long _size = size;

                        if (g > 0)
                            if ((mas_src = sr.ReadLine().Split(new char[] { ' ' })) != null)
                            {
                                road.Union(long.Parse(mas_src[0]), long.Parse(mas_src[1]));
                                for (long j = 1; j <= size; j++)
                                {
                                    if (road.parent[j] == j)
                                        if (road.size[j] != 1)
                                        {
                                            _size = _size - road.size[j] + 1;
                                        }
                                }
                                Console.WriteLine(_size);
                            }
                    }
                    g++;
                }                
            }
        }
    }
}
