#include <iostream>
#include <string>
#include <Windows.h>

using namespace std;

int main()
{
	setlocale(LC_ALL, "rus");

	SetConsoleCP(1251);

	SetConsoleOutputCP(1251); 

	cout << "������� �����: ";

	string s;

	getline(cin, s);

	srand(100801);

	for (int i = 0; i < s.size(); i++)
	{
		int k = rand();

		s[i] ^= k;
	}
	cout << "����: " << s << endl;

	srand(100801);

	for (int i = 0; i < s.size(); i++)
	{
		int k = rand();

		s[i] ^= k;
	}
	cout << "��������� �����: " << s << endl;

	return 0;

}