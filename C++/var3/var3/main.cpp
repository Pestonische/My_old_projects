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
	int* s = new int[n];

	for (int i = 0; i < n; i++)
	{
		n1 >> s[i];
		cout << s[i]<<" ";
		n2 << s[i] << " ";
	}
	n2 << endl;

	for (int i = 1; i < n-1; i++)
	{
		if (s[i] < s[i + 1] && s[i] < s[i - 1])
			n2 << i+1<<" ";
	}

	n1.close();
	n2.close();

	return 0;
}