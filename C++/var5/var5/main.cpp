#include <iostream>
#include <fstream>
#include <string>
#pragma warning(disable : 4996)

using namespace std;

int main()
{
	char* t;

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
	string s;
	getline(n1, s);
	char* a = new char[size(s) + 1];

	for (int i = 0; i < (int)size(s); i++)
	{
		a[i] = s[i];
	}
	a[size(s)] = 0;
	
	t = strtok(a, " ");
	
	while (t != NULL)
	{
		cout << t<< endl;
		n2 << t << endl;
		t = strtok(NULL, " ");
	}

	n1.close();
	n2.close();

	return 0;
}