#include <iostream>
//#include <ctime>
#include <iomanip>

using namespace std;

int main()
{
	setlocale(LC_ALL, "Rus");

	int n, g, c = 0, l = 0, e = 0;

	cout << "Введите количество элементов массива : ";

	for (;;)
	{
		cin >> n;

		if (n >= 1)

			break;
		cout << "\nКоличество элементов массива должно быть положительным!" << endl;

		cout << "\nВведите другое значение: ";
	}
	cout << "Введите ключ матрицы: ";

	cin >> g;

	srand(g);

	int** p;

	p = new int* [n];

	for (int i = 0; i < n; i++)
	{
		p[i] = new int[n];
	}
	for (int i = 0; i < n; i++)
	{
		for (int j = 0; j < n; j++)
		{
			int k = rand();

			p[i][j] = k % 10 - 2;
		}
	}
	cout << "Элементы матрицы: " << endl;

	for (int i = 0; i < n; i++)
	{
		for (int j = 0; j < n; j++)
		{
			cout << setw(5) << p[i][j];
		}
		cout << endl;
	}
	int* q = new int[n];

	for (int i = 0; i < n; ++i) 
	{
		c = 0;

		for (int j = 0; j < n; ++j)
		{
			c += p[i][j];

			q[i] = c;
		}
		cout << "Сумма строки " << i + 1 << ": " << c << endl;
	}
	/*for (int i = 0; i < n; i++)
	{
		cout << q[i] << " ";
	}
	cout << endl;*/

	int x = 0;

	//int t;

	for (int i = 0; i < n - 1; i++)
	{
		for (int j = i + 1; j < n; j++)
		{
			if (q[i] > q[j])
			{
				swap(q[i], q[j]);

				swap(p[i], p[j]);
			}
		}
	}


	/*for (int i = 0; i < n; i++)  
	{
		
		for (int w = 0; w < n - i - 1; w++)
		{
			if (q[w] > q[w + 1])
			{
				t = q[w];

				q[w] = q[w + 1];

				q[w + 1] = t;
				
				
				for (int j = 0; j < n; j++)
				{
					x = p[w][j];

					p[w][j] = p[w + 1][j];

					p[w + 1][j] = x;
				}
			}
		}
	}*/
	for (int i = 0; i < n; i++)
	{
		for (int j = 0; j < n; j++)
		{
			cout << setw(5) << p[i][j];

			if (p[i][j] == 0)
			{
				l++;

				if (l == 1)
				{
					e = i;
				}
			}
		}
		cout << endl;
	}

	if (l > 0)
	{
		cout << "Номер строки с нулем: " << e + 1 << endl;
	}
	else
	{
		cout << "Нет строки с 0!";
	}

	for (int i = 0; i < n; i++)
	{
		delete[] p[i];
	}
	delete[] p;
}