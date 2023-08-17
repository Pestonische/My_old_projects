using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Text.RegularExpressions;

namespace Taxi
{
    class Program
    {
        static void Main(string[] args)
        {
            string s = " ";
            
            int a = Convert.ToInt32(Console.ReadLine());
            int b = 0;
            for (int i=0; i<a;i++)
            {
                s = Console.ReadLine();
                if (s.Length == 9)
                {
                    if (Regex.IsMatch(s, @"(7(TAX|TBX|TEX)|[1-6](TAX|TBX)) 0{4}", RegexOptions.IgnoreCase))
                    { }
                    else
                    {
                        Regex regex = new Regex(@"(7(TAX|TBX|TEX)|[1-6](TAX|TBX)) [0-9]{4}");
                        MatchCollection matches = regex.Matches(s);
                        if (matches.Count > 0)
                        {
                            b++;
                        }
                    }
                }

            }
            Console.WriteLine(b);
        }
            

        
    }  
}

