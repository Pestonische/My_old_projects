using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Text.RegularExpressions;
namespace ____
{
    class Program
    {
        static void Main(string[] args)
        {
            string s = "Мама       мыла  раму.     ";
            string pattern = @"\s+";
            string target = " ";
            Regex regex = new Regex(pattern);
            string result = regex.Replace(s, target);
            Console.WriteLine(result);
        }
    }
   }
    
