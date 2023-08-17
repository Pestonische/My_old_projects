#include <iostream>
#include <fstream>
#include <string>
#pragma warning(disable : 4996)

using namespace std;

int check(char s[])
{
	int i, length;

	length = strlen(s);

	for (i = 0; i < length; i++)
		if (length == 1)
			return 0;
		else if (s[i] != s[(length - 1) - i])
			return 0;
	return 1;
}
int main()
{
	setlocale(LC_ALL, "rus");

	char* t;

	int d = 0;

	cout << "�������� �������� ����� file.txt" << endl;

	cout << "������� ��� �����: " << endl;

	string name1;

	getline(cin, name1);

	ifstream isxodni(name1);

	if (!isxodni.is_open())
	{
		cout << "���������� ������� ����" << endl;
		return 2;
	}
	cout << "��� ��������� �����, ����������� ���������� (polindrom.txt)" << endl;

	cout << "������� ��� �����: " << endl;

	string name2;

	getline(cin, name2);

	ofstream vxodnoi1(name2);

	cout << "��� ��������� �����, �� ����������� ������ ���������� (nepolindrom.txt)" << endl;

	cout << "������� ��� �����: " << endl;

	string name3;

	getline(cin, name3);

	ofstream vxodnoi2(name3);

	if (isxodni.peek() == EOF)
	{
		cout << "������� ���� �� �������� �����" << endl;
		return 1;
	}
	string s;

	int danet;

	cout << "���� �� ������ ���������� ���������� ������ ������� 1, ���� ��� 0" << endl;

	cin >> danet;

	while (getline(isxodni, s))
	{
		char* a = new char[size(s) + 1];

		for (int i = 0; i < (int)size(s); i++)
		{
			a[i] = s[i];
		}
		a[size(s)] = 0;

		t = strtok(a, " ");

		while (t != NULL)
		{
			if (check(t) == 1)
			{
				d++;
			}
			t = strtok(NULL, " ");
		}
		if (danet)
			cout << "\n������ ��������� �����: " << s << endl;

		if (d == 1)
		{
			if (danet)
			{
				cout << "\n������ ����� (" << name2 << "): " << s << endl;
				vxodnoi1 << s << endl;
			}
			else
				vxodnoi1 << s << endl;
		}
		if (d == 0)
		{
			if (danet)
			{
				cout << "\n������ ����� (" << name3 << "): " << s << endl;
				vxodnoi2 << s << endl;
			}
			else
				vxodnoi2 << s << endl;
		}
		delete[] a;

		d = 0;
	}
	cout << "\n������!" << endl;

	isxodni.close();
	vxodnoi1.close();
	vxodnoi2.close();

	return 0;
}