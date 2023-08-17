using System;
using System.Linq;

namespace zadacha_2._08
{
    class Program
    {
        static void Main(string[] args)
        {
            Console.WriteLine("**********************************");
            Console.WriteLine("**Система мониторинга автомобиля**");
            Console.WriteLine("**********************************");
            string name = "Автомобиль";
            Random rand = new Random();
            int a=3;///количество
      

            double[] mas = new double[a];
            Console.WriteLine(a + "Данные датчиков:");
            for(int z=0;z<a;z++)
            {
                mas[z] = rand.NextDouble();
                Console.WriteLine("{0:0.##}",mas[z]);
            };
            string[] V = { "Хорошие", "Удовлетворительное", "Плохое"};
            string[] U = { "Продолжать работу", "Следить за качеством", "Заменить"};
            string[] X = { "Кузов", "Двигатель", "Шасси"};
            Console.WriteLine("Возможное состояние: 0.00, 0.25, 0.50,  0.75, 1.00" );

            int i = Array.IndexOf(mas, mas.Max());
            Console.WriteLine(name);
            Console.WriteLine("Опасный параметр = " + X[i]);
            Console.WriteLine("Значение опасного параметра = " + mas[i]);
            if (mas[i] == 0.00)
                {
                    Console.WriteLine("Состояние объекта = " + V[0] + ". Управление = " + U[0]);

                }
                if (mas[i] <= 0.50)
                {
                    Console.WriteLine("Состояние объекта = " + V[1] + ". Управление = " + U[1]);

                }
                if (mas[i] <= 1.00)
                {
                    Console.WriteLine("Состояние объекта = " + V[2] + ". Управление = " + U[2]);

                }
            Console.WriteLine(DateTime.Now);
            Console.ReadKey();
        }
    }
}



