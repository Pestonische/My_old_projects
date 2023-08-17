using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;


namespace drobi_c_sharp
{

    class Program
    {
        static void Main(string[] args)
        {
            drobi the_first_shot = new drobi(), the_second_fraction = new drobi();
            for(;;)
            {
                int numenator1, denominator1, numenator2, denominator2;
                try
                {
                        Console.WriteLine("Введите чеслитель 1: ");
                        numenator1 = Int32.Parse(Console.ReadLine());
                        Console.WriteLine("Введите знаменатель 1: ");
                        denominator1 = Int32.Parse(Console.ReadLine());
                        the_first_shot = new drobi(numenator1, denominator1);
                                           
                        Console.WriteLine("Введите чеслитель 2: ");
                        numenator2 = Int32.Parse(Console.ReadLine());
                        Console.WriteLine("Введите знаменатель 2: ");
                        denominator2 = Int32.Parse(Console.ReadLine());
                        the_second_fraction = new drobi(numenator2, denominator2);
                }
                catch (Exception e)
                {
                    Console.WriteLine(e.Message);
                    continue;
                }
                break;
            }

            Console.WriteLine("Сокращение первой дроби "+ the_first_shot + ": " + the_first_shot.FractionOut());
            Console.WriteLine("Сокращение второй дроби " + the_second_fraction + ": " + the_second_fraction.FractionOut());

            Console.WriteLine("Сумма двух дробей {0}: {1}", the_first_shot + the_second_fraction, (the_first_shot + the_second_fraction).FractionOut());
            Console.WriteLine("Разность двух дробей {0}: {1}", the_first_shot - the_second_fraction, (the_first_shot - the_second_fraction).FractionOut());
            Console.Write("Деление двух дробей ");
            try
            {
                Console.WriteLine("{0}: {1}", the_first_shot / the_second_fraction, (the_first_shot / the_second_fraction).FractionOut());
            }
            catch (Exception e)
            {
                Console.WriteLine(e.Message);
            }
            Console.WriteLine("Умножение двух дробей {0}: {1}", the_first_shot * the_second_fraction, (the_first_shot * the_second_fraction).FractionOut());
            Console.WriteLine("Первая дробь со знаком минус {0}: {1}", -the_first_shot, (-the_first_shot).FractionOut());
            Console.WriteLine("Вторая дробь со знаком минус {0}: {1}", -the_second_fraction, (-the_second_fraction).FractionOut());
            Console.WriteLine("Проверка на равенство: {0}", the_first_shot == the_second_fraction);
            Console.WriteLine("Проверка на меньше или равно: {0}", the_first_shot <= the_second_fraction);
            Console.WriteLine("Проверка на больше или равно: {0}", the_first_shot >= the_second_fraction);
            Console.WriteLine("Проверка на меньше: {0}", the_first_shot < the_second_fraction);
            Console.WriteLine("Проверка на больше: {0}", the_first_shot > the_second_fraction);
            Console.WriteLine("Проверка на неравенство: {0}", the_first_shot != the_second_fraction);
            Console.WriteLine("Проверка на Equals: {0}", the_first_shot.Equals(the_second_fraction));
            Console.WriteLine("Проверка на хеш-коды: {0} {1}", the_first_shot.GetHashCode(), the_second_fraction.GetHashCode());
            drobi[] array_fractions = new drobi[5];
            array_fractions[0] = new drobi(1, 2);
            array_fractions[1] = new drobi(1, 4);
            array_fractions[2] = new drobi(1, 3);
            array_fractions[3] = new drobi(1, 5);
            array_fractions[4] = new drobi(15, 175);
            Array.Sort(array_fractions);
            Console.WriteLine("Вывод отсортированного массива: ");
            foreach (drobi fractions in array_fractions)
                Console.WriteLine(fractions);

            Console.WriteLine("Конец. Спасибо за внимание");
            Console.ReadKey();
        }
    }
}

