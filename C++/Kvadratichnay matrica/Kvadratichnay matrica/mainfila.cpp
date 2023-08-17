#include <iostream>
#include <ctime>
#include <iomanip>

using namespace std;

int main()
{
	setlocale(LC_ALL, "Rus");

	int n, a = 0;

	cout << "Введите количество элементов массива : ";

	for (;;)
	{
		cin >> n;

		if (n >= 1)

			break;

		cout << "\nКоличество элементов массива должно быыть положительным!" << endl;

		cout << "\nВведите другое значение: ";
	}
	//cout << "Введите ключ матрицы: ";

	//cin >> g;

    srand((int)time(NULL));

    int** p;

	p = new int* [n];

	for (int i = 0; i < n; i++)
	{
		p[i] = new int[n];
	}
	cout << "Элементы матрицы: " << endl;

	for (int i = 0; i < n; i++)
	{
		for (int j = 0; j < n; j++)
		{
			int k = rand();

			p[i][j] = k%10-2;

			cout << setw(5) << p[i][j];
		}
		cout << endl;
	}
	int cols = 0, rows = 0;

	for (int i = 0; i < n; i++)
	{
		rows = 0;
		for (int j = 0; j < n; j++)
		{
			if (p[i][j] == 0)
			{
				rows++;
				for (int s = 0; s < n; s++)
				{
					if (p[s][j] == 0)
					{
						cols++;
					}
				}
				if (cols == 1)
					{
						cout << "Один ноль в столбце: " << (j + 1) << endl;
					}
					cols = 0;		
			}
		}
		if (rows == 1)
		{
			cout << "Один ноль в строке: " << (i + 1) << endl;
		}
	}
	int l=n;
	for (int i = 0; i < n; i++)
	{
		for (int j = 0; j < n; j++)
		{
			if (p[i][j] < 0)
			{
				for (int s = i; s < n; s++)
				{
					if (p[s][j] > 0)
					{
						a++;
					}
				}
				cout << "Кол-во положительных элементов после отрицательного в столбце №" << (j + 1) << " : " << a << endl;

				for (int i = 0; i < l; i++)
				{		
					p[i][j] = 0;
				}
				a = 0;
			}
		}
	}
	for (int i = 0; i < n; i++)
	{
		delete[] p[i];
	}
		delete[] p;
}
