#include <iostream>
#include <fstream>
#include <string>

using namespace std;

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
	int n = 0;
	n1 >> n;
	double* s = new double[n];

	for (int i = 0; i < n; i++)
	{
		n1 >> s[i];
		cout << s[i] << " ";
		n2 << s[i] << " ";
	}
	n2 << endl;

	int p = 0, o=0;

	for (int i = 0; i < n; i++)
	{
		double g = s[i];
		p = 0;
		
		for (int j=0; j < n; j++) 
		{
			if (g != s[j] && j != i)
			{
				p++;
			}
		}
		if (p == n-1)
			o++;
		
	}
	n2 << o;

	n1.close();
	n2.close();

	return 0;
}