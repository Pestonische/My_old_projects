using System;
using System.Linq;
namespace ConsoleApplication
{
    class Program
    {
        static void Main(string[] args)
        {

            // имя объекта мониторинга
            string name = "Имя объекта: Мост";
            // параметры объекта
            string[] X = { "X1", "X2", "X3", "X4" };
            // состояния объекта
            string[] V = { "Состояние 1", "Состояние 2", "Состояние 3",  "Состояние 4",
                           "Состояние 5" };
            // управляющие решения
            string[] U = { "Управление 1", "Управление 2 ", "Управление 3",
                            "Управление 4", "Управление 5" };
            double[,] E = { { 0.00, 0.00, 0.00, 0.00 },
                                { 0.25, 0.25, 0.25, 0.25 },
                                { 0.50, 0.50, 0.50, 0.50 },
                                { 0.75, 0.75, 0.75, 0.75 },
                                { 1.00, 1.00, 1.00, 1.00 } };
            int n = 4; int m = 5;
            double[,] Y = new double[m, n];
            object[] a = new object[m + 2];
            a[0] = n; a[1] = m;
            for (int k = 0; k <= m - 1; k++)
            { for (int t = 0; t < n; t++) { E[k, t] = 1.0 * k / (m - 1); } }
            double[] Xin = { 0.01, 0.03, 0.30, 0.50 };
            int i = Array.IndexOf(Xin, Xin.Max());
            Console.WriteLine(name);
            Console.WriteLine("Опасный параметр = " + X[i]);
            Console.WriteLine("Значение опасного параметра = " + Xin[i]);
            if (Xin[i] == 0.00)
            {
                Console.WriteLine
("Состояние объекта = " + V[0] + ". Управление = " + U[0]);
            }
            if (Xin[i] == 0.25)
            {
                Console.WriteLine
("Состояние объекта = " + V[1] + ". Управление = " + U[1]);
            }
            if (Xin[i] == 0.50)
            {
                Console.WriteLine
("Состояние объекта = " + V[2] + ". Управление = " + U[2]);
            }
            if (Xin[i] == 0.75)
            {
                Console.WriteLine
("Состояние объекта = " + V[3] + ". Управление = " + U[3]);
            }
            if (Xin[i] == 1.00)
            {
                Console.WriteLine
("Состояние объекта = " + V[4] + ". Управление = " + U[4]);
            }
            Console.ReadKey();
        }
    }
}

