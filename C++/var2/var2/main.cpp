#include <iostream>
#include <fstream>
#include <string>

using namespace std;

int chack(int a)
{
	int b = 0, c = 0, d=a,g=a;
	for (;;)
	{
		if (d <= 9)
		{
			c++;
			break;
		}
		d = d / 10;
		c++;
	}
	int c2 = c - 1;
	int* s = new int[c];
	if (g <= 9)
	{
		s[0] = d;
	
	}
	else
	{
		for (int i=0;;i++)
		{
			if (g <= 9)
				break;
			b = g % 10;
			g = g / 10;
			s[i] = b;
						
			if (g <= 9)
				s[i+1] = g;
		}
	}
	int sum = 0;
	if (c < 2)
	{
		sum = s[0];
	}
	else
	{
		sum = s[0] * (int)pow(10.0, c-1);
		
		for (int i = 1; i < c; i++)
		{
			c2--;
			sum = sum + s[i] * (int)pow(10.0, c2);
		}
		
	}
	return sum;
}

int main()
{
	setlocale(LC_ALL, "rus");
	ifstream  n1("in.txt");
	ofstream n2("out.txt");

	if (!n1.is_open())
	{
		cout << "Ошибка открытия" << endl;
		return 2;
	}
	if (n1.peek() == EOF)
	{
		cout << "Входной файл не содержит строк" << endl;
		return 1;
	}
	int a = 0, b = 0;

	while (n1 >> a)
	{
		b++;
	}
	n1.close();
	ifstream  n3("in.txt");
	int* s = new int[b];

	a = 0;
	int i = 0;
	while (n3 >> a)
	{
		if (i == b)
			break;
		s[i] = a;
		i++;
		

	}
	for (int i = 0; i < b; i++)
	{
		int c = s[i];
		for (int j = 0; j < b; j++)
		{
			if (c == s[j] && j != i)
				s[j] = (-1);
		}
	}
	for (int i = 0; i < b; i++)
	{
		if (s[i] < 0)
		{
		}
		else
		{
			n2 <<s[i]<<" : "<< chack(s[i]) << endl;
		}
	}

	n3.close();
	n2.close();

	return 0;
}