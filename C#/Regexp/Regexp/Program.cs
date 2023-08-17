using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Collections;
using System.IO;
using System.Text.RegularExpressions;
using static System.IO.FileStream;

namespace Regexp
{
    class Program
    {
        static int Main(string[] args)
        {
            string file_path_in;
            string file_path_out;
            int num;
            for (; ; )
            {
                Console.WriteLine("Введите последнее число в IP");
                num = Convert.ToInt32(Console.ReadLine());
                if (num <= 255 && num >= 0)
                    break;
            }
            string number = num.ToString();
            Console.WriteLine("Введите строку с путем к файлу in и его названием");
            file_path_in = Console.ReadLine();
           
            using (FileStream fs = File.Create(@file_path_in))
            {
                Console.WriteLine("Введите значения которые будут находится в файле, иначе он создасться пустым");

                string file= Console.ReadLine();

                byte[] info = new UTF8Encoding(true).GetBytes(file);

                fs.Write(info, 0, info.Length);
            }

            Console.WriteLine("Введите строку с путем к файлу out и его названием");
            file_path_out = Console.ReadLine();

            using (FileStream fs = File.Create(@file_path_out))
            {
                byte[] info = new UTF8Encoding(true).GetBytes("");

                fs.Write(info, 0, info.Length);
            }

            if (!File.Exists(file_path_in))
            {
                Console.WriteLine("Файл не может быть открыт!");
                return 2;
            }

            if (!File.Exists(file_path_out))
            {
                Console.WriteLine("Файла не существует!");
                return 2;
            }

            string IP = "";
            
            using (StreamReader sr = new StreamReader(@file_path_in))
            {
                while (sr.Peek() != -1)
                {
                    IP = sr.ReadLine();

                }
            }

            if (IP == "")
            {
                Console.WriteLine("Файл in пуст!");

                return 1;
            }

            Console.WriteLine("Файл до сортировки!");
            Console.WriteLine(IP);

            IP = Regex.Replace(IP, @"(\d|\d{2}|[0-1]\d{2}|2[0-5][0-5])\.(\d|\d{2}|[0-1]\d{2}|2[0-5][0-5])\.(\d|\d{2}|[0-1]\d{2}|2[0-5][0-5])\." + number, "");

            Console.WriteLine("Файл после сортировки!");
            Console.WriteLine(IP);

            using (StreamWriter sw = new StreamWriter(@file_path_out, false, System.Text.Encoding.Default))
            {
                sw.WriteLine(IP);
            }

            return 0;
        }
    }
}
