using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Temperature
{
    class Program
    {
        static void Main(string[] args)
        {
            Temperature[] mt = new Temperature[10];
            mt[0] = new Temperature(2);
            mt[1] = new Temperature(3);
            Temperature result = mt[0] - mt[1];
            Console.WriteLine(result.getCelcium().ToString());
        }
    }
}
