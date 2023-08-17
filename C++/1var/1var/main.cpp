#include <iostream>
#include <fstream>
#include <string>

using namespace std;

int chack(int a)
{
	for (int i = 1; i < a; i++)
	{
		if (a % i == 0 && i != a && i != 1)
			return 0;
	}
	return 1;
}

int main()
{
	setlocale(LC_ALL, "rus");
	ifstream  n1("in.txt");
	ofstream n2("out.txt");

	if (!n1.is_open())
	{
		cout << "Open error" << endl;
		return 2;
	}
	if (n1.peek() == EOF)
	{
		cout << "¬ходной файл не содержит строк" << endl;
		return 1;
	}
	int a = 0, b=0;

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
		if (s[i] > 0)		
		{
			if (chack(s[i]) == 1)
				n2 << s[i] << " : prime" << endl;
			if (chack(s[i]) == 0)
				n2 << s[i] << " : composite" << endl;
		}
	}
	
	n3.close();
	n2.close();

	return 0;
}